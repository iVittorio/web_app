package ru.innopolis.uni;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by i.viktor on 20/11/2016.
 */
public class UserDAO {
    private static Map<String, UserBean> map = new HashMap<>();

    static {
        map.put("testlogin", new UserBean("testlogin", "testpw", "firstname", "lastname", "test@test.ru"));
    }

    public static UserBean login(UserBean bean) {
        String username = bean.getUsername();
        String pw = bean.getPassword();

        if (map.containsKey(username) && map.get(username).getPassword().equals(pw)) {
            bean.setValid(true);
        } else bean.setValid(false);
        UserBean userBean = map.get(username);

        bean.setFirstName(userBean.getFirstName());
        bean.setLastName(userBean.getLastName());
        bean.setEmail(userBean.getEmail());

        return bean;
    }

    public static boolean register(UserBean bean) {
        boolean result;
        String userName = bean.getUsername();
        if (!map.containsKey(userName)) {
            map.put(userName, bean);
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
