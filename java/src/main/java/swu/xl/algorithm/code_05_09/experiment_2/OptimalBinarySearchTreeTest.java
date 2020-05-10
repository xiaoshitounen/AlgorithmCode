package swu.xl.algorithm.code_05_09.experiment_2;

public class OptimalBinarySearchTreeTest {
    public static void main(String[] args) {
        double[] key_probability = {0.15, 0.1, 0.05, 0.1, 0.2} ;
        double[] dummy_probability = { 0.05, 0.1, 0.05, 0.05, 0.05, 0.1};
        double cost = OptimalBinarySearchTree.getMinCost(key_probability,dummy_probability);
        System.out.println(cost);
    }
}
