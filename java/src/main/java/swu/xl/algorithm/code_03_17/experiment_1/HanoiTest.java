package swu.xl.algorithm.code_03_17.experiment_1;

import java.util.ArrayList;

public class HanoiTest {
    public static void main(String[] args) {
        ArrayList<Integer> A_nums = new ArrayList<>();
        A_nums.add(5);
        A_nums.add(4);
        A_nums.add(3);
        A_nums.add(2);
        A_nums.add(1);
        Tower A = new Tower("A", A_nums);
        Tower B = new Tower("B");
        Tower C = new Tower("C");
        Hanoi.move(A, B, C);
    }
}
