package swu.xl.algorithm.code_05_09.experiment_1;

import java.util.LinkedList;

public class MinTriagulation {
    /**
     * 计算给定的三个点组成的三角形的边长
     * @param points
     * @param i
     * @param j
     * @param k
     * @return
     */
    private static double cost(double[][] points, int i, int j, int k){
        return Math.sqrt(Math.pow(points[i][0]-points[k][0],2) + Math.pow(points[i][1]-points[k][1],2)) +
                Math.sqrt(Math.pow(points[i][0]-points[j][0],2) + Math.pow(points[i][1]-points[j][1],2)) +
                 Math.sqrt(Math.pow(points[j][0]-points[k][0],2) + Math.pow(points[j][1]-points[k][1],2));
    }

    /**
     * 求解凸多边形最优三角剖分问题
     * @param points
     * @return 返回剖分方案和最小剖分成本
     */
    public static Answer getPartition(double[][] points) {
        //多边形点的个数 或者 边数
        int n = points.length;

        //表格法的剖分成本表
        double[][] tab_cost = new double[n][n];
        //表格法的剖分方案表
        int[][] tab_split = new int[n][n];

        //求解表格
        for (int j = 2; j < n; j++) {
            for (int i = j-2; i >= 0; i--){
                //设置默认值
                tab_cost[i][j] = Double.MAX_VALUE;

                //求解某一个位置的最佳值 可能有很多种方案
                for (int k = i + 1; k <= j-1; k++){

                    if (tab_cost[i][j] > (cost(points,i,j,k) + tab_cost[i][k] + tab_cost[k][j]) || tab_cost[i][j] == 0){
                        tab_cost[i][j] = cost(points,i,j,k) + tab_cost[i][k] + tab_cost[k][j];
                        tab_split[i][j] = k;
                    }
                }
            }
        }

        //求解剖分方案
        LinkedList<Edge> partition = new LinkedList<>();
        trackback(tab_split,partition,0,n-1);

        return new Answer(partition,tab_cost[0][n-1]);
    }

    /**
     * 求解剖分方案
     * @param tab_split
     * @param partition
     * @param i
     * @param j
     */
    private static void trackback(int[][] tab_split, LinkedList<Edge> partition, int i, int j) {
        if (j-i > 2){

            if (j - tab_split[i][j] == 1){
                partition.add(new Edge(i,tab_split[i][j]));

                trackback(tab_split,partition,i,tab_split[i][j]);
            }

            if (tab_split[i][j] - i == 1){
                partition.add(new Edge(tab_split[i][j],j));

                trackback(tab_split,partition,tab_split[i][j],j);
            }
        }
    }
}
