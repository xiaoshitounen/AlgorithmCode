package swu.xl.algorithm.code_03_31.experiment_6;

public class Solution {
    /**
     * leetcode p198 打家劫舍
     * @param num
     * @return
     */
    public static int rob(int[] num) {
        //获取数组的长度
        int length = num.length;

        //移除特殊情况
        if (length == 0){
            return 0;
        }

        //当前位置可盗窃的最大值
        int[] dp = new int[length+1];

        //一些初始值的优化
        dp[0] = 0;
        dp[1] = num[0];

        //枚举每一种情况
        for (int i = 2; i <= length; i++) {
            //注意 i 不是索引 是序号
            //dp[i-2]+num[i-1]
            //dp[i-1]
            dp[i] = Math.max(dp[i-2]+num[i-1],dp[i-1]);
        }

        return dp[length];
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};

        System.out.println(rob(nums));
    }
}
