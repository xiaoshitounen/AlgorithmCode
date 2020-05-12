package swu.xl.algorithm.code_04_21.experiment_1;

/**
 * 切木头问题 动态规划
 */
public class RodCut {
    /**
     * 表格法：自下而上
     * @param cut_value
     * @param rod_length
     * @return
     */
    public static int getValueByTabulation(int[] cut_value, int rod_length){
        //存储每一个子阶段的最大价值
        int[] rod_value = new int[rod_length];

        //长度为1的木头价值就是其本身
        rod_value[0] = cut_value[0];

        //依次求解之后每个子阶段的最大值
        for (int i = 1; i < rod_length; i++) {
            //因为有可能最大的cut_value < rod_length
            //所以需要判断能不能不切直接卖
            rod_value[i] = cut_value[Math.min(i,cut_value.length-1)];

            //依次比较
            for (int j = 0; j <= i-j-1; j++) {
                rod_value[i] = Math.max(
                        rod_value[i],
                        rod_value[j] + rod_value[i-j-1]
                );
            }
        }

        return rod_value[rod_length-1];
    }

    /**
     * 备忘录法：自上而下
     * @param cut_value
     * @param rod_length
     * @return
     */
    public static int getValueByMemoization(int[] cut_value, int rod_length){
        //存储每一个子阶段的最大价值
        int[] rod_value = new int[rod_length];

        //长度为1的木头价值就是其本身
        rod_value[0] = cut_value[0];

        return getValueByMemoization(cut_value, rod_length, rod_value);
    }

    //重载
    private static int getValueByMemoization(int[] cut_value, int rod_length, int[] rod_value) {
        //递归结束条件
        if (rod_value[rod_length-1] > 0) return rod_value[rod_length-1];

        //因为有可能最大的cut_value < rod_length
        //所以需要判断能不能不切直接卖
        rod_value[rod_length-1] = cut_value[Math.min(rod_length-1,cut_value.length-1)];

        //依次比较
        for (int j = 0; j <= (rod_length-1) - j -1; j++) {
            rod_value[rod_length-1] = Math.max(
                    rod_value[rod_length-1],
                    getValueByMemoization(cut_value,j+1,rod_value) +
                    getValueByMemoization(cut_value,rod_length-j-1,rod_value)
            );
        }

        return rod_value[rod_length-1];
    }
}
