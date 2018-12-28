package win.yulongsun.demo.basic.java8.FunctionalInterface;

/**
 * @author Sun.YuLong on 2017/10/9.
 */
@FunctionalInterface
interface MyFunctionalInterface<T, R> {
    R getValue(T t);

}
