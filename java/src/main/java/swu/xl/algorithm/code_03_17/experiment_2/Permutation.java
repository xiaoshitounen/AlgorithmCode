package swu.xl.algorithm.code_03_17.experiment_2;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode P46
 */
class Permutation {
    public static List<int[]> permute(int[] nums) {
        //创建一个集合用于返回
        List<int[]> perms = new ArrayList<>();

        //调用函数得到想要的结果
        permute_recursion(nums,0,perms);

        return perms;
    }

    private static void permute_recursion(int[] nums, int start_index, List<int[]> perms) {
        int length = nums.length;

        //当最后一位时，将得到的一个结果加入到返回的集合中
        if (start_index == length-1){
            int[] perm = new int[length];

            for (int i = 0; i < length; i++) {
                perm[i] = nums[i];
            }

            perms.add(perm);
        }else {
            //从数组没有确定位置的数字索引开始到数组最后一位的索引
            for (int i = start_index; i <= length - 1; i++) {
                //打好标记
                swap(nums,start_index,i);
                //回溯
                permute_recursion(nums,start_index+1,perms);
                //取消标记
                swap(nums,start_index,i);
            }
        }
    }

    /**
     * nums数组中交换索引为i和j两处的元素
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
