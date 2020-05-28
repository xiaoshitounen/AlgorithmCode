package swu.xl.algorithm.code_05_26.experiment_1;

/**
 * 简单的连边类
 */
public class Edge {
    String firstVertex;
    String secondVertex;

    public Edge(String firstVertex, String secondVertex){
        if (firstVertex.compareTo(secondVertex) > 0){
            this.firstVertex = secondVertex;
            this.secondVertex = firstVertex;
        }else {
            this.firstVertex = firstVertex;
            this.secondVertex = secondVertex;
        }
    }

    @Override
    public String toString() {
        return firstVertex + " --- " + secondVertex;
    }
}
