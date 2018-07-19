package win.yulongsun.demo.springboot.feature;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Sun.YuLong on 2018/7/19.
 */
@ConfigurationProperties(
        prefix = "demo"
)
public class DemoConfig {
    private String a;
    private String b;
    private FooC fooC = new FooC();

    public FooC getFooC() {
        return fooC;
    }

    public void setFooC(FooC fooC) {
        this.fooC = fooC;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public static class FooC{
        private String c;

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }
    }
}
