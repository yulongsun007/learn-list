package ems;

import java.lang.reflect.Field;

/**
 * Created by sunyulong on 2016/12/22.
 */
public class UserTest {
    public static void main(String[] args) {
        User user = new User();
        get(user, User.class);
    }

    public static void get(Object obj, Class clazz) {
        Field[] fields = clazz.getFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                System.out.println("name=" + fields[i].getName() + ",value=" + fields[i].get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
