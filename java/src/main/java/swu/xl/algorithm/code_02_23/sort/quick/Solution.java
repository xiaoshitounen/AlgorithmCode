package swu.xl.algorithm.code_02_23.sort.quick;

public class Solution {
    /**
     * 快速排序
     * @param nums
     * @param low
     * @param high
     */
    public static void quickSort(int[] nums, int low, int high){
        //区间只有一个元素了 结束
        if (low >= high){
            return;
        }

        //设置索引值
        int left = low;
        int right = high;

        //设置基准点
        int pivot = nums[left];

        //当区间元素超过一个时
        while (left < right){
            //下面的遍历还需要 left < right，是为了防止极端情况

            //从区间的右边遍历，只要大于基准就不需要移动
            while (left < right && nums[right] > pivot){
                right--;
            }
            //此时，必定出现了需要向左移动的元素
            nums[left] = nums[right];

            //从区间的左边遍历，只要小于基准就不需要移动
            while (left < right && nums[left] < pivot){
                left++;
            }
            //此时，必定出现了需要向右移动的元素
            nums[right] = nums[left];
        }

        //结束循环时，只有一个可能，left == right, 将基准值填入
        nums[left] = pivot;

        //递归
        quickSort(nums, low, left-1);
        quickSort(nums, left+1, high);
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,5,2,1};

        //快速
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
