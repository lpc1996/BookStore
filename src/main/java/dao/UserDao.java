package dao;

import entity.UserEntity;
import java.util.List;

/**
 * @author 濃霧-遠方
 */
public class UserDao extends Dao{

    public UserEntity getUserInfo(String userName){
        UserEntity user = null;
        StringBuilder hq = new StringBuilder();
        hq.append("from ").append(UserEntity.class.getName());
        hq.append(" WHERE id like ?0");
        String[] parmeters = new String[1];
        parmeters[0] = userName;
        try {
            List<UserEntity> list = getList(hq.toString(),parmeters);
            if (list.size() == 1) {
                user = list.get(0);
            }
        } catch (Exception e) {
            user = null;
        }
        return user;
    }
}
