package swu.xl.algorithm.code_05_26.experiment_1;

/**
 * 图中的节点类，并标注来源节点和距离，可按照距离排序
 */
public class NodeWithDistanceInRankedList {
    String name;
    String from;
    int distance;

    NodeWithDistanceInRankedList previous;
    NodeWithDistanceInRankedList next;

    public NodeWithDistanceInRankedList(String name, String from, int distance,
                                        NodeWithDistanceInRankedList previous, NodeWithDistanceInRankedList next) {
        this.name = name;
        this.from = from;
        this.distance = distance;
        this.previous = previous;
        this.next = next;
    }

    public void changeDistance(String node_from, int distance) {
        this.distance = distance;
        this.from = node_from;
        while(this.previous != null && distance < this.previous.distance) {
            NodeWithDistanceInRankedList tempPreviousPrevious = this.previous.previous;
            if(this.previous.previous!=null) {
                this.previous.previous.next = this;
            }
            if(this.next!=null) {
                this.next.previous = this.previous;
            }
            this.previous.previous = this;
            this.previous.next = this.next;
            this.next = this.previous;
            this.previous = tempPreviousPrevious;
        }
    }
}
