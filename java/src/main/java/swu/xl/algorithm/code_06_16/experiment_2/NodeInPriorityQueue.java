package swu.xl.algorithm.code_06_16.experiment_2;

import java.util.Arrays;

public class NodeInPriorityQueue implements Comparable<NodeInPriorityQueue> {
    //人员安排情况
    int[] assignment;
    //当前的人
    int current_person;
    //当前的花费
    int cost;
    //工作的安排情况
    int[] job_flag;
    //下界
    int lower_bound;

    public NodeInPriorityQueue(int[] assignment, int current_person,
                               int cost, int[] job_flag, int lower_bound) {
        this.assignment = assignment;
        this.current_person = current_person;
        this.cost = cost;
        this.job_flag = job_flag;
        this.lower_bound = lower_bound;
    }

    @Override
    public int compareTo(NodeInPriorityQueue o) {
        if(this.lower_bound - o.lower_bound > 0) return 1;
        else if(this.lower_bound - o.lower_bound < 0) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return current_person +
                " " + cost +
                " " + lower_bound +
                " " + Arrays.toString(assignment) +
                " " + Arrays.toString(job_flag);
    }
}
