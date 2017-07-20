package return2;

/**
 * @author sunyulong on 2017/3/13.
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(test());
    }

    private static String test() {
        try {
            return "A";
        }finally {
            return "B";
        }
    }
}
