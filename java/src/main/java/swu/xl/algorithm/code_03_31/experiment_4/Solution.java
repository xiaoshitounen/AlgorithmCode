package swu.xl.algorithm.code_03_31.experiment_4;

public class Solution {
    /**
     * leetcode P55 跳跃游戏
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        //特殊情况排除
        if (nums == null && nums.length == 0){
            return false;
        }

        //某一个位置是否可以到达 第一个位置已知可以到达
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        //循环找到所有可以到达的结果
        for (int i = 0; i < nums.length; i++) {
            //跳跃的最大高度
            int jump_max = nums[i];

            //当前位置可到达
            if (dp[i]){
                for (int j = 1; j <= jump_max; j++) {
                    //并且没有越界
                    if (i + j < nums.length){
                        //当前位置可以到达
                        dp[i+j] = true;
                    }
                }
            }
        }

        return dp[nums.length-1];
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};

        System.out.println(canJump(nums));

        nums = new int[]{3,2,1,0,4};

        System.out.println(canJump(nums));
    }
}
