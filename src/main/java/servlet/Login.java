package servlet;

import com.google.gson.Gson;
import dao.LoginDao;
import entity.LoginEntity;
import entity.UserEntity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author 濃霧-遠方
 */
@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String resultStr = null;
        boolean loginResult = new LoginDao().login(userName,password);
        if(loginResult){
            resultStr = "登陆成功";
            HttpSession session = request.getSession();
            session.setAttribute("userName",userName);
        }else{
            resultStr="登陆失败";
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        Gson gson = new Gson();
        String json = gson.toJson(resultStr);
        response.getWriter().write(json);
    }
}
