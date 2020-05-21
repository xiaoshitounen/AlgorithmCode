package swu.xl.algorithm.code_05_19.experiment_2;

public class NodeWithShortestPathInRankedList extends NodeWithShortestPath {
    NodeWithShortestPathInRankedList previous;
    NodeWithShortestPathInRankedList next;

    public NodeWithShortestPathInRankedList(String node_name, int route_length, String node_from, NodeWithShortestPathInRankedList previous, NodeWithShortestPathInRankedList next) {
        super(node_name, node_from, route_length);
        this.previous = previous;
        this.next = next;
    }

    public void changeRoute(String node_from,int route_length){
        //跟新更短的数据
        this.route_length = route_length;
        this.from = node_from;

        //判断是否需要交换位置
        while (previous != null && route_length < previous.route_length){
            NodeWithShortestPathInRankedList tempPrevious = this.previous;
            if (this.previous.previous.next != null){
                this.previous.previous.next = this;
            }

            //交换数据
            this.next.previous = this.previous;
            this.previous.previous = this;
            this.previous.next = this.next;
            this.next = tempPrevious;
            this.previous = tempPrevious.previous;
        }
    }
}
