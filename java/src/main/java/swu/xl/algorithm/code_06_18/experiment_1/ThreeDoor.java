package swu.xl.algorithm.code_06_18.experiment_1;

import java.util.Random;

public class ThreeDoor {
    public static void main(String[] args) {
        int trial_num = 10000;
        int change_revenue;
        int no_change_revenue;

        //选手没有改变选择的情况下，10000次下成功的概率
        no_change_revenue = 0;
        for (int i = 0; i < trial_num; i++) {
            int real = new Random().nextInt(3);
            int choose = new Random().nextInt(3);
            if (real == choose){
                no_change_revenue = no_change_revenue + 1;
            }
        }

        //选手改变选择的情况，10000次下成功的概率
        change_revenue = 0;
        for (int i = 0; i < trial_num; i++) {
            int real = new Random().nextInt(3);
            int choose = new Random().nextInt(3);

            if (real != choose){
                change_revenue = change_revenue + 1;
            }
        }

        System.out.println("Change revenue："+change_revenue+"; not change revenue："+no_change_revenue);
    }
}
