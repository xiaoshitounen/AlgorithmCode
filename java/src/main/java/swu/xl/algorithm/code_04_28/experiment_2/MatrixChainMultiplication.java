package swu.xl.algorithm.code_04_28.experiment_2;

public class MatrixChainMultiplication {
    /**
     * 求解矩阵连续乘的问题
     * @param dims
     * @return
     */
    public static int getMinMultiplicationNum(int[] dims){
        //表格的长度
        int n = dims.length-1;

        //记录连乘结果最小值的表格
        int[][] tab_num = new int[n][n];

        //记录连乘结果最小值时，划分的界限的后一个位置
        int[][] tab_split = new int[n][n];

        //求解出表格
        for (int j = 1; j < n; j++){
            for (int i = j-1; i >= 0; i--){
                //先确认num表的初值
                tab_num[i][j] = tab_num[i][j-1] + dims[i] * dims[j] * dims[j+1];
                //再确认split表的初值
                tab_split[i][j] = j;

                //从所有可能中找到最小的
                for (int k = i+1; k < j; k++){
                    //记录新的一种搭配的值
                    //前半段：tab_num[i][k-1]
                    //后半段：tab_num[k][j]
                    int temp = tab_num[i][k-1] + tab_num[k][j] +  dims[i] * dims[k] * dims[j+1];

                    //判断是不是更优解
                    if (temp < tab_num[i][j]){
                        tab_num[i][j] = temp;
                        tab_split[i][j] = k;
                    }
                }
            }
        }

        //打印两个表格的数据
        for (int i = 0; i < tab_num.length; i++) {
            for (int j = 0; j < tab_num[0].length; j++) {
                String str = String.format("%-3s", tab_num[i][j]);
                System.out.print(str+"  ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < tab_split.length; i++) {
            for (int j = 0; j < tab_split[0].length; j++) {
                String str = String.format("%-3s", tab_split[i][j]);
                System.out.print(str+"  ");
            }
            System.out.println();
        }

        //递归求解结果
        trackBack(tab_split,0,n-1);
        System.out.println();

        return tab_num[0][n-1];
    }

    /**
     * 递归求解分割方法
     * @param tab_split
     * @param head
     * @param tail
     */
    private static void trackBack(int[][] tab_split, int head, int tail) {
        if (head == tail) {
            System.out.print("A"+(head+1));
        }
        else {
            System.out.print("(");
            trackBack(tab_split,head,tab_split[head][tail]-1);
            trackBack(tab_split,tab_split[head][tail],tail);
            System.out.print(")");
        }
    }
}
