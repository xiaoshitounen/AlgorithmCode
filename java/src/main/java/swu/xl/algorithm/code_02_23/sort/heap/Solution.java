package swu.xl.algorithm.code_02_23.sort.heap;

public class Solution {
    /**
     * 堆排序
     * @param nums
     */
    public static void heapSort(int[] nums){
        //建立大根初堆
        createHeap(nums);

        //每次遍历根据最大堆可以得到一个最大数
        for (int i = nums.length-1; i >= 0; i--){
            //将最大的数移到最后
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            //除开已经确定的最大的数，剩下的数重新调整为新的大根堆
            heapAdjust(nums,0,i);
        }
    }

    /**
     * 调整堆
     * @param nums
     * @param s
     * @param length
     */
    public static void heapAdjust(int[] nums, int s, int length){
        //nums[s+1,length) 已经是堆，将 nums[s,length) 范围内的数据调整为以 nums[s] 为根的大根堆

        //保存目前最顶层的根
        int root = nums[s];

        //沿值较大的孩子结点向下筛选
        //假设 左孩子（2(i+1)-1）就是最大的
        for (int j = 2*s+1; j < length; j = j*2+1){
            //判断到底是左孩子大还是右孩子大
            //根据结果调整 j 的值
            if (j+1 < length && nums[j] < nums[j+1]){
                j++;
            }

            //判断当前是否已经是大根堆
            if (root >= nums[j]){
                break;
            }

            //不是的话，交换 左右孩子中大的值 和 root
            nums[s] = nums[j];

            //同样的，nums[j+1,length] 已经是堆，循环筛选调整
            s = j;
        }

        //此时已经调整完毕，j位置插入应该插入的值
        nums[s] = root;
    }

    /**
     * 建初堆
     * @param nums
     */
    public static void createHeap(int[] nums){
        //遍历叶子节点以外的节点，反复调整
        for (int i = nums.length / 2; i > 0; i--){
            //调整
            heapAdjust(nums,i-1, nums.length);
        }
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9,7,8,10,6,4,3,5,2,1};

        //堆排序
        heapSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
