package swu.xl.algorithm.code_02_23.sort.shell;

public class Solution {
    /**
     * 希尔排序
     * @param nums
     */
    public static void shellSort(int[] nums){
        //i 表示序列的间隔，一直到间隔1，这个时候就只有一个子序列
        //0~i-1
        for (int i = nums.length / 2; i > 0; i /= 2) {
            //从 i 之后每个数字都要进行插入排序，在各自的序列中进行简单的插入排序
            for (int j = i; j < nums.length; j++) {
                //保存插入的元素
                int insert = nums[j];

                //逆着查找能插入的位置
                int k;
                for(k = j-i; k >= 0; k -= i){
                    //若前面的数大，后移一位
                    //当前的位置 j 的元素已经后移，作为待插入的元素
                    //这个位置下次循环或者结束循环就变成了 j+1
                    if (nums[k] > insert){
                        nums[k+i] = nums[k];
                    }else {
                        //找到了排好序的元素中比插入的元素的小的
                        break;
                    }
                }

                //插入
                nums[k+i] = insert;
            }
        }
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
