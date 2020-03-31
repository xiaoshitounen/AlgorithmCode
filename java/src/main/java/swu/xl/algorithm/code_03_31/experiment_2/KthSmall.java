package swu.xl.algorithm.code_03_31.experiment_2;

public class KthSmall {

    /**
     * 普通排序的方法
     * @param data
     * @param k
     * @return
     */
    public static int getKthSmallBySorting(int[] data, int k) {
        //排序
        mergeSort(data,0,data.length-1);

        return data[k-1];
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
     * 快速查找的方法
     * @param a
     * @param k
     * @return
     */
    public static int getKthSmallByDivideConquer(int[] a, int k) {
        //数组克隆
        int[] data = a.clone();

        return data[getKthSmallBYDivideConquer(data,0,data.length-1,k)];
    }

    /**
     * 快速查找 递归
     * @param data
     * @param head
     * @param tail
     * @param k
     * @return
     */
    private static int getKthSmallBYDivideConquer(int[] data, int head, int tail, int k) {
        //递归结束的条件
        if (head == tail) {
            return head;
        } else {
            //获得基准值的索引
            int partitionIndex = randomPartition(data,head,tail);

            if (partitionIndex < k-1){
                //说明此时找的数字比要找的数字还要小，所以向右区间寻找
                return getKthSmallBYDivideConquer(data,partitionIndex+1,tail,k);
            }else if (partitionIndex > k-1){
                //说明此时找的数字比要找的数字还要大，所以向左区间寻找
                return getKthSmallBYDivideConquer(data,head,partitionIndex-1,k);
            }else {
                //恰好找到
                return partitionIndex;
            }
        }
    }

    /**
     * 返回当前基准值在数组中的索引值
     * @param data
     * @param head
     * @param tail
     * @return
     */
    private static int randomPartition(int[] data, int head, int tail) {
        //产生一个随机数 基准值
        int partitionIndex = head + new java.util.Random().nextInt(tail-head+1);

        //交换第一个和随机产生的索引的数字
        //将基准值调成第一个元素
        swap(data,head,partitionIndex);

        //确定模拟的头尾指针
        int left = head+1;
        int right = tail;

        //左右模拟
        while (left < right) {
            //从左边一直找，小于基准值的数的索引
            while (data[left] <= data[head] && left < right){
                left++;
            }

            //从右边一直找，大于基准值的数的索引
            while (data[right] >= data[head] && left < right){
                right--;
            }

            //如果头尾指针还没有碰头
            if (left < right){
                //交换位置
                swap(data,left,right);
            }
        }

        //说明此时跳出循环 left = right
        //需要将基准值放回去
        //需要判断left（right）此处是否可以防止
        if (data[left] > data[head]){
            partitionIndex = right-1;
        }else {
            partitionIndex = right;
        }

        //将基准值交换获取
        swap(data,head,partitionIndex);

        return partitionIndex;
    }

    /**
     * nums数组中交换索引为i和j两处的元素
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    /**
     * 测试程序
     */
    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,4,5};

        System.out.println(getKthSmallBySorting(data,2));
        System.out.println(getKthSmallByDivideConquer(data,2));
    }
}
