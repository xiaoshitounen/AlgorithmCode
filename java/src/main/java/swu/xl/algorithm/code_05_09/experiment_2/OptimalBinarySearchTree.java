package swu.xl.algorithm.code_05_09.experiment_2;

public class OptimalBinarySearchTree {
    /**
     * 求解最优二叉搜索树
     * @param key_probability 数据概率
     * @param dummy_probability 间隙概率
     * @return 返回最小成本，并打印动态规划的分支矩阵
     */
    public static double getMinCost(double[] key_probability, double[] dummy_probability) {
        //连续概率表
        int n = dummy_probability.length;
        double[][] tab_continue = new double[n][n];
        initContinueTab(tab_continue,key_probability,dummy_probability);
        //for (int i = 0; i < tab_continue.length; i++) {
            //for (int j = 0; j < tab_continue[0].length; j++) {
                //System.out.print(tab_continue[i][j]+" ");
            //}
            //System.out.println();
        //}

        //搜索成本表
        double[][] tab_search = new double[n][n];
        //分叉结点表
        int[][] tab_node = new int[n][n];
        //填入数据
        for (int i = 0; i < n; i++) {
            tab_search[i][i] = dummy_probability[i];
        }
        for(int j=1;j<n;j++){
            for(int i=j-1;i>=0;i--){
                tab_search[i][j] = Double.MAX_VALUE;
                for(int k=i+1;k<=j;k++){
                    if(tab_search[i][j]>tab_search[k][j]+tab_search[i][k-1]+tab_continue[i][j]){
                        tab_search[i][j]=tab_search[k][j]+tab_search[i][k-1]+tab_continue[i][j];
                        tab_node[i][j]=k;
                    }
                }
            }
        }

        //node
        for (int i = 0; i < tab_node.length; i++) {
            for (int j = 0; j < tab_node[0].length; j++) {
                System.out.print(tab_node[i][j]+" ");
            }
            System.out.println();
        }

        return tab_search[0][n-1];
    }

    /**
     * 初始化连续概率表
     * @param tab_continue
     * @param key_probability
     * @param dummy_probability
     */
    private static void initContinueTab(double[][] tab_continue, double[] key_probability, double[] dummy_probability) {
        //先输入对角线的值
        int n = dummy_probability.length;
        for (int i = 0; i < n; i++)
            tab_continue[i][i] = dummy_probability[i];

        //依次填入其他部分的值
        for (int j = 1; j < n; j++){
            for (int i = j-1; i >= 0; i--){
                //System.out.println("i:"+i+" j:"+j);
                for(int p = i; p <= j; p++){
                    tab_continue[i][j] += dummy_probability[p];

                    if (p != i){
                        tab_continue[i][j] += key_probability[p-1];
                    }
                }
            }
        }
    }
}

