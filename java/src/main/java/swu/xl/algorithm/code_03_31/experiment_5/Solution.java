package swu.xl.algorithm.code_03_31.experiment_5;


public class Solution {
    /**
     * leetcode P62 不同路径
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        //dp[i][j] 表示从 start 到 (i,j) 处的路线总数
        int[][] dp = new int[m][n];

        //初始化一些数据
        //向下的
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //向右的
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        //遍历每一种情况
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //dp[i-1][j] 到达(i,j)处左一处空格的路线数
                //dp[i][j-1] 到达(i,j)处上一处空格的路线数
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
}
