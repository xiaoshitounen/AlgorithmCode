package swu.xl.algorithm.code_03_31.experiment_3;

import java.util.ArrayList;
import java.util.List;

class ClosestPair {
    /**
     * 暴力求解
     * @param points
     * @return
     */
    public static double getByBruteForce(double[][] points) {
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
     *
     * @param points
     * @return
     */
    public static double getByDivideConquer(double[][] points) {
        return divide(0,points.length-1,points);
    }

    public static double divide(int left, int right, double[][] points) {
        // 当前最小两点距离，初始值设置为无穷大
        double curMinDis = Integer.MAX_VALUE;

        // 如果只有一个点，则不存在最近两点距离，返回无穷大
        if (left == right) {
            return curMinDis;
        }

        // 这里是判断是否为只有两个点，如果只有两个点的话那么直接求解。
        if (left + 1 == right) {
            return getDistance(points,left,right);
        }

        // 分治法：第一步：分区，并求取左右分区最小两点距离
        // 对区域进行合理的划分，使得左右两边保持大致相等个数点
        int middle = (left + right) / 2;
        double leftMinDis = divide(left, middle, points);
        double rightMinDis = divide(middle, right, points);

        //左右区间最小值中更小的
        curMinDis = Math.min(leftMinDis, rightMinDis);

        // 分治法：第二步：假设距离最近的两点分别在左右分区中
        // 关键代码，距离最近的两个点，一个位于左边区域，一个位于右边区域，x轴搜索范围[middle-curMinDis, middle+curMinDis]
        // 记录搜索区间内的点的索引，便于进一步计算最小距离
        List<Integer> validPointIndex = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[middle][0] - points[i][0]) <= curMinDis) {
                validPointIndex.add(i);
            }
        }

        // 基于索引，进一步计算区间内最小两点距离
        for (int i = 0; i < validPointIndex.size() - 1; i++) {
            for (int j = i + 1; j < validPointIndex.size(); j++) {
                // 如果区间内的两点y轴距离大于curMinDis，则没必要计算了，因为，它们的距离肯定大于curMinDis，
                if (Math.abs(points[validPointIndex.get(i)][1]
                        - points[validPointIndex.get(j)][1]) > curMinDis) {
                    continue;
                }
                double tempDis = getDistance(points,validPointIndex.get(i),
                        validPointIndex.get(j));

                curMinDis = Math.min(tempDis, curMinDis);
            }
        }

        return curMinDis;
    }

    /**
     * 测试程序
     */
    public static void main(String[] args) {
        double[][] points = new double[][]{{0,0},{0,1},{0,2},{0.5,0}};

        System.out.println(getByBruteForce(points));
        System.out.println(getByDivideConquer(points));
    }
}
