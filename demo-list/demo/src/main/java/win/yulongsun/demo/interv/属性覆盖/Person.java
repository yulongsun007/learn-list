package win.yulongsun.demo.interv.属性覆盖;

/**
 *
 * 1. 上转型对象 可以替代子类对象去调用子类重写的实例方法。
 *
 * 2. 上转型对象 可以调用子类继承的成员变量。
 *
 *
 *
 * @author Sun.Yulong on 2017/9/14.
 */
public class Person {
    public String name = "person";

    public void say(){
        System.out.println("person say");
    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.name);//-->student
        //
        student.say();  //-->student say
        //
        //--------------------------------------------------
        Person person = new Student();
        System.out.println(person.name); //-->person
        //
        person.say(); //-->student say
//        person.pwd //-->编译报错
    }
}
