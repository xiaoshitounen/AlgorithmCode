package swu.xl.algorithm.code_03_17.experiment_3;

public class Solution {
    /**
     * leetcode P53 最大子序和
     * leetcode 面试题42 连续数组的最大和
     * 贪心
     * @param nums
     * @return
     */
    public static int maxSubArrayByGreed(int[] nums) {
        //总的数组的最大子数组和
        int sum = nums[0];

        //以当前节点为终结节点的最大子数组和
        int currentSum = nums[0];

        //一步步贪心
        for (int i = 1; i < nums.length; i++) {
            //是否能够贪心
            currentSum = Math.max(nums[i],currentSum+nums[i]);

            //刷新最大值
            sum = Math.max(sum,currentSum);
        }

        return sum;
    }

    /**
     * leetcode P53 最大子序和
     * leetcode 面试题42 连续数组的最大和
     * 分治
     * @param nums
     * @return
     */
    public static int maxSubArrayByDac(int[] nums) {
        return maxSubArray(nums,0, nums.length-1);
    }

    /**
     * 求左右子数组的最大连续子数组和
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static int maxSubArray(int[] nums, int left, int right){
        //判断数组只有一个元素的情况
        if (left == right) {
            return nums[left];
        }

        //分治处理，划分子串
        int middle = (left+right) / 2;

        //左右子数组最大值
        int leftMax = maxSubArray(nums, left, middle);
        int rightMax = maxSubArray(nums, middle+1, right);

        //包含左右子数组且含索引最大值
        int crossMax = maxCrossSubArray(nums, left, right, middle);

        //返回最大值
        return Math.max(Math.max(leftMax,rightMax),crossMax);
    }

    /**
     * 求包含左右子数组且含索引的最大连续子数组和
     * @param nums
     * @param left
     * @param right
     * @param middle
     * @return
     */
    public static int maxCrossSubArray(int[] nums, int left, int right, int middle){
        //判断数组只有一个元素的情况
        if (left == right) {
            return nums[left];
        }

        //记录当前的和
        int currentSum = 0;

        //从索引处向左边扩展
        int leftSum = Integer.MIN_VALUE;
        for (int i = middle; i >= left; i--){
            currentSum += nums[i];
            leftSum = Math.max(leftSum,currentSum);
        }

        //从索引处向右边扩展
        currentSum = 0;
        int rightSum = Integer.MIN_VALUE;
        for(int i = middle + 1; i <= right; i++){
            currentSum += nums[i];
            rightSum = Math.max(rightSum,currentSum);
        }

        return leftSum+rightSum;
    }

    /**
     * 测试程序
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArrayByGreed(nums));
        System.out.println(maxSubArrayByDac(nums));
    }
}
