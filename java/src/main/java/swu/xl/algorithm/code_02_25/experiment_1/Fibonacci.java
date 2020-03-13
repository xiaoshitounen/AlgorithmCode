package swu.xl.algorithm.code_02_25.experiment_1;

/**
 * 求解斐波那契数
 */
public class Fibonacci {
    /**
     * 递归法
     * @param n
     * @return
     */
    public static long getByRecursion(long n){
        if(n == 1 || n == 2){
            return 1;
        }

        return getByRecursion(n-1) + getByRecursion(n-2);
    }

    /**
     * 迭代法
     * @param n
     * @return
     */
    public static long getByIteration(long n){
        long a = 1;
        long b = 1;

        if(n == 1 || n == 2){
            return 1;
        }

        long temp = 0;
        for(int i = 3; i <= n; i ++) {
            temp = a + b;

            a = b;
            b = temp;
        }

        return temp;
    }
}
