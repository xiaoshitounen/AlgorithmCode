package swu.xl.algorithm.code_03_03.experiment_3;

public class Solution extends VersionControl {

    /**
     * leetcode P278 第一个错误的版本
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int leftIndex = 1;
        int rightIndex = n;
        int middle = 0;

        while (leftIndex != rightIndex){
            //防止溢出
            middle = leftIndex/2 + rightIndex/2;

            if (isBadVersion(middle)){
                rightIndex = middle;
            }else {
                leftIndex = middle+1;
            }
        }

        return rightIndex;
    }

    /**
     * Test
     */
    public static void main(String[] args) {
        System.out.println(new Solution().firstBadVersion(5));
    }
}
