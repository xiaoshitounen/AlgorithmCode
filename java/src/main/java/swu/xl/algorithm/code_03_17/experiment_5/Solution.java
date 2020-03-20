package swu.xl.algorithm.code_03_17.experiment_5;

public class Solution {
    /**
     * leetcode 面试17.24 最大子矩阵
     * @param matrix
     * @return
     */
    public static int[] getMaxMatrix(int[][] matrix) {
        //矩阵的行数
        int row = matrix.length;
        //矩阵的列数
        int col = matrix[0].length;

        //最值
        int answerMax = Integer.MIN_VALUE;

        //位置数组
        int[] answerArray = new int[4];

        //列上的前缀合
        int[][] colPrefix = new int[row][col];
        for (int i = 0; i < col; i++) {
            //第一行各项的前缀合
            colPrefix[0][i] = matrix[0][i];

            //第二行之后的各项前缀合
            for (int j = 1; j < row; j++) {
                colPrefix[j][i] = colPrefix[j-1][i] + matrix[j][i];
            }
        }

        //临时数组，用来保存接下来转化的一维数组
        int[] temp = new int[col];

        //依次枚举每一种转化的情况
        for (int fromRow = 0; fromRow < row; fromRow++) {
            for (int toRow = fromRow; toRow < row; toRow++) {
                //fromRow到toRow进行合并
                for (int i = 0; i < col; i++) {
                    temp[i] = fromRow == 0 ? colPrefix[toRow][i] : colPrefix[toRow][i] - colPrefix[fromRow-1][i];
                }

                //求解每一种情况的最大子数组和
                int[] maxArrayResult = getMaxArray(temp);

                //刷新最大的情况
                int max = maxArrayResult[0];
                int maxFromCol = maxArrayResult[1];
                int maxToCol = maxArrayResult[2];
                if (max > answerMax){
                    answerMax = max;

                    answerArray[0] = fromRow;
                    answerArray[1] = maxFromCol;
                    answerArray[2] = toRow;
                    answerArray[3] = maxToCol;
                }
            }
        }

        return answerArray;
    }

    /**
     * 求解一维数组的最大子数组和
     * @param nums
     * @return
     */
    private static int[] getMaxArray(int[] nums) {
        //上一个以当前节点为终结节点的最大子数组和
        int preMax = nums[0];

        //当前的以当前节点为终结节点的最大子数组和
        int max = nums[0];

        //真正的起止列数
        int realFromCol = 0;
        int realToCol = 0;

        //临时的开始列数
        int fromCol = 0;

        //枚举
        for (int i = 1; i < nums.length; i++) {
            if (preMax <= 0){
                preMax = nums[i];

                //如果需要刷新最大值和起止列
                if (preMax > max){
                    max = preMax;

                    realFromCol = i;
                    realToCol = i;
                }

                //起始列发生了变化
                fromCol = i;
            }else {
                preMax = preMax + nums[i];

                //如果需要刷新最大值
                if (preMax > max){
                    max = preMax;

                    realFromCol = fromCol;
                    realToCol = i;
                }
            }
        }

        return new int[]{max, realFromCol, realToCol};
    }

    /**
     * 测试程序
     */
    public static void main(String[] args) {
        //int[][] matrix = {{1,2,3,4},{5,6,7,8},{7,8,9,10}};

        //int[][] matrix = {{-1,0},{0,-1}};

        int[][] matrix = {{8, -4, 5}, {-1, 4, 4}, {-2, 3, 1}, {-4, 4, 3}};

        for (int i = 0; i < getMaxMatrix(matrix).length; i++) {
            System.out.println(getMaxMatrix(matrix)[i]);
        }
    }
}
