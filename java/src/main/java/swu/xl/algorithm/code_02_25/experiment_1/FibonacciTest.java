package swu.xl.algorithm.code_02_25.experiment_1;

import java.io.FileWriter;
import java.io.IOException;

public class FibonacciTest {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        int startNumber = 10;			// the start number as the parameter n
        int trialNumber = 41;			// the number of trials

        long[][] recordData = new long[trialNumber][5];
        // records for each trial, including the parameter n, and the time used for two methods (recursion and iteration).

        for(int i=0;i<trialNumber;i++) {	// One loop for each trial.
            long n = startNumber + i;

            long startTimeRecursion = System.currentTimeMillis();	//start time
            long fib_recursion = Fibonacci.getByRecursion(n); 	//get Fibonacci by recursion
            long endTimeRecursion = System.currentTimeMillis();  	//end time

            long startTimeIteration = System.currentTimeMillis();	//start time
            long fib_iteration = Fibonacci.getByIteration(n); 	//get Fibonacci by recursion
            long endTimeIteration = System.currentTimeMillis();  	//end time

            recordData[i][0] = n;
            recordData[i][1] = fib_recursion;
            recordData[i][2] = fib_iteration;
            recordData[i][3] = endTimeRecursion - startTimeRecursion;
            recordData[i][4] = endTimeIteration - startTimeIteration;

            System.out.println("Parameter(n): " + recordData[i][0] + "; recursion result: " + recordData[i][1] + "; iteration result: "
                    + recordData[i][2] + "; recursion time: " + recordData[i][3] + "; iteration time: "
                    + recordData[i][4] + ".");		//print the parameter n , the results of two methods, and the running times of two methods
        }

        FileWriter csvWriter = new FileWriter("data.csv");
        for(int i=0;i<trialNumber;i++) {
            csvWriter.append(" " + recordData[i][0] + "," + recordData[i][3] + "\n");
        }
        csvWriter.close();
        System.out.println("Please find the data file at " + System.getProperty("user.dir"));
    }

}
