package swu.xl.algorithm.code_05_19.experiment_1;

public class Node implements Comparable<Node>{
    String chr;
    double frequency;
    Node leftChild;
    Node rightChild;

    //叶子节点
    public Node(String chr, double frequency) {
        this.chr = chr;
        this.frequency = frequency;

        leftChild = null;
        rightChild = null;
    }

    //树根节点
    public Node(Node leftChild, Node rightChild) {
        chr = null;
        frequency = leftChild.frequency + rightChild.frequency;

        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(Node node) {
        if (frequency - node.frequency > 0) return 1;
        else if (frequency - node.frequency < 0) return -1;
        else return 0;
    }
}
