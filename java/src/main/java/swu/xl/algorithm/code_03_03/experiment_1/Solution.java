package swu.xl.algorithm.code_03_03.experiment_1;

public class Solution {
    /**
     * leetcode P35 搜索插入位置
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target){
        //划分范围的index
        int leftIndex = 0;
        int rightIndex = nums.length-1;

        while(leftIndex != rightIndex){
            //分
            int middle = (leftIndex+rightIndex) / 2;

            //判断在分开的左边还是右边
            if (nums[middle] >= target){
                //左边 不-1是因为middle可能是解
                rightIndex = middle;
            }else {
                //右边
                leftIndex = middle+1;
            }
        }

        //判断如何插入
//        if (nums[leftIndex] >= target){
//            //leftIndex--;
//        }else {
//            leftIndex++;
//        }
        if (nums[leftIndex] < target){
            leftIndex++;
        }

        return leftIndex;
    }

    /**
     * Test
     */
    public static void main(String[] args) {

        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
    }
}
