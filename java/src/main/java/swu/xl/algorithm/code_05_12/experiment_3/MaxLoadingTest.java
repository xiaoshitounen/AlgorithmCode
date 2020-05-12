package swu.xl.algorithm.code_05_12.experiment_3;

import java.util.LinkedList;

public class MaxLoadingTest {
    public static void main(String[] args) {
        int[] containers_weight = {100,200,50,90,150,50,20,80};
        int capacity = 400;
        LinkedList<Integer> selectedContainers = MaxLoading.selectFrom(containers_weight, capacity);
        System.out.println(selectedContainers);
    }
}

