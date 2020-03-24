package swu.xl.algorithm.code_03_24.experiment_1;

public class MySort {
    /**
     * 选择排序
     * @param originalData
     * @return
     */
    public static int[] selectionSort(int[] originalData){

        //i 代表 i所在的索引位置按顺序排列应该存放的值
        for (int i = 0; i < originalData.length-1; i++) {
            //假设i位置的值就应该放在i出
            int minIndex = i;

            //和后面的数字依次比较，找到 i 位置真正应该存放的值的 索引位置
            for (int j = i+1; j < originalData.length; j++) {
                if (originalData[minIndex] > originalData[j]){
                    minIndex = j;
                }
            }

            // i 位置存放真正应该存放的值
            //同时将 i 位置原本存放的值存放在找到最小值的位置
            //即 交换 两处位置的值
            int temp = originalData[i];
            originalData[i] = originalData[minIndex];
            originalData[minIndex] = temp;
        }

        return originalData;
    }

    /**
     * 归并排序
     * @param originalData
     * @return
     */
    public static int[] mergeSort(int[] originalData){
        mergeSort(originalData,0,originalData.length-1);

        return originalData;
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
     * 快速排序
     * @param originalData
     * @return
     */
    public static int[] quickSort(int[] originalData){
        //存储排好序的数组
        int[] sortedData = originalData.clone();

        quickSortRecursion(sortedData,0,sortedData.length-1);

        return sortedData;
    }

    /**
     * 快速排序 递归
     * @param sortedData
     * @param head
     * @param tail
     */
    public static void quickSortRecursion(int[] sortedData, int head, int tail){
        if (head >= tail){
            return;
        }

        //产生 head 到 tail 的一个索引
        int partitionIndex = head + new java.util.Random().nextInt(tail-head+1);

        //获得新的基准值
        int pivot = partition(sortedData,head,tail,partitionIndex);

        //递归
        quickSortRecursion(sortedData,head,pivot-1);
        quickSortRecursion(sortedData,pivot+1,tail);
    }

    /**
     *
     * @param sortedData
     * @param head
     * @param tail
     * @param partitionIndex
     * @return
     */
    private static int partition(int[] sortedData, int head, int tail, int partitionIndex) {
        //将第一个数和我们选择的基准值交换
        swap(sortedData,head,partitionIndex);

        //模拟指针
        int left = head+1;
        int right = tail;

        while (left < right){
            //从左边往右搜索大于基准值的值
            while (sortedData[left] <= sortedData[head] && left < right){
                left++;
            }

            //从右边往左搜索小于基准值的值
            while (sortedData[right] >= sortedData[head] && left < right){
                right--;
            }

            //如果还可以交换就交换
            if (left < right){
                swap(sortedData,left,right);
            }
        }

        //找到基准值应该回去的位置
        if (sortedData[right] > sortedData[head]){
            partitionIndex = right-1;
            swap(sortedData,head,partitionIndex);
        }else {
            partitionIndex = right;
            swap(sortedData,head,partitionIndex);
        }

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
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9,7,8,10,6,4,3,5,2,1};
        //选择
        for (int i = 0; i < selectionSort(nums).length; i++) {
            System.out.print(selectionSort(nums)[i]+" ");
        }

        nums = new int[]{9,7,8,10,6,4,3,5,2,1};
        //归并
        for (int i = 0; i < mergeSort(nums).length; i++) {
            System.out.print(mergeSort(nums)[i]+" ");
        }

        nums = new int[]{9,7,8,10,6,4,3,5,2,1};
        //快速
        for (int i = 0; i < quickSort(nums).length; i++) {
            System.out.print(quickSort(nums)[i]+" ");
        }
    }
}
