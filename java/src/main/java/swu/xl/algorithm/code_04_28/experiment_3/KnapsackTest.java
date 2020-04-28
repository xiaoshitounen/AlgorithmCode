package swu.xl.algorithm.code_04_28.experiment_3;

import java.util.LinkedList;

public class KnapsackTest {

	public static void main(String[] args) {
		int[][] items = {{2,12},{1,10},{3,20},{2,15}};
		int capacity = 5;
		LinkedList<Integer> packedItems = Knapsack.getByTabulation(items, capacity);
		LinkedList<Integer> packedItems1 = Knapsack.getByMemoization(items, capacity);

		int packedValue = 0;
		for(int i : packedItems) {
			packedValue += items[i-1][1];
		}
		int packedValue1 = 0;
		for(int i : packedItems1) {
			packedValue1 += items[i-1][1];
		}

		System.out.println("Tab packed items: " + packedItems);
		System.out.println("Tab packed value: " + packedValue);
		System.out.println();
		System.out.println("Mem packed items: " + packedItems1);
		System.out.println("Mem packed value: " + packedValue1);

	}

}
