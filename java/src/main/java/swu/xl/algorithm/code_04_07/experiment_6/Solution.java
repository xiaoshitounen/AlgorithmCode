package swu.xl.algorithm.code_04_07.experiment_6;

public class Solution {
    /**
     * leetcode 213. 打家劫舍 II
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        //排除特殊情况
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }

        //不偷最后一个房子和不投第一个房子
        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
    }

    /**
     * 求解
     * @param nums
     * @param head
     * @param tail
     * @return
     */
    public static int rob(int[] nums, int head, int tail){
        //dp[i]: 前 i 间房间能偷窃的最大价值
        int[] dp = new int[tail-head+1+1];

        //前0间房间的最大偷窃价值是 0
        dp[0] = 0;

        //前1间房间的最大偷窃价值是 num[head]
        dp[1] = nums[head];

        //遍历得出每一个位置的情况 最后一个位置的情况tail-head+1
        //（如果是索引就是tail-head，序号就是tail-head+1）
        for (int i = 2; i <= tail-head+1; i++){
            //注意这里的 i 是序号
            //如果是索引，这里是num[i]
            //因为是序号，所以是num[i-1]
            //但是数组是以head为起始索引，所以i-1+head
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1+head]);
            //dp[i-1]:前i-1个位置能偷窃的最大价值
            //dp[i-2]+num[i-1+head]:前i-2个位置能偷窃的最大价值+当前位置的价值
        }

        return dp[tail-head+1];
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,3,2};

        System.out.println(rob(nums1));

        int[] nums2 = new int[]{1,2,3,1};

        System.out.println(rob(nums2));
    }
}
