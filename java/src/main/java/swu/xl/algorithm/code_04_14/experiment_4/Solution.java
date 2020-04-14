package swu.xl.algorithm.code_04_14.experiment_4;

public class Solution {
    /**
     * leetcode P1143. 最长公共子序列
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        //特殊情况
        if (text1.length() == 0 || text2.length() == 0){
            return 0;
        }

        //存储str1对应长度子字符串和str2对应长度子字符串最长共同子序列
        int[][] max_length = new int[text1.length()][text2.length()];
        //System.out.println(max_length.length);

        //初始化一些值
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < 1; j++) {
                max_length[i][j] = text1.charAt(i) == text2.charAt(j) ? 1 : 0;
                if (max_length[i][j] == 0 && i > 0){
                    max_length[i][j] = max_length[i-1][j];
                }
            }
        }
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < text2.length(); j++) {
                max_length[i][j] = text1.charAt(i) == text2.charAt(j) ? 1 : 0;
                if (max_length[i][j] == 0 && j > 0){
                    max_length[i][j] = max_length[i][j-1];
                }
            }
        }

        //初始化其他位置的值
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                max_length[i][j] = text1.charAt(i) == text2.charAt(j) ? max_length[i-1][j-1]+1 : Math.max(max_length[i-1][j],max_length[i][j-1]);
            }
        }

        return max_length[text1.length()-1][text2.length()-1];
    }
}
