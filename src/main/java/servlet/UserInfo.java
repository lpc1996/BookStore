package servlet;

import com.google.gson.Gson;
import dao.UserDao;
import entity.UserEntity;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 濃霧-遠方
 */
@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session == null){
            resp.getWriter().write("未登录");
            return;
        }
        String userName=(String)session.getAttribute("userName");
        if(userName == null){
            resp.getWriter().write("未登录");
        }
        UserDao userDao = new UserDao();
        UserEntity user = userDao.getUserInfo(userName);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        Gson gson = new Gson();
        String json = gson.toJson(user);
        resp.getWriter().write(json);
    }

}
