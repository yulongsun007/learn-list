package win.yulongsun.demo.basic.java8.InterfaceMethod;

/**
 * @author Sun.YuLong on 2017/10/9.
 */
public interface MyInterfaceDefaultMethod {
    default String getName() {
        return "interface name";
    }
}
