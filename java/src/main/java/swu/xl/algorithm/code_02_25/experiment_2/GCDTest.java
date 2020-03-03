package swu.xl.algorithm.code_02_25.experiment_2;

public class GCDTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int startNum = 100000000;
        int increment = 100000000;
        int runTime = 20;

        for(int i=0; i<runTime; i++) {
            int b = startNum + i*increment;
            int a = new java.util.Random().nextInt(b);

            long startTimeEuclid = System.currentTimeMillis();
            int gcd_euclid = GCD.getByEuclid(a,b);
            long endTimeEuclid = System.currentTimeMillis();
            long time_euclid = endTimeEuclid - startTimeEuclid;

            long startTimeBrute = System.currentTimeMillis();
            int gcd_brute = GCD.getByBruteForce(a,b);
            long endTimeBrute = System.currentTimeMillis();
            long time_brute = endTimeBrute - startTimeBrute;

            System.out.println("Max of the input (b): " + b + "; euclid result: "
                    + gcd_euclid + "; brute result: " + gcd_brute + "; euclid time: "
                    + time_euclid + "; brute time: " + time_brute + ".");
        }
    }
}
