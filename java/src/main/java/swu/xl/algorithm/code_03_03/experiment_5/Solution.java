package swu.xl.algorithm.code_03_03.experiment_5;

public class Solution {

    /**
     * leetcode P852 山脉数组的峰顶索引
     * @param A
     * @return
     */
    public static int peakIndexInMountainArray(int[] A) {
        int leftIndex = 1;
        int rightIndex = A.length-1;
        int middle = 0;

        while (leftIndex != rightIndex){
            middle = (leftIndex + rightIndex) / 2;

            if (A[middle] > A[middle-1] && A[middle] < A[middle+1]){
                leftIndex = middle+1;
            }else if (A[middle] < A[middle-1] && A[middle] > A[middle+1]) {
                rightIndex = middle-1;
            }else {
                leftIndex = middle;
                break;
            }
        }

        return leftIndex;
    }

    /**
     * Test
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0,1,0}));
        System.out.println(peakIndexInMountainArray(new int[]{0,2,1,0}));
    }
}
