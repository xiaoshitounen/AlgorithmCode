package swu.xl.algorithm.code_03_24.experiment_4;

public class Solution {
    /**
     * leetcode P215 数组中的第k个最大元素
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        //排序
        mergeSort(nums,0,nums.length-1);

        return nums[nums.length-k];
    }

    /**
     * 归并排序 递归
     * @param nums
     * @param start
     * @param end
     */
    public static void mergeSort(int[] nums,int start,int end){
        //只要划分的区间长度仍然不为1
        if (start != end){
            int middle = (start+end) / 2;

            //分
            mergeSort(nums,start,middle);
            mergeSort(nums,middle+1,end);

            //治
            merge(nums,start,end,middle);
        }
    }

    /**
     * 归并
     * @param nums
     * @param start
     * @param end
     * @param middle
     */
    public static void merge(int[] nums,int start,int end,int middle){
        //模拟第一个序列的头指针
        int i = start;

        //模拟第二个序列的头指针
        int j = middle+1;

        //模拟临时数组的头指针
        int t = 0;

        //创建临时数组
        int[] temp = new int[end-start+1];

        //从头比较两个序列，小的放入临时数组temp
        while (i <= middle && j <= end){
            //比较大小
            if (nums[i] < nums[j]){
                //前一个序列
                temp[t++] = nums[i++];
            }else {
                //后一个序列
                temp[t++] = nums[j++];
            }
        }

        //单独处理没有处理完的第一个序列
        while (i <= middle){
            temp[t++] = nums[i++];
        }

        //单独处理没有处理完的第二个序列
        while (j <= end){
            temp[t++] = nums[j++];
        }

        //将临时数组的值赋值到原数组
        for (int p = 0; p < temp.length; p++) {
            nums[start+p] = temp[p];
        }
    }

    /**
     * 测试程序
     */
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
