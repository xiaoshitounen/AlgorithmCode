package swu.xl.algorithm.code_04_21.experiment_4;

public class Solution {
    /**
     * leetcode 474. 一和零
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (int p = 0; p < strs.length; p++) {
            //字符串中的0，1个数
            int cost_zero = countStr(strs[p])[0];
            int cost_one = countStr(strs[p])[1];

            for (int i = m; i >= cost_zero; i--) {
                for (int j = n; j >= cost_one; j--) {
                    if (i >= cost_zero && j >= cost_one) {
                        dp[i][j] = Math.max(1 + dp[i - cost_zero][j - cost_one], dp[i][j]);
                    }
                }
            }
        }

        return dp[m][n];
    }

    //求解字符串中0，1的个数
    private static int[] countStr(String s) {
        //存储字符串中0和1的个数
        int[] c = new int[2];

        //依次遍历
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }

        return c;
    }
}
