package swu.xl.algorithm.code_04_28.experiment_3;

import java.util.LinkedList;

class Knapsack {
    /**
     * 01背包问题-表格法
     * @param items
     * @param capacity
     * @return
     */
    public static LinkedList<Integer> getByTabulation(int[][] items, int capacity) {
        //物品的个数
        //item 是一个二维数组 第一个值是占据的空间 第二个值是其价值
        int n = items.length;

        //前多少件物品和剩余空间求解最大价值的表格
        //tab[前多少件物品][空间] = 最大价值
        int[][] tab = new int[n+1][capacity+1];

        //依次填表
        //注意：这里的i和c都是序号不是索引
        for (int i = 1; i <= n; i++) {
            for (int c = 1; c <= capacity; c++) {
                //如果还可以装的下
                if (c - items[i-1][0] >= 0){
                    //是否装入该物品
                    tab[i][c] = Math.max(
                            tab[i-1][c],
                            tab[i-1][c-items[i-1][0]] + items[i-1][1]
                    );
                }else {
                    tab[i][c] = tab[i-1][c];
                }
            }
        }

        //求解出装入背包的是那几项
        LinkedList<Integer> packedItems = new LinkedList<>();
        int c = capacity;
        for (int i = n; i > 0; i--) {
            //说明装入该物品
            if (tab[i][c] != tab[i-1][c]){
                packedItems.add(0,i);
                c = c - items[i-1][0];
            }
        }

        return packedItems;
    }

    /**
     * 01背包问题-备忘录法
     * @param items
     * @param capacity
     * @return
     */
    public static LinkedList<Integer> getByMemoization(int[][] items, int capacity){
        int n = items.length;
        int[][] table = new int[n][capacity + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= capacity; j++) {
                table[i][j] = -1;
            }
        }
        getByMemoization(items, table, 0, capacity);
        LinkedList<Integer> packItem = new LinkedList<>();
        trackBack(0, capacity, items, table, packItem);

        return packItem;
    }

    //重载
    private static int getByMemoization(int[][] items, int[][] table, int i, int capacity) {
        if(table[i][capacity] != -1) return table[i][capacity];

        int result;
        if(i == items.length - 1) {
            if(capacity >= items[i][0]) {
                table[i][capacity] = items[i][1];
                return items[i][1];
            } else {
                table[i][capacity] = 0;
                return 0;
            }

        }else{
            if(capacity >= items[i][0]) {
                int selected = getByMemoization(items, table, i + 1,capacity - items[i][0]) + items[i][1];
                int unselected = getByMemoization(items, table, i + 1,capacity);
                result = Math.max(selected, unselected);
                table[i][capacity] = result;
                return result;
            }else {
                result = getByMemoization(items, table, i+1, capacity);
                table[i][capacity] = result;
                return result;
            }

        }
    }

    //找到转入的物品
    private static void trackBack(int i, int capacity, int[][] items, int[][]tab, LinkedList<Integer> packItem) {
        if(i == items.length - 1) {
            if(tab[i][capacity] == items[i][1]) packItem.add(i + 1);//此位置要选择

        } else {
            if (tab[i][capacity] == tab[i+1][capacity]) trackBack(i+1, capacity, items, tab, packItem);
            else packItem.add(i + 1);trackBack(i+1, capacity - items[i][0], items, tab, packItem);
        }
    }
}
