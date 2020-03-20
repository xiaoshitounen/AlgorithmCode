package swu.xl.algorithm.code_03_17.experiment_4;

public class Solution {
    /**
     * leetcode P152 乘积最大子序列
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums){
        //总的数组的最大乘积
        int max = Integer.MIN_VALUE;

        //以当前节点为根节点的最大子数组的最大乘积
        int subMax = 1;

        //由于存在负数，那么会导致最大的变最小的，最小的变最大的。
        //因此还需要维护 以当前节点为根节点的最大子数组的最小乘积
        int subMin = 1;

        //枚举数组
        for (int i = 0; i < nums.length; i++) {
            //负数的处理
            if (nums[i] < 0){
                int temp = subMax;
                subMax = subMin;
                subMin = temp;
            }

            //根据遍历的结点刷新到以当前节点为终结节点的最大值，最小值
            subMax = Math.max(nums[i], nums[i] * subMax);
            subMin = Math.min(nums[i], nums[i] * subMin);

            //更新最大值
            max = Math.max(subMax, max);
        }

      return max;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }
}
