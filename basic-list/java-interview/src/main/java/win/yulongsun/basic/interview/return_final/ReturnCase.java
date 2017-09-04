package win.yulongsun.basic.interview.return_final;

/**
 * @author sunyulong on 2017/3/13.
 */
public class ReturnCase {
    public static void main(String[] args) {
        System.out.println(test());
    }

    private static String test() {
        try {
            return "A";
        } catch (Exception e) {
            return "B";
        } finally {
            return "C";
        }
    }
}
