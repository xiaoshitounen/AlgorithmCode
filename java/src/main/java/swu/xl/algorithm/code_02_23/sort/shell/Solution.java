package swu.xl.algorithm.code_02_23.sort.shell;

public class Solution {
    /**
     * 希尔排序
     * @param nums
     */
    public static void shellSort(int[] nums){

    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9,7,8,10,6,4,3,5,2,1};

        //希尔排序
        shellSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
