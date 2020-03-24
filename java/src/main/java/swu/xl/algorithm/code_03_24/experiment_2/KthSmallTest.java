package swu.xl.algorithm.code_03_24.experiment_2;

public class KthSmallTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int maxData = 20;
        int len = 10;
        int[] a = generateRandomNumbers(len, maxData);
        int k = new java.util.Random().nextInt(len);
        int kthSmall = KthSmall.getKthSmall(a, k);
        System.out.println("Array is: ");
        printArray(a);
        System.out.println("The " + k + "th small is: " + kthSmall);
    }

    static private int[] generateRandomNumbers(int len, int bound) { //generate an array of length len, the numbers are no larger than bound.
        int [] a = new int[len];
        for(int i=0; i<len; i++) {
            a[i] = new java.util.Random().nextInt(bound);
        }
        return a;
    }

    private static void printArray(int[] A) {
        int n = A.length;
        String str = "";
        for(int i=0;i<n;i++) {
            str += A[i] + " ";
        }
        System.out.println(str);
    }

    //222017602053039许磊
}

