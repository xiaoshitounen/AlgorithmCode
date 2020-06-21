package swu.xl.algorithm.code_06_16.experiment_1;

import java.util.LinkedList;

public class KnapsackTest {
    public static void main(String[] args) {
        double[][] items = {{7,42},{5,25},{3,12},{4,40}};
        double capacity = 10;
        LinkedList<Item> packedItems = Knapsack.getByBranchBound(items, capacity);
        int packedValue = 0;
        String packedItemsStr = "";
        for(Item item : packedItems) {
            packedValue += item.value;
            packedItemsStr = packedItemsStr + "weight " + item.weight + ", value " + item.value + "; ";
        }
        System.out.println("packed items: " + packedItemsStr);
        System.out.println("packed value: " + packedValue);
    }

}
