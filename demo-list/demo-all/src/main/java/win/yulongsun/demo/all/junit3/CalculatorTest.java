package win.yulongsun.demo.all.junit3;

import junit.framework.TestCase;

/**
 * @author Sun.YuLong on 2017/11/16.
 */
public class CalculatorTest extends TestCase {
    public void testFail() {
        fail("test fail ");
    }

    public void testAdd() {
        double result = new Calculator().add(1, 2);
        assertEquals(3.0, result);
    }

    public static void main(String[] args) {
        new CalculatorTest().testAdd();
    }
}

class Calculator {
    public double add(double a, double b) {
        return a + b;
    }
}
