package swu.xl.algorithm.code_05_09.experiment_1;

public class MinTriagulationTest {
    public static void main(String[] args) {
        double[][] points = {{0, 0}, {1, 0}, {2, 1}, {1, 2}, {0, 2}};
        Answer ans = MinTriagulation.getPartition(points);
        for(Edge e : ans.partition) {
            System.out.println("point" + e.point1 + " ---- point" + e.point2);
        }
        System.out.println(ans.minCost);
    }
}
