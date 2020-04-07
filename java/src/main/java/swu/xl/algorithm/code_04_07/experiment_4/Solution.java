package swu.xl.algorithm.code_04_07.experiment_4;

public class Solution {
    /**
     * leetcode 跳跃游戏 II
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        //记录当前能够跳跃的最大距离
        int current_most_large = 0;
        //记录跳跃的边界
        int current_jump_end = 0;
        //记录跳跃的步数
        int step = 0;

        //因为第一次已经跳跃，所以最后一次nums.lemgth-1不用枚举了
        for (int i = 0; i < nums.length - 1; i++) {
            //刷新当前能够跳跃的最大距离
            //新位置能够跳跃的最大距离：i+nums[i]
            //是指自上一次的边界后能跳跃的最大距离
            current_most_large = Math.max(current_most_large,i+nums[i]);

            //是否是第一次跳或者跳到了边界（到了边界就要跳跃了）
            if (i == current_jump_end){
                //跳跃
                step++;

                //更新边界
                //边界一定大于当前的位置 i
                //不然就永远跳不出去
                //也就不符合题目的 总是可以到达数组的最后一个位置。
                current_jump_end = current_most_large;
            }
        }

        return step;
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};

        System.out.println(jump(nums));
    }
}
