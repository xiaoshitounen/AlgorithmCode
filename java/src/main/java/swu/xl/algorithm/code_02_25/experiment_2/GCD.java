package swu.xl.algorithm.code_02_25.experiment_2;

public class GCD {
    public static int getByBruteForce(int a, int b){
        int result = 0;
        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0){
                result = i;
                break;
            }
        }

        return result;
    }

    public static int getByEuclid(int a, int b){
        while(a != 0 && b != 0){
            if(a > b){
                a = a % b;
            }else{
                b = b % a;
            }
        }

        return a+b;
    }

//    public static void main(String[] args) {
//        System.out.println(getByEuclid(2,12));
//        System.out.println(getByBruteForce(2,12));
//    }
}
