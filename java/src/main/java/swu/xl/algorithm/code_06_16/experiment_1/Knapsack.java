package swu.xl.algorithm.code_06_16.experiment_1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Knapsack {

    /**
     * 分治定界-求解背包问题
     * @param items
     * @param capacity
     * @return
     */
    public static LinkedList<Item> getByBranchBound(double[][] items, double capacity) {
        //1.获取物品的数量
        int n = items.length;

        //2.根据物品的平均价值排序
        LinkedList<Item> itemList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //2.1初始化物品
            Item item = new Item(items[i][0], items[i][1]);

            //2.2找到物品该插入的位置
            int k = 0;
            while (k < i && itemList.get(k).unit_value > item.unit_value) {
                k++;
            }

            //2.3插入物品
            itemList.add(k,item);
        }

        //3.生成初始根节点
        int[] best_pack = new int[n];
        double best_value = 0;
        PriorityQueue<NodeInPriorityQueue> queue = new PriorityQueue<>();
        queue.add(
                new NodeInPriorityQueue(
                        0,0,
                        new int[n],
                        0,
                        capacity * itemList.get(0).unit_value
                )
        );
        printPQ(queue);

        //4.循环解决问题
        while (!queue.isEmpty()) {
            //4.1弹出最大上界结点
            NodeInPriorityQueue node = queue.poll();

            //4.2如果该节点上界大于当前最好情况下的价值
            if (node.upper_bound > best_value) {
                //4.2.1获取当前操作的是第几个item
                int current_item = node.current_item;

                //4.2.2判断是不是叶子节点
                if (current_item == n-1){
                    //刷新最大值
                    if (node.value > best_value) {
                        best_value = node.value;
                        best_pack = node.packedItems.clone();
                    }
                }else {
                    //生成左节点(不放入该item)
                    int[] new_packed_items = new int[n];
                    for (int i = 0; i < current_item; i++) {
                        new_packed_items[i] = node.packedItems[i];
                    }
                    queue.add(
                            new NodeInPriorityQueue(
                                  node.weight,
                                  node.value,
                                  new_packed_items,
                                  current_item+1,
                                  node.value + (capacity-node.weight) * itemList.get(current_item + 1).unit_value
                            )
                    );

                    //生成右节点(放入该item，首先需要判断能不能放得下)
                    if (node.weight + itemList.get(current_item).weight < capacity){
                        new_packed_items = new int[n];
                        for (int i = 0; i < current_item; i++) {
                            new_packed_items[i] = node.packedItems[i];
                        }
                        new_packed_items[current_item] = 1;
                        double new_weight = node.weight + itemList.get(current_item).weight;
                        double new_value = node.value + itemList.get(current_item).value;
                        double new_upper_bound = new_value + (capacity - new_weight) * itemList.get(current_item + 1).unit_value;
                        queue.add(
                                new NodeInPriorityQueue(
                                     new_weight,
                                     new_value,
                                     new_packed_items,
                                     current_item+1,
                                     new_upper_bound
                                )
                        );
                    }
                }

            }

            //4.3打印
            printPQ(queue);
            printBest(best_pack,best_value);
        }

        //5.返回
        LinkedList<Item> packedItems = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (best_pack[i] == 1){
                packedItems.add(itemList.get(i));
            }
        }

        return packedItems;
    }

    /**
     * 打印优先队列
     * @param queue
     */
    private static void printPQ(PriorityQueue<NodeInPriorityQueue> queue) {
        System.out.println("-----------");

        for (NodeInPriorityQueue node : queue) {
            System.out.println(node.weight+" "+node.value+" "+ Arrays.toString(node.packedItems) +" "+node.current_item+" "+node.upper_bound);
        }
    }

    /**
     * 打印当前最好的情况
     * @param best_pack
     * @param best_value
     */
    private static void printBest(int[] best_pack, double best_value) {
        System.out.println("Best:"+ Arrays.toString(best_pack) +" "+best_value);
    }

}
