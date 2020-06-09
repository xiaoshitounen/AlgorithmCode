package swu.xl.algorithm.code_06_09.experiment_2;

import java.util.LinkedList;

public class KnapsackTest {
    public static void main(String[] args) {
        int[][] items = {{2,12},{1,10},{3,20},{2,15}};
        int capacity = 5;

        LinkedList<Integer> packedItemsByIteration = Knapsack.getByBacktrackIteration(items, capacity);
        int packedValueByIteration = 0;
        for(int i : packedItemsByIteration) {
            packedValueByIteration += items[i-1][1];
        }

        LinkedList<Integer> packedItemsByRecursion = Knapsack.getByBacktrackRecursion(items, capacity);
        int packedValueByRecursion = 0;
        for(int i : packedItemsByRecursion) {
            packedValueByRecursion += items[i-1][1];
        }

        System.out.println("Iteration: packed items " + packedItemsByIteration + " packed value " + packedValueByIteration);
        System.out.println("Recursion: packed items " + packedItemsByRecursion + " packed value " + packedValueByRecursion);
    }

}
