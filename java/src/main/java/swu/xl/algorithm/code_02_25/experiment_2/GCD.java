package swu.xl.algorithm.code_02_25.experiment_2;

/**
 * 求解最大公因数
 */
public class GCD {
    /**
     * 暴力枚举法
     * @param a
     * @param b
     * @return
     */
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

    /**
     * 欧几里得法
     * @param a
     * @param b
     * @return
     */
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

    /**
     * 测试函数
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getByEuclid(2,12));
        System.out.println(getByBruteForce(2,12));
    }
}
