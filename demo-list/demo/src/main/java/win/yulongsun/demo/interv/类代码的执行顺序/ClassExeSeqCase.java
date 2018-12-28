package win.yulongsun.demo.interv.类代码的执行顺序;

/**
 * Class方法的加载顺序:
 *
 * @author Sun.Yulong on 2017/9/14.
 */
public class ClassExeSeqCase {
    {
        System.out.println("我是构造代码块....");
    }

    static {
        System.out.println("我是静态代码块....");
    }

    public ClassExeSeqCase() {
        System.out.println("我是构造方法....");
    }

    public static void main(String[] args) {
        System.out.println("我是main方法");

    }
}
