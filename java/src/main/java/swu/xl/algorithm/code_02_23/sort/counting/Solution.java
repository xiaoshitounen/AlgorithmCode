package swu.xl.algorithm.code_02_23.sort.counting;

public class Solution {
    /**
     * 计数排序
     * @param nums
     */
    public static void countingSort(int[] nums){
        //创建保存两个最值的变量
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找出数组中的最大值，最小值
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }

        //辅助数组
        int[] help = new int[max-min+1];

        //找出每个数字出现的次数
        for (int i = 0; i < nums.length; i++) {
            //将该数字向min看齐，方便计算数字出现的次数
            int temp = nums[i] - min;

            //修改次数
            help[temp]++;
        }

        //模拟目标数组的头指针
        int index = 0;

        //遍历辅助数组，排序
        for (int i = 0; i < help.length; i++) {
            //判断当前位置的数字是否
            while (help[i] > 0){
                //数字还原，赋值
                nums[index++] = i+min;

                //数字记录数减1
                help[i]--;
            }
        }
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9,7,8,10,6,4,3,5,2,1};

        //计数排序
        countingSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
