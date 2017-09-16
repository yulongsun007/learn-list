package win.yulongsun.basic.interview.属性覆盖;

/**
 * @author Sun.Yulong on 2017/9/14.
 */
public class Student extends Person {
    public String name = "student";

    public String pwd ="123";

    @Override
    public void say() {
//        super.say();
        System.out.println("student say");
    }
}
