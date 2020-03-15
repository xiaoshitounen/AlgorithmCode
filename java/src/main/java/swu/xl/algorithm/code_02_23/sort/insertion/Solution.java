package swu.xl.algorithm.code_02_23.sort.insertion;

public class Solution {
    /**
     * 简单插入排序
     * @param nums
     */
    public static void insertionSort(int[] nums){
        //默认第一个排序好 从第二个开始插入 要插入的元素的索引 i
        for(int i = 1; i < nums.length; i++){
            //保存插入的元素
            int insert = nums[i];

            //逆着查找能插入的位置
            int j;
            for(j = i-1; j >= 0; j--){
                //若前面的数大，后移一位
                //当前的位置 j 的元素已经后移，作为待插入的元素
                //这个位置下次循环或者结束循环就变成了 j+1
                if (nums[j] > insert){
                    nums[j+1] = nums[j];
                }else {
                    //找到了排好序的元素中比插入的元素的小的
                    break;
                }
            }

            //插入
            nums[j+1] = insert;
        }
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9,7,8,10,6,4,3,5,2,1};

        //快速
        insertionSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
