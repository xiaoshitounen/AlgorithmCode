package swu.xl.algorithm.code_03_31.experiment_1;


public class SchedulePlannerTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int k = 4;
        int[][] schedule = SchedulePlanner.getSchedule(k);
        System.out.println("The schedule of " + (int)Math.pow(2,k) + " players is: ");
        printMatrix(schedule);
    }

    private static void printMatrix(int[][] A) {
        int n = A.length;
        String str = "";
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                str += A[i][j] + "\t";
            }
            str += "\n";
        }
        System.out.println(str);
    }
}

