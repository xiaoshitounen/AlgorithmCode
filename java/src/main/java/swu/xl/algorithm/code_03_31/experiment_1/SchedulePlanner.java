package swu.xl.algorithm.code_03_31.experiment_1;

public class SchedulePlanner {

    /**
     * 求解时间安排
     * @param k
     * @return
     */
    public static int[][] getSchedule(int k){
        //获取所有的比赛人数
        int n = (int) Math.pow(2,k);
        //创建存储数据的数组
        int[][] schedule = new int[n][n];
        schedule[0][0] = 1;

        //4->8->16，依次复制矩阵
        for (int p = 1; p <= k; p++) {
            //开始的索引
            int newStartIndex = (int) Math.pow(2,p-1);

            //求解范围的长度
            int newLength = newStartIndex * 2;

            //对角线矩阵复制
            matrixCopy(schedule,0,0,newStartIndex,newStartIndex,newLength/2);

            //邻对角线加和复制
            matrixCopyAdd(schedule,0,0,0,newStartIndex,newLength/2,newLength/2);
            matrixCopyAdd(schedule,0,0,newStartIndex,0,newLength/2,newLength/2);
        }

        return schedule;
    }

    /**
     * 对角线复制
     * @param matrix
     * @param i_s
     * @param j_s
     * @param i_d
     * @param j_d
     * @param num
     */
    private static void matrixCopy(int[][] matrix,int i_s,int j_s,int i_d,int j_d,int num){
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                matrix[i_d+i][j_d+j] = matrix[i_s+i][j_s+j];
            }
        }
    }

    /**
     * 邻矩阵复制（加和）
     * @param matrix
     * @param i_s
     * @param j_s
     * @param i_d
     * @param j_d
     * @param num
     * @param add
     */
    private static void matrixCopyAdd(int[][] matrix,int i_s,int j_s,int i_d,int j_d,int num,int add){
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                matrix[i_d+i][j_d+j] = matrix[i_s+i][j_s+j] + add;
            }
        }
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        int[][] schedule = getSchedule(3);

        int row = schedule.length;
        int col = schedule[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(schedule[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
