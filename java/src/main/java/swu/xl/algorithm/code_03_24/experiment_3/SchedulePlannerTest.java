package swu.xl.algorithm.code_03_24.experiment_3;

public class SchedulePlannerTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int k = new java.util.Random().nextInt(4)+1;
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

    //222017602053039
}
