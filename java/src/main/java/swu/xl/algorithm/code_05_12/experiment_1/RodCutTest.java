package swu.xl.algorithm.code_05_12.experiment_1;

public class RodCutTest {
    public static void main(String[] args) {
        int[] cut_value = {1, 4, 5, 7, 10, 17, 17, 20, 24, 30};
        int maxLength = 20;
        int[][] rod_value = new int[3][maxLength];
        for(int i=0;i<maxLength;i++) {
            rod_value[0][i] = i + 1;
            rod_value[1][i] = RodCut.getValueByDP(cut_value,i+1);
            rod_value[2][i] = RodCut.getValueByGreedy(cut_value,i+1);
        }
        printMatrix(rod_value);
    }

    private static void printMatrix(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        String str = "";
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                str += A[i][j] + "\t";
            }
            str += "\n";
        }
        System.out.println(str);
    }
}

