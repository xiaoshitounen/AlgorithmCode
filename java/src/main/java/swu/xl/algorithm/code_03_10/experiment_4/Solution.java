package swu.xl.algorithm.code_03_10.experiment_4;

public class Solution {
    /**
     * leetcode P344 反转字符串
     * @param s
     */
    public static void reverseString(char[] s) {
        int length = s.length;

        for (int i = 0; i < length / 2 ; i++) {
            char a = s[i];
            char b = s[length-1-i];

            s[i] = b;
            s[length-1-i] = a;
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        reverseString(s);

        System.out.println(s);
    }
}
