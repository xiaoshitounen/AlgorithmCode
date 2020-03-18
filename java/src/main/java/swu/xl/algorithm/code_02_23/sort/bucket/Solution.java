package swu.xl.algorithm.code_02_23.sort.bucket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * 桶排序
     * @param nums
     */
    public static void bucketSort(int[] nums){
        //创建保存两个最值的变量
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找出数组中的最大值，最小值
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }

        //计算桶的数目
        int bucketNum = (max-min)/nums.length+1;
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶中
        for (int i = 0; i < nums.length; i++) {
            //得到应该存放的桶的索引
            int index = (nums[i]-min) / nums.length;

            //加入到对应的桶
            bucket.get(index).add(nums[i]);
        }

        //每个桶内内部排序
        for (int i = 0; i < bucket.size(); i++) {
            Collections.sort(bucket.get(i));
        }

        //改变传来的数组
        int index = 0;
        for (int i = 0; i < bucket.size(); i++) {
            for (int j = 0; j < bucket.get(i).size(); j++) {
                nums[index++] = bucket.get(i).get(j);
            }
        }
    }

    /**
     * 测试程序
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9,7,8,10,6,4,3,5,2,1};

        //桶排序
        bucketSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
