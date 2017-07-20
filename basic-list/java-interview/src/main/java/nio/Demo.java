package nio;

/**
 * @author sunyulong on 2017/1/19.
 */
public class Demo {
    public static void main(String[] args) {
        zhansan:
        for (int i = 0; i < 10; i++) {
            if (i == 1) {
                System.out.println("break to zhangsan");
                break;
            }
            lisi:
            for (int j = 0; j < 20; j++) {
                System.out.println("j=" + j);
                wangwu:
                for (int k = 0; k < 30; k++) {
                    System.out.println("k==" + k);
                    if (k == 10) {
                        System.out.println("k=10,break to wangwu");
                        break lisi;
                    }
                }
            }

        }
    }
}
