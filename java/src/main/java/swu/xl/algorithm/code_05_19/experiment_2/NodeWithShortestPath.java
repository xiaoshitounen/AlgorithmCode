package swu.xl.algorithm.code_05_19.experiment_2;

public class NodeWithShortestPath {
    String from;
    String name;
    int route_length;

    public NodeWithShortestPath(String name, String from, int route_length) {
        this.name = name;
        this.from = from;
        this.route_length = route_length;
    }
}
