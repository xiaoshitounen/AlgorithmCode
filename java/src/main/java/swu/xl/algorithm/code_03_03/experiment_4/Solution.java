package swu.xl.algorithm.code_03_03.experiment_4;

public class Solution {

    /**
     * leetcode P704 二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        int middle = 0;

        while (leftIndex != rightIndex){
            middle = (leftIndex + rightIndex) / 2;

            if (nums[middle] >= target){
                rightIndex = middle;
            }else {
                leftIndex = middle + 1;
            }
        }

        if (nums[leftIndex] == target){
            return leftIndex;
        }

        return -1;
    }

    /**
     * Test
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12},2));
        System.out.println(search(new int[]{-1,0,3,5,9,12},9));
    }
}
