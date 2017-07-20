package 程序员面试金典.乱串异构;

import org.junit.Test;

public class Same {
    /**
     * 题目描述

     给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串重点空格。
     给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
     测试样例：
     "This is nowcoder","is This nowcoder"
     返回：true
     "Here you are","Are you here"
     返回：false
     */
    @Test
    public void testCheckSam() {
        System.out.println(checkSam("This is nowcoder", "is This nowcoder"));
        System.out.println(checkSam("Here you are", "Are you here"));
    }

    public boolean checkSam(String stringA, String stringB) {
        int[] a = new int[256];
        int[] b = new int[256];
        char[] aArray = stringA.toCharArray();
        char[] bArray = stringB.toCharArray();
        for (int i = 0; i < stringA.length(); i++) {
            a[aArray[i]]++;
            b[bArray[i]]++;
        }
        boolean isSam = true;
        for (int i = 0; i < 256; i++) {
            if (a[i] != b[i])
                isSam = false;
        }

        return isSam;
    }
//    public boolean checkSam(String stringA, String stringB) {
//        String[] aArray = stringA.split(" ");
//        String[] bArray = stringB.split(" ");
//        boolean isSam = false;
//        int count = 0;
//        for (int i = 0; i < aArray.length; i++) {
//            for (int j = 0; j < bArray.length; j++) {
//                if (bArray[j].contentEquals(aArray[i])) {
//                    count++;
//                }
//            }
//        }
//        if (count == aArray.length) {
//            isSam = true;
//        }
//        System.out.println(count);
//        return isSam;
//    }

}