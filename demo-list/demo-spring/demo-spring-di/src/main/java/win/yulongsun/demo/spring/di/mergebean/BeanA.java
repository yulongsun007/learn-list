package win.yulongsun.demo.spring.di.mergebean;

/**
 * @author Sun.YuLong on 2018/6/27.
 */
public class BeanA {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BeanA{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
