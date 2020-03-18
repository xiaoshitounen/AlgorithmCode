package swu.xl.algorithm.code_02_23.sort.radix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 基数排序
     * @param nums
     */
    public static void radixSort(int[] nums){
        //找到最大数
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (max < num){
                max = num;
            }
        }

        //从个位开始，对数组进行排序
        for (int i = 1; max / i > 0; i *= 10){
            //存储待排序的临时数组
            int[] temp = new int[nums.length];

            //范围个数桶 10进制的：0,1,2,3,4,5,6,7,8,9
            List[] bucket = new List[10];
            for (int j = 0; j < 10; j++) {
                bucket[j] = new ArrayList<>();
            }

            //将数据出现的次数存储在桶里面
            for (int num : nums) {
                //从最低位(个位)开始
                bucket[(num / i) % 10].add(num);
            }

            //将数据存储到临时数组中
            int index = 0;
            for(int j = 0; j < 10; j++){
                //依次取出桶里面的每一个数据
                for (int k = 0; k < bucket[j].size(); k++) {
                    temp[index++] = (Integer) bucket[j].get(k);
                }
            }

            //将有序元素temp赋给nums2
            System.arraycopy(temp, 0, nums, 0, nums.length);
        }
    }

    /**
     * 测试程序
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9,87,18,20,6,34,3,65,22,61};

        //基数
        radixSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
