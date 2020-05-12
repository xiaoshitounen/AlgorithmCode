package swu.xl.algorithm.code_05_12.experiment_3;

public class Container implements Comparable<Container> {
    //集装箱的编号
    int No;
    //集装箱的重量
    int weight;

    //构造方法
    public Container(int no, int weight) {
        No = no;
        this.weight = weight;
    }

    @Override
    public int compareTo(Container container) {
        return weight - container.weight;
    }
}
