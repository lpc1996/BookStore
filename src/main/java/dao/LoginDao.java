package dao;

import entity.LoginEntity;
import java.util.List;

/**
 * @author 濃霧-遠方
 */
public class LoginDao extends Dao{

    public boolean login(String userName, String password){
        boolean result = false;
        StringBuilder hq = null;
        hq = new StringBuilder();
        hq.append("from ").append(LoginEntity.class.getName());
        hq.append(" WHERE user_id like ?0 AND password like ?1");
        String[] parameters = new String[2];
        parameters[0] = userName;
        parameters[1] = password;
        List<LoginEntity> list = getList(hq.toString(),parameters);
        if(list != null){
            result = true;
        }
        return result;
    }

}
