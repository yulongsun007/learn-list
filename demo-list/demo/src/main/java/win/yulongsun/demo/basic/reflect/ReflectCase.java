package win.yulongsun.demo.basic.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by sunyl21830 on 2017/8/4.
 */
public class ReflectCase {

    public static void main(String[] args) {
        User bean = new User();
        bean.setUsername("zhansgan");
        bean.setPasswd(123);


        HashMap<String, String> map = new HashMap<String, String>();
        map.put("username", "zhansan");
        map.put("username1", "zhansan1");
        map.put("username2", "zhansan2");
        map.put("username3", "zhansan3");
        map.put("username4", "zhansan4");
        try {
            long begin = System.currentTimeMillis();
            Class<?> user = Class.forName("win.yulongsun.demo.basic.reflect.User");
            Field[] fields = user.getDeclaredFields();
            for (Field f : fields) {
//                Annotation[] annotation = f.getAnnotations();
//                System.out.println(f.getAnnotation(XmlField.class));
//                for (Annotation a : annotation) {
//                    if (a.annotationType().equals(XmlField.class)) {
//                        System.out.println(f.getName() + "--" + invokeGet(bean, f.getName()));
//                    }
//                }
                Class<? extends Annotation> annotation = f.getAnnotation(XmlField.class).annotationType();
                if (annotation.equals(XmlField.class)) {
                    System.out.println(f.getName() + "--" + invokeGet(bean, f.getName()));
                }
            }
            System.out.println(System.currentTimeMillis() - begin);

            //
            begin = System.currentTimeMillis();

            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            System.out.println(System.currentTimeMillis() - begin);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行get方法
     *
     * @param o         执行对象
     * @param fieldName 属性
     */
    public static Object invokeGet(Object o, String fieldName) {
        Method method = getGetMethod(o.getClass(), fieldName);
        try {
            return method.invoke(o, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * java反射bean的get方法
     *
     * @param objectClass
     * @param fieldName
     * @return
     */
    public static Method getGetMethod(Class objectClass, String fieldName) {
        StringBuffer sb = new StringBuffer();
        sb.append("get");
        sb.append(fieldName.substring(0, 1).toUpperCase());
        sb.append(fieldName.substring(1));
        try {
            return objectClass.getMethod(sb.toString());
        } catch (Exception e) {
        }
        return null;
    }
}

class User {
    @XmlField
    private String username;
    @XmlField
    private Integer passwd1;
    @XmlField
    private Integer passwd2;
    @XmlField
    private Integer passwd3;
    @XmlField
    private Integer passwd4;
    @XmlField
    private Integer passwd;


    public Integer getPasswd1() {
        return passwd1;
    }

    public void setPasswd1(Integer passwd1) {
        this.passwd1 = passwd1;
    }

    public Integer getPasswd2() {
        return passwd2;
    }

    public void setPasswd2(Integer passwd2) {
        this.passwd2 = passwd2;
    }

    public Integer getPasswd3() {
        return passwd3;
    }

    public void setPasswd3(Integer passwd3) {
        this.passwd3 = passwd3;
    }

    public Integer getPasswd4() {
        return passwd4;
    }

    public void setPasswd4(Integer passwd4) {
        this.passwd4 = passwd4;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPasswd() {
        return passwd;
    }

    public void setPasswd(Integer passwd) {
        this.passwd = passwd;
    }
}
