package swu.xl.algorithm.code_03_31.experiment_2;

public class KthSmallTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int maxData = 100000000;					// the upper bound for the randomly generated number
        int arrayLengthStep = 1000000;			// the increase step for the length of the data to be sorted
        int trialNumber = 30;					// the number of trials

        for(int i=0;i<trialNumber;i++) {	// One loop for each trial.
            int arrayLength = arrayLengthStep*(i+1); // the length of data array in this trial, to be increased by arrayLengthStep in following trials.
            int[] data = generateRandomNumbers(arrayLength,maxData); //Generate an array of length len, the numbers are no larger than bound.

            int k = new java.util.Random().nextInt(arrayLength)+1;

            long startTimeSort = System.currentTimeMillis();
            int kthSmallBySorting = KthSmall.getKthSmallBySorting(data, k);
            long endTimeSort = System.currentTimeMillis();
            long BCTime = endTimeSort - startTimeSort;

            long startTimeDC = System.currentTimeMillis();
            int kthSmallByDivideConquer = KthSmall.getKthSmallByDivideConquer(data, k);
            long endTimeDC = System.currentTimeMillis();
            long DCTime = endTimeDC - startTimeDC;

            if(kthSmallBySorting != kthSmallByDivideConquer) {
                System.out.println("Wrong!");
            }
            System.out.println("Data length: " + arrayLength + "; brute force time: " + BCTime + "; divide and conquer time: " + DCTime + ".");		//print the array length and the running times
        }
    }

    static private int[] generateRandomNumbers(int len, int bound) { //generate an array of length len, the numbers are no larger than bound.
        int [] a = new int[len];
        for(int i=0; i<len; i++) {
            a[i] = new java.util.Random().nextInt(bound);
        }
        return a;
    }
}

