package swu.xl.algorithm.code_05_12.experiment_1;

import java.util.Arrays;
import java.util.Collections;

public class RodCut {
    /**
     * 切木块-贪心
     *
     * @param cut_values
     * @param rod_length
     * @return
     */
    public static int getValueByGreedy(int[] cut_values, int rod_length) {
        //木块价值表的长度
        int n = cut_values.length;

        //存储木块价值表中每一个对应的RodPiece
        RodPiece[] rod_pieces = new RodPiece[n];
        //初始化
        for (int i = 0; i < n; i++) {
            rod_pieces[i] = new RodPiece(i + 1, cut_values[i]);
        }

        //从大到小排序
        Arrays.sort(rod_pieces, Collections.<RodPiece>reverseOrder());

        //记录价值
        int value = 0;

        //贪心寻找
        for (int i = 0; i < n; i++) {
            //能切成当前木块几次就切几次
            value += rod_pieces[i].value * (rod_length / rod_pieces[i].length);

            //木块长度减少
            rod_length = rod_length % rod_pieces[i].length;
        }

        return value;
    }

    /**
     * 切木块-动态规划
     *
     * @param cut_value
     * @param rod_length
     * @return
     */
    public static int getValueByDP(int[] cut_value, int rod_length) {
        //存储每一个子阶段的最大价值
        int[] rod_value = new int[rod_length];

        //长度为1的木头价值就是其本身
        rod_value[0] = cut_value[0];

        //依次求解之后每个子阶段的最大值
        for (int i = 1; i < rod_length; i++) {
            //因为有可能最大的cut_value < rod_length
            //所以需要判断能不能不切直接卖
            rod_value[i] = cut_value[Math.min(i, cut_value.length - 1)];

            //依次比较
            for (int j = 0; j <= i - j - 1; j++) {
                rod_value[i] = Math.max(
                        rod_value[i],
                        rod_value[j] + rod_value[i - j - 1]
                );
            }
        }

        return rod_value[rod_length - 1];
    }
}
