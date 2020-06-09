package swu.xl.algorithm.code_06_02.experiment_1;

import java.util.LinkedList;
import java.util.List;

public class NQueenTest {
    public static void main(String[] args) {
        int n = 4;

        LinkedList<List<Integer>> sols = NQueen.getByIterate(n);
        System.out.println(sols);

        sols = NQueen.getByRecursion(n);
        System.out.println(sols);
    }

}
