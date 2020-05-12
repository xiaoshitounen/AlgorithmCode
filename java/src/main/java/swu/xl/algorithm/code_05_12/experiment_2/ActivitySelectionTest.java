package swu.xl.algorithm.code_05_12.experiment_2;

import java.util.LinkedList;

public class ActivitySelectionTest {
    public static void main(String[] args) {
        int[][] activityStartEndTime = {{8,14},{9,12},{11,13},{16,19},{14,18},{13,15},{10,21},{20,22},{16,20},{11,16},{13,17}};
        LinkedList<Integer> selectedActivities = ActivitySelection.selectFrom(activityStartEndTime);
        System.out.println(selectedActivities);
    }
}

