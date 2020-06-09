package swu.xl.algorithm.code_06_09.experiment_2;

import java.util.LinkedList;

/**
 * 背包问题
 */
public class Knapsack {
    /**
     * 回溯-迭代
     * @param items
     * @param capacity
     * @return
     */
    public static LinkedList<Integer> getByBacktrackIteration(int[][] items, int capacity){
        //物品的个数
        int n = items.length;
        //存储当前各个物品放置结果
        int[] current_park = new int[n+1];
        //初始化结果
        for (int i = 0; i <= n; i++) {
            current_park[i] = -1;
        }
        //存储最佳各个物品放置结果
        int[] best_pack = new int[n+1];
        //存储放置的最大价值
        int best_value = 0;
        //存储对应操作次数背包中存放的重量
        int[] packed_weight = new int[n+1];
        //存储对应操作次数背包中存放的价值
        int[] packed_value = new int[n+1];

        //从第一个物品开始操作
        int current_item = 1;
        while (current_item >= 1) {
            //设置当前物品的选择状态
            current_park[current_item] += 1;

            //不放入 第current_item个物品
            //放入 第current_item个物品，且不超过放入的容量
            if (current_park[current_item] == 0 ||
                    (current_park[current_item] == 1 &&
                            packed_weight[current_item-1] + items[current_item-1][0] <= capacity)) {

                //设置放置第current_item个物品的时候，此时背包中已经存放的重量
                packed_weight[current_item] = packed_weight[current_item-1] + items[current_item-1][0] * current_park[current_item];
                //设置放置第current_item个物品的时候，此时背包中存放物品的总价值
                packed_value[current_item] = packed_value[current_item-1] + items[current_item-1][1] * current_park[current_item];

                //如果 操作的物品次数 == 物品数
                if (current_item == n){
                    if (packed_value[current_item] > best_value){
                        best_value = packed_value[current_item];

                        best_pack = current_park.clone();
                    }
                }else {
                    //继续下一次操作
                    current_item = current_item + 1;
                }

            }else {
                //当前物品的选择状态（0，1）不对了，在回到上一位之前将当前次数的操作还原
                current_park[current_item] = -1;

                //回到上一位
                current_item = current_item - 1;
            }
        }

        //整理结果
        LinkedList<Integer> packedItems = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            if (best_pack[i] == 1) packedItems.add(i);
        }

        return packedItems;
    }

    /**
     * 回溯-递归
     * @param items
     * @param capacity
     * @return
     */
    public static LinkedList<Integer> getByBacktrackRecursion(int[][] items, int capacity) {
        //物品的个数
        int n = items.length;
        //存储当前各个物品放置结果
        int[] current_park = new int[n+1];
        //存储最佳各个物品放置结果
        int[] best_pack = new int[n+1];
        //存储放置的最大价值
        int[] best_value = {0};
        //存储对应操作次数背包中存放的重量
        int[] packed_weight = new int[n+1];
        //存储对应操作次数背包中存放的价值
        int[] packed_value = new int[n+1];

        //从第一个物品开始操作
        int current_item = 1;
        getByBacktrackRecursion(
                items,
                capacity,
                current_item,
                best_pack,
                best_value,
                current_park,
                packed_weight,
                packed_value
        );

        //整理结果
        LinkedList<Integer> packedItems = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            if (best_pack[i] == 1) packedItems.add(i);
        }

        return packedItems;
    }

    private static void getByBacktrackRecursion(int[][] items, int capacity, int current_item, int[] best_pack, int[] best_value, int[] current_park, int[] packed_weight, int[] packed_value) {
        //获取物品的个数
        int n = items.length;

        //操作的物品次数不能超过物品的个数
        if (current_item > n){
            return;
        }

        //循环控制
        for (int c = 0; c <= 1; c++){
            //设置当前物品的选择状态
            current_park[current_item] = c;

            //判断放置的物品总重量是否已经超过背包的容量
            if (packed_weight[current_item-1] + items[current_item-1][0] * c <= capacity){

                //设置放置第current_item个物品的时候，此时背包中已经存放的重量
                packed_weight[current_item] = packed_weight[current_item-1] + items[current_item-1][0] * c;
                //设置放置第current_item个物品的时候，此时背包中存放物品的总价值
                packed_value[current_item] = packed_value[current_item-1] + items[current_item-1][1] * c;

            }

            //如果 操作的物品次数 == 物品数
            if (current_item == n){

                //如果当前的放置结果得到的价值更大，更新
                if (packed_value[current_item] > best_value[0]){

                    best_value[0] = packed_value[current_item];

                    for (int i = 0; i <= n; i++) {
                        best_pack[i] = current_park[i];
                    }
                }
            }

            //下一个物品
            getByBacktrackRecursion(
                    items,
                    capacity,
                    current_item+1,
                    best_pack,
                    best_value,
                    current_park,
                    packed_weight,
                    packed_value
            );
        }
    }
}
