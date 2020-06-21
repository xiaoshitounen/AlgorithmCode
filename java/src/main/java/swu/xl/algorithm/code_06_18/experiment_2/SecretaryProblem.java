package swu.xl.algorithm.code_06_18.experiment_2;

import java.util.Arrays;
import java.util.Random;

public class SecretaryProblem {
    /**
     * 检查某一次相亲是否选中最佳的人
     */
    private static boolean check_success(double[] candidates, int stop_time){
        double max_in_observation = 0;
        double choosen = 0;

        //观察选出stop_time之前条件最好的人
        for (int i = 0; i < stop_time; i++) {
            if (candidates[i] > max_in_observation){
                max_in_observation = candidates[i];
            }
        }

        //stop_time之后，只要遇到条件超过之前观察的就选它为相亲对象
        for (int i = stop_time; i < candidates.length; i++) {
            if (candidates[i] >= max_in_observation){
                choosen = candidates[i];
                break;
            }
        }

        //找到stop_time之后，真正条件最好的人
        double max_in_all = max_in_observation;
        for (int i = stop_time; i < candidates.length; i++) {
            if (candidates[i] >= max_in_all) {
                max_in_all = candidates[i];
            }
        }

        //比较得到结果
        if (choosen == max_in_all) return true;
        else return false;
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        //实验次数
        int trial_num = 1000000;
        //一组相亲的次数
        int n = 20;

        //对应成功的次数
        int[] success_times = new int[n];

        for (int i = 0; i < trial_num; i++) {
            //生成一组相亲数据
            double[] candidates = generateRandomNumbers(n);

            //判断每一种选择的成功次数
            for (int stop_time = 0; stop_time < n; stop_time++) {
                if (check_success(candidates,stop_time)){
                    success_times[stop_time]++;
                }
            }
        }

        System.out.println(Arrays.toString(success_times));
    }

    /**
     * 生成一组随机数
     * @param n
     * @return
     */
    private static double[] generateRandomNumbers(int n) {
        double[] randoms = new double[n];

        for (int i = 0; i < n; i++) {
            double v = new Random().nextDouble();

            randoms[i] = v;
        }

        return randoms;
    }
}
