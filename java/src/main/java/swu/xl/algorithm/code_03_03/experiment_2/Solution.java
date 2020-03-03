package swu.xl.algorithm.code_03_03.experiment_2;

public class Solution {
    /**
     * leetcode P74 搜索二位矩阵
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        //获取行 列值
        int row = matrix.length;
        //判断是否有元素
        if (row == 0){
            return false;
        }
        int col = matrix[0].length;
        if (col == 0){
            return false;
        }

        //判断在哪一行
        int index = 0;
        for (int i = 0; i < row; i++) {
            if (matrix[i][col-1] >= target){
                //找到了行
                index = i;
                //System.out.println(index);

                //退出循环
                break;
            }
        }

        //正常的二分
        int leftIndex = 0;
        int rightIndex = col-1;
        //寻找
        while (leftIndex != rightIndex){
            int middle = (leftIndex + rightIndex) / 2;

            if (matrix[index][middle] >= target){
                rightIndex = middle;
            }else {
                leftIndex = middle+1;
            }
        }
        //判断是不是
        if (matrix[index][leftIndex] == target){
            return true;
        }

        return false;
    }

    /**
     * Test
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,50}},3));
        System.out.println(searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,50}},13));
    }
}
