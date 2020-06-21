package swu.xl.algorithm.code_06_16.experiment_1;

/**
 * 节点
 */
public class NodeInPriorityQueue implements Comparable<NodeInPriorityQueue> {
    //当前的重量
    double weight;
    //当前的价值
    double value;
    //当前放入背包的item
    int[] packedItems;
    //当前的item
    int current_item;
    //该节点的上界
    double upper_bound;

    public NodeInPriorityQueue(double weight, double value, int[] packedItems,
                               int current_item, double upper_bound) {
        this.weight = weight;
        this.value = value;
        this.packedItems = packedItems;
        this.current_item = current_item;
        this.upper_bound = upper_bound;
    }

    @Override
    public int compareTo(NodeInPriorityQueue o) {
        if(this.upper_bound - o.upper_bound > 0) return -1;
        else if(this.upper_bound - o.upper_bound < 0) return 1;
        else return 0;
    }
}
