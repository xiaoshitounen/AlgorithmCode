package swu.xl.algorithm.code_03_24.experiment_1;

import java.io.FileWriter;
import java.io.IOException;

public class MySortTest {
    public static void main(String[] args) throws IOException{
        int bound = 100000;					// the upper bound for the randomly generated number
        int arrayLengthStep = 10000;			// the increase step for the length of the data to be sorted
        int trialNumber = 30;					// the number of trials
        int sortMethodNumber = 3;				// the number of methods to be tested: selection, insertion, merge and quick

        long[][] recordData = new long[trialNumber][sortMethodNumber+1];
        // records for each trial, including the length of the data array, the time used for four sorting methods.
        for(int i=0;i<trialNumber;i++) {	// One loop for each trial.
            int arrayLength = arrayLengthStep*(i+1); // the length of data array in this trial, to be increased by arrayLengthStep in following trials.
            int[] data = generateRandomNumbers(arrayLength,bound); //Generate an array of length len, the numbers are no larger than bound.

            long startTimeSelection = System.currentTimeMillis();			//start time
            int[] sortedDataSelection = MySort.selectionSort(data);			//sorting with selection method
            long endTimeSelection = System.currentTimeMillis();				//end time

            long startTimeMerge = System.currentTimeMillis();		//start time
            int[] sortedDataMerge = MySort.mergeSort(data);			//sorting with merge method
            long endTimeMerge = System.currentTimeMillis();			//end time


            long startTimeQuick = System.currentTimeMillis();		//start time
            int[] sortedDataQuick = MySort.quickSort(data);			//sorting with merge method
            long endTimeQuick = System.currentTimeMillis();			//end time

            recordData[i][0] = arrayLength;								//Store array length in recordData
            recordData[i][1] = endTimeSelection - startTimeSelection;	//Store running time of selection sort in recordData
            recordData[i][2] = endTimeMerge - startTimeMerge;			//Store running time of merge sort in recordData
            recordData[i][3] = endTimeQuick - startTimeQuick;

            System.out.println("Data length: " + recordData[i][0] + "; selection time: " + recordData[i][1] + "; merge time: "
                    + recordData[i][2] + "; quick time: " + recordData[i][3] + ".");		//print the array length and the running times

            for(int j=0; j<arrayLength ; j++) {					//check if the sorting is right or wrong.
                if(sortedDataMerge[j]!=sortedDataQuick[j]) {
                    System.out.println("Sort wrong!!!!!!");
                    break;
                }
            }
        }

        FileWriter csvWriter = new FileWriter("dataSort.csv");
        for(int i=0;i<trialNumber;i++) {
            csvWriter.append(" " + recordData[i][0] + "," + recordData[i][1] + "," + recordData[i][2] + "," + recordData[i][3] + "\n");
        }
        csvWriter.close();
        System.out.println("Please find the data file at " + System.getProperty("user.dir"));

    }

    static private int[] generateRandomNumbers(int len, int bound) { //generate an array of length len, the numbers are no larger than bound.
        int [] a = new int[len];
        for(int i=0; i<len; i++) {
            a[i] = new java.util.Random().nextInt(bound);
        }
        return a;
    }

    //222017602053039许磊
}

