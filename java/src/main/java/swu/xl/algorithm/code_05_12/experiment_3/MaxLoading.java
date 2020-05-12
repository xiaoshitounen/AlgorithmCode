package swu.xl.algorithm.code_05_12.experiment_3;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 最优装载问题
 */
class MaxLoading {
    /**
     *
     * @param containers_weight
     * @param capacity
     * @return
     */
    public static LinkedList<Integer> selectFrom(int[] containers_weight, int capacity){
        //集装箱的数量
        int n = containers_weight.length;

        //存储集装箱对应的Container集合
        Container[] containers = new Container[n];
        //初始化
        for (int i = 0; i < n; i++) {
            containers[i] = new Container(i+1, containers_weight[i]);
        }

        //按照集装箱的大小从小到大排序
        Arrays.sort(containers);

        //存储选择的集装箱
        LinkedList<Integer> selectedContainers = new LinkedList<>();

        //贪心找到选择的集装箱
        for (int i = 0; i < n && capacity > 0; i++) {
            //如果还可以装得下
            if (capacity >= containers[i].weight){
                //加入集装箱
                selectedContainers.add(containers[i].No);

                //更新容量
                capacity -= containers[i].weight;
            }
        }

        return selectedContainers;
    }
}
