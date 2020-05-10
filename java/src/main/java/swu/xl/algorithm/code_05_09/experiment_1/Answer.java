package swu.xl.algorithm.code_05_09.experiment_1;

import java.util.LinkedList;

public class Answer {
    public LinkedList<Edge> partition;
    public double minCost;

    public Answer(LinkedList<Edge> partition, double minCost) {
        this.partition = partition;
        this.minCost = minCost;
    }
}
