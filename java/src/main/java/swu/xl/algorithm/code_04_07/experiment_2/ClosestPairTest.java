package swu.xl.algorithm.code_04_07.experiment_2;

public class ClosestPairTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        double bound = 100;
        int arrayLengthStep = 10000;
        int trialNumber = 20;

        for(int i=1;i<=trialNumber;i++) {
            double[][] points = generateRandomNumbers(i*arrayLengthStep, 2, bound);

            long startTimeBF = System.currentTimeMillis();
            double minBruteForce = ClosestPair.getByBruteForce(points);
            long endTimeBF = System.currentTimeMillis();
            long BFTime = endTimeBF - startTimeBF;

            long startTimeDC = System.currentTimeMillis();
            double minDivideConquer = ClosestPair.getByDivideConquer(points);
            long endTimeDC = System.currentTimeMillis();
            long DCTime = endTimeDC - startTimeDC;

            //System.out.println(minBruteForce+" "+minDivideConquer);
            if(minBruteForce != minDivideConquer) {
                System.out.println("wrong!");
            }
            System.out.println("length: " + i*arrayLengthStep + "; brute force time: " + BFTime +"; divide conquer time: " + DCTime);
        }
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

