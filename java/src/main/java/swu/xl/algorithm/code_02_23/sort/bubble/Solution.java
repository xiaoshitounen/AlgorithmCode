package swu.xl.algorithm.code_02_23.sort.bubble;

public class Solution {
    /**
     * 冒泡排序
     * @param nums
     */
    public static void bubbleSort(int[] nums){
        //标志
        boolean flag = false;

        //一次 i 之后会产生一个最大的数
        for (int i = 0; i < nums.length-1; i++) {
            //j 和 j+1 是待比较的两个元素的索引值
            for (int j = 0; j < nums.length-1-i; j++) {
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;

                    //改变了
                    flag = true;
                }
            }

            //判断是否需要比较
            if (!flag){
                return;
            }
        }
    }

    /**
     * 测试程序
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9,7,8,10,6,4,3,5,2,1};

        //冒泡
        bubbleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
