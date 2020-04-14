package swu.xl.algorithm.code_04_14.experiment_2;

public class RodCut {
    /**
     * 求解切木块问题
     * @param cut_value
     * @param rod_length
     * @return
     */
    public static int getValue(int[] cut_value, int rod_length) {
        //创建一个价值数组 prices[i] 长度为i的木棍可以卖出的最大价值
        int[] prices = new int[rod_length+1];
        //长度为1就不需要切了
        prices[1] = cut_value[0];

        //有价值的最大长度
        int length = cut_value.length;

        //依次找到给定长度的价值
        for (int i = 2; i <= rod_length; i++) {
            //记录最大值
            int maxValue = 0;

            //找到需要继续分割的最小索引
            int index = i % 2 == 0 ? i / 2 : i / 2 + 1;
            //System.out.println(index);

            //长度为10以内的木块可以不切直接卖
            if (i <= 10){
                //默认值设置为不切割直接卖
                maxValue = cut_value[i-1];

                //依次找到分割可能 并找出最大值
                for (int j = i -1; j >= index; j--){
                    maxValue = Math.max(maxValue,prices[j]+prices[i-j]);
                }
            }else {
                //依次找到分割可能 并找出最大值
                for (int j = 10; j >= index; j--){
                    maxValue = Math.max(maxValue,prices[j]+prices[i-j]);
                }
            }

            //将最大价值赋值给对应位置
            prices[i] = maxValue;
        }

        return prices[rod_length];
    }
}
