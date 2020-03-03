package swu.xl.algorithm.code_02_25.experiment_4;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

public class LeetCode {

    public static void main(String[] args) {
        System.out.println(Solution912.sortArray(new int[]{5,2,3,1}).size());
    }
}

class Solution509 {
    public static int fib(int N) {
        if(N == 0){
            return 0;
        }

        if(N == 1){
            return 1;
        }

        return fib(N-1) + fib(N-2);
    }
}

class Solution912 {
    public static List<Integer> sortArray(int[] nums) {
        int[] temp = new int[nums.length];

        sort(nums, 0, nums.length-1, temp);

        System.out.println(nums.length);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        System.out.println(list.size());

        return list;
    }

    public static void sort(int[] nums, int left, int right, int[] temp){
        if (left < right){
            int mid = (left+right) / 2;

            sort(nums, left, mid, temp);
            sort(nums, mid+1, right, temp);

            merge(nums, left, right, mid, temp);
        }
    }

    public static void merge(int[] nums, int left, int right, int mid, int[] temp){
        int i = left;
        int j = mid+1;
        int index = 0;

        while(i <= mid && j <= right){
            if(nums[i] > nums[j]){
                temp[index++] = nums[j++];
            }else {
                temp[index++] = nums[i++];
            }
        }

        while(i <= mid){
            temp[index++] = nums[i++];
        }

        while (j <= right){
            temp[index++] = nums[j++];
        }

        index = 0;
        while (left <= right){
            nums[left++] = temp[index++];
        }
    }
}
