package win.yulongsun.demo.interv.程序员面试金典.字符串压缩;

import org.junit.Test;

/**
 * Created by : yulongsun
 * Date on : 2016/9/9
 * Desc : 基本字符串压缩
 * 题目描述
 * <p>
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
 * 比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。
 * 若压缩后的字符串没有变短，则返回原先的字符串。
 * 给定一个string iniString为待压缩的串(长度小于等于10000)，保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
 * <p>
 * 测试样例
 * "aabcccccaaa"
 * 返回："a2b1c5a3"
 * "welcometonowcoderrrrr"
 * 返回："welcometonowcoderrrrr"
 */
public class Zipper {
    public String zipString(String iniString) {
        // write code here
        if (iniString == null || iniString.trim().length() == 0) {
            return "";
        }
        StringBuilder strB   = new StringBuilder("");
        char[]        iniStr = iniString.toCharArray();
        char          pre;
        pre = iniStr[0];
        int count = 1;
        for (int i = 1; i < iniStr.length; i++) {
            if (pre == iniStr[i]) {
                count++;
            } else {
                strB.append(pre + "" + count);
                pre = iniStr[i];
                count = 1;
            }
        }
        strB.append(pre + "" + count);
        if (strB.toString().length() >= iniString.length()) {
            return iniString;
        }
        return strB.toString();
    }

    @Test
    public void testZipString() {
        System.out.println(zipString("aabcccccaaa"));
    }
}
