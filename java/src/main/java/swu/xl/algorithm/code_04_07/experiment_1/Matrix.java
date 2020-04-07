package swu.xl.algorithm.code_04_07.experiment_1;

public class Matrix {

    /**
     * 计算两个矩阵(Matrix_A（n×n）和 Matrix_B（n×n）)相乘
     * @param A
     * @param B
     * @return
     */
    public static int[][] getByDefinition(int[][] A,int[][] B){
        //计算n
        int n = A.length;

        //存储结果的数组
        int[][] R = new int[n][n];

        //计算 R[i][j] = A[i][0] * B[0][j] + A[i][1] * B[1][j] + ... + A[i][n-1] * B[n-1][j]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int t = 0; t < n; t++) {
                    R[i][j] += A[i][t] * B[t][j];
                }
            }
        }

        return R;
    }

    /**
     * 测试程序
     */
    public static void main(String[] args) {
        int [][] A = {{1,2},{3,4}};
        int [][] B = {{1,2},{3,4}};

        int[][] result = getByDefinition(A, B);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
