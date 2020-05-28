package swu.xl.algorithm.code_05_26.experiment_1;

public class EdgeWithLength extends Edge implements Comparable<EdgeWithLength> {
    int length;

    public EdgeWithLength(String firstVertex, String secondVertex) {
        super(firstVertex, secondVertex);
        length = 0;
    }

    public EdgeWithLength(String firstVertex, String secondVertex, int length) {
        super(firstVertex, secondVertex);
        this.length = length;
    }

    @Override
    public int compareTo(EdgeWithLength e) {
        return this.length - e.length;
    }
}
