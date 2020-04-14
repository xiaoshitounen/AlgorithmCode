package swu.xl.algorithm.code_04_14.experiment_1;

public class StockBuySell {

    /**
     * 暴力求解
     * @param prices
     * @return
     */
    public static int[] getByBruteForce(int[] prices) {
        //存储 最大收益 购买时间 卖出时间的变量
        int maxSum = 0,startIndex = 0,endIndex = 0;

        //遍历每一种情况
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                //如果收益超过了当前的最大值 更换最大值
                if (prices[j] - prices[i] > maxSum){
                    maxSum = prices[j] - prices[i];
                    startIndex = i;
                    endIndex = j;
                }
            }
        }

        return new int[]{maxSum,startIndex,endIndex};
    }

    /**
     * 动态规划求解
     * @param prices
     * @return
     */
    public static int[] getByDynamicProgramming(int[] prices) {
        //将每天的资金数据转化为当天和前一天的数据差->最大子串和问题
        int[] changes = new int[prices.length-1];
        for (int i = 0; i < changes.length; i++) {
            changes[i] = prices[i+1]-prices[i];
        }

        //存储 最大收益 购买时间 卖出时间的变量
        int maxSum = changes[0],startIndex = 0,endIndex = 0;

        //累计收益
        int currentMaxSum = changes[0];

        //遍历每一个位置
        for (int currentIndex = 1; currentIndex < changes.length; currentIndex++){
            //如果累计收益不是正的
            if (currentMaxSum <= 0) {
                //重新计算收益
                currentMaxSum = changes[currentIndex];

                //更改起始位置
                startIndex = currentIndex;
            }else {
                //收益累加
                currentMaxSum += changes[currentIndex];
            }

            //如果累计收益大于最大收益
            if (currentMaxSum > maxSum){
                //重新计算最大收益
                maxSum = currentMaxSum;

                //更改结束位置
                endIndex = currentIndex;
            }
        }

        return new int[]{maxSum,startIndex,endIndex};
    }

}
