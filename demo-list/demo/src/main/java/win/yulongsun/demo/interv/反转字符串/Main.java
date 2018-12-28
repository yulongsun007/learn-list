package win.yulongsun.demo.interv.反转字符串;

import java.util.Scanner;

/**
 * Created by sunyulong on 2016/11/17.
 */
public class Main {
    /**
     * 反转句子
     * <p>
     * 输入：
     * 第一行为n（1<n<100）表示测试用例的数目
     * 接下来一共n行，每行包含一个字符串，字符串长度不超过4000，单词与单词之间只有一个空格分隔，句末不会出现标点
     * 句子前后不会出现多余的空格
     * <p>
     * 输出：
     * n行
     * <p>
     * 输入示例：
     * 2
     * you love i
     * i hit you
     * <p>
     * 输出示例：
     * i love you
     * you hit i
     */

    //反转字符
    public static void main(String args[]) {
        //输入
        Scanner scanner = new Scanner(System.in);
        int lineNum = scanner.nextInt();
        String[] container = new String[lineNum + 1];
        for (int i = 0; i <= lineNum; i++) {
            container[i] = scanner.nextLine();
        }
        //遍历
        String[] _container = new String[lineNum + 1];
        for (int i = 1; i <= lineNum; i++) {
            String line = container[i];
            //分割
            String[] split = line.split(" ");
            String[] _Split = new String[split.length];
            for (int j = split.length; j > 0; j--) {
                _Split[split.length - j] = split[j - 1];//注意是j-1
            }
            //合并
            String _line = "";
            for (int j = 0; j < _Split.length; j++) {
                _line = _line + _Split[j] + " ";
            }
            _container[i] = _line.substring(0, _line.length() - 1);
        }
        //输出
        for (int i = 1; i < _container.length; i++) {
            System.out.println(_container[i]);
        }

    }

}
