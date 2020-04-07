package swu.xl.algorithm.code_04_07.experiment_2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最近点对问题
 */
public class ClosestPair {

    /**
     * 暴力求解最近点对的距离
     * @param points
     * @return
     */
    public static double getByBruteForce(double[][] points){
        //获得数组的长度
        int n = points.length;

        //假设前两个点的距离最小
        double minDis = getDistance(points,0,1);

        //封装这两个点
        int[] minIndex = new int[]{0,1};

        //枚举所有可能的距离
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                //如果找到更小的距离
                if(getDistance(points,i,j) < minDis){
                    //更换最小值
                    minDis = getDistance(points,i,j);

                    //更新封装的数据
                    minIndex[0] = i;
                    minIndex[1] = j;
                }
            }
        }

        //System.out.println("B坐标:"+points[minIndex[0]][0]+" "+points[minIndex[0]][1]+"|"+points[minIndex[1]][0]+" "+points[minIndex[1]][1]);

        return minDis;
    }

    /**
     * 求解二维平面两个点之间的距离
     * @param points
     * @param i
     * @param j
     * @return
     */
    private static double getDistance(double[][] points, int i, int j) {
        return Math.sqrt((points[i][0]-points[j][0])*(points[i][0]-points[j][0]) + (points[i][1]-points[j][1])*(points[i][1]-points[j][1]));
    }

    /**
     * 分治法求解最近点对的问题
     * @param points
     * @return
     */
    public static double getByDivideConquer(double[][] points){
        //对数组进行横坐标升序
        sortDoubleArray(points);

//        for (int i = 0; i < points.length; i++) {
//            for (int j = 0; j < points[0].length; j++) {
//                System.out.print(points[i][j]+" ");
//            }
//            System.out.println("");
//        }

        //求解出最小距离的两个点的距离
        int[] minIndex = getByDivideConquer(points, 0, points.length-1);

        //System.out.println("R坐标:"+points[minIndex[0]][0]+" "+points[minIndex[0]][1]+"|"+points[minIndex[1]][0]+" "+points[minIndex[1]][1]);

        return getDistance(points,minIndex[0],minIndex[1]);
    }

    /**
     * 二维数组按照第一列排序
     * @param points
     */
    private static void sortDoubleArray(double[][] points){
        Arrays.sort(points, new Comparator<double[]>() {
            @Override
            public int compare(double[] point_a, double[] point_b) {
                if (point_a[0] > point_b[0]){
                    return 1;
                }else if (point_a[0] < point_b[0]){
                    return -1;
                }

                return 0;
            }
        });
    }

    /**
     * 求解排好序的最近点对
     * @param points
     * @param head
     * @param tail
     * @return
     */
    private static int[] getByDivideConquer(double[][] points, int head, int tail){
        //开始默认的最小距离值
        double minDist = getDistance(points,head,head+1);
        //开始默认的最小距离的两个点的坐标
        int[] minIndex = new int[]{head,head+1};

        //判断数据范围
        if (tail-head+1 <= 4){
            //数据不超过四个直接暴力求解（枚举每一种可能）
            for (int i = head; i <= tail - 1; i++) {
                for (int j = i+1; j <= tail; j++) {
                    //如果出现了更小的情况
                    if (getDistance(points,i,j) < minDist){
                        minDist = getDistance(points,i,j);
                        minIndex[0] = i;
                        minIndex[1] = j;
                    }
                }
            }

        }else {
            //数据超过四个分治求解

            //求解左边最小值的两个点的坐标 以及 最小距离
            int[] minIndexLeft = getByDivideConquer(points, head, (head + tail) / 2);
            double minDistLeft = getDistance(points, minIndexLeft[0], minIndexLeft[1]);

            //求解右边最小值的两个点的坐标 以及 最小距离
            int[] minIndexRight = getByDivideConquer(points, (head + tail) / 2 + 1, tail);
            double minDistRight = getDistance(points, minIndexRight[0], minIndexRight[1]);

            //左右两边最小的距离
            double minDistTwoSide = Math.min(minDistLeft,minDistRight);

            //调整当前的最小值 更换 最小值的两个点的坐标 以及 最小距离
            if (minDistLeft <= minDistRight){
                minDist = minDistLeft;
                minIndex = minIndexLeft;
            }else {
                minDist = minDistRight;
                minIndex = minIndexRight;
            }

            //计算中间区域的最小值 首先需要找到平分线的值（横坐标）
            double middleXAxis = (points[(head + tail) / 2][0] + points[(head + tail) / 2 + 1][0]) / 2;

            //以右边的某一个点为依据 向左找到最多六个点

            //开始找的坐标的起始索引
            int i = (head+tail) / 2 + 1;

            //首先找的索引 i 不能越界 并且 距离 平分线的 最短距离不能超过 左右两边的最小值
            while (i <= tail && points[i][0] - middleXAxis <= minDistTwoSide){
                //计数的变量 不超过六个
                int count = 0;

                //向左找点 不能越界 并且 还没有找到六个点
                for (int j = (head + tail) / 2; j >= head && count <= 6 ; j--){
                    //首先 距离 平分线的 最短距离不能超过 左右两边的最小值
                    //其次 找到的两个点纵坐标的差不能超过 左右两边的最小值
                    if (middleXAxis - points[j][0] <= minDistTwoSide && Math.abs(points[i][1] - points[j][1]) <= minDistTwoSide){
                        //判断这两个点之间的距离是否更小
                        if (getDistance(points,i,j) < minDist){
                            minDist = getDistance(points,i,j);
                            minIndex[0] = i;
                            minIndex[1] = j;
                        }

                        //改变找到的点数
                        count++;
                    }
                }

                //继续向右找点
                i++;
            }
        }

        return minIndex;
    }

}
