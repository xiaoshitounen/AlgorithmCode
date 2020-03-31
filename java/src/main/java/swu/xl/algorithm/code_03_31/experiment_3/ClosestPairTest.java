package swu.xl.algorithm.code_03_31.experiment_3;

public class ClosestPairTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 5000;
        double bound = 100;
        double[][] points = generateRandomNumbers(n, 2, bound);

        long startTimeBF = System.currentTimeMillis();
        double minBruteForce = ClosestPair.getByBruteForce(points);
        long endTimeBF = System.currentTimeMillis();
        long BFTime = endTimeBF - startTimeBF;

        long startTimeDC = System.currentTimeMillis();
        double minDivideConquer = ClosestPair.getByDivideConquer(points);
        long endTimeDC = System.currentTimeMillis();
        long DCTime = endTimeDC - startTimeDC;

        System.out.println("brute force time: " + BFTime +"; divide conquer time: " + DCTime);
        System.out.println(minBruteForce + "; " +  minBruteForce);

    }

    static private double[][] generateRandomNumbers(int row, int col, double bound) { //generate an array of length len, the numbers are no larger than bound.
        double[][] a = new double[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                a[i][j] = new java.util.Random().nextDouble() * bound;
            }
        }
        return a;
    }

}

