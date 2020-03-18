package swu.xl.algorithm.code_02_23.sort.selection;

public class Solution {
    /**
     * 简单选择排序
     * @param nums
     */
    public static void selectionSort(int[] nums){
        //i 代表 i所在的索引位置按顺序排列应该存放的值
        for (int i = 0; i < nums.length-1; i++) {
            //假设i位置的值就应该放在i出
            int minIndex = i;

            //和后面的数字依次比较，找到 i 位置真正应该存放的值的 索引位置
            for (int j = i+1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]){
                    minIndex = j;
                }
            }

            // i 位置存放真正应该存放的值
            //同时将 i 位置原本存放的值存放在找到最小值的位置
            //即 交换 两处位置的值
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9,7,8,10,6,4,3,5,2,1};

        //简单选择排序
        selectionSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
