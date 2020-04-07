package swu.xl.algorithm.code_04_07.experiment_5;

public class Solution {
    /**
     * leetcode 面试题63. 股票的最大利润
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        //除开特殊情况
        if (prices.length == 0 || prices.length == 1){
            return 0;
        }

        //将每天的资金数据转化为当天和前一天的数据差->最大子串和问题
        int[] changes = new int[prices.length-1];
        for (int i = 0; i < changes.length; i++) {
            changes[i] = prices[i+1]-prices[i];
        }

        //存储 最大收益 购买时间 卖出时间的变量
        int maxSum = changes[0];

        //累计收益
        int currentMaxSum = changes[0];

        //遍历每一个位置
        for (int currentIndex = 1; currentIndex < changes.length; currentIndex++){
            //如果累计收益不是正的
            if (currentMaxSum <= 0) {
                //重新计算收益
                currentMaxSum = changes[currentIndex];
            }else {
                //收益累加
                currentMaxSum += changes[currentIndex];
            }

            //如果累计收益大于最大收益
            if (currentMaxSum > maxSum){
                //重新计算最大收益
                maxSum = currentMaxSum;
            }
        }

        //交易没有完成
        if (maxSum < 0){
            maxSum = 0;
        }

        return maxSum;
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        int[] num1 = {7,1,5,3,6,4};

        System.out.println(maxProfit(num1));

        int[] num2 = {7,5,4,3,2,1};

        System.out.println(maxProfit(num2));
    }
}
