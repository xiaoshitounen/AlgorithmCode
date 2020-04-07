package swu.xl.algorithm.code_04_07.experiment_3;


/**
 * 最大子串和问题
 * 投资问题：{最大收益，购买时间，卖出时间}
 */
public class StockBuySell {
    /**
     * 暴力求解
     * @param prices
     * @return
     */
    static int[] getByBruteForce(int[] prices) {
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
     * 分治求解
     * @param prices
     * @return
     */
    static int[] getByDivideConquer(int[] prices) {
        //将每天的资金数据转化为当天和前一天的数据差->最大子串和问题
        int[] changes = new int[prices.length-1];
        for (int i = 0; i < changes.length; i++) {
            changes[i] = prices[i+1]-prices[i];
        }

        return maxSubArray(changes,0,changes.length-1);
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

    /**
     * 求解最大子数组
     * @param changes
     * @param head
     * @param tail
     * @return
     */
    private static int[] maxSubArray(int[] changes, int head, int tail){
        //存储 最大收益 购买时间 卖出时间的变量
        int maxSum = 0,startIndex = 0,endIndex = 0;

        //如果只有一个元素
        if (head == tail){
            maxSum = changes[head];
            startIndex = head;
            endIndex = tail;

            return new int[]{maxSum,startIndex,endIndex};
        }

        //分治处理
        int middle = (head+tail) / 2;

        //左右数组的最大值
        int[] maxLeft = maxSubArray(changes,head,middle);
        int[] maxRight = maxSubArray(changes,middle+1,tail);

        //找出最大值
        if (maxLeft[0] > maxRight[0]){
            maxSum = maxLeft[0];
            startIndex = maxLeft[1];
            endIndex = maxLeft[2];
        }else {
            maxSum = maxRight[0];
            startIndex = maxRight[1];
            endIndex = maxRight[2];
        }

        //包含左右子数组的最大值
        int[] maxTwoSide = maxTwoSide(changes,head,tail,middle);

        //继续找
        if (maxTwoSide[0] > maxSum){
            maxSum = maxTwoSide[0];
            startIndex = maxTwoSide[1];
            endIndex = maxTwoSide[2];
        }

        return new int[]{maxSum,startIndex,endIndex};
    }

    /**
     * 求解包含左右子数组的最大值
     * @param changes
     * @param head
     * @param tail
     * @param middle
     * @return
     */
    private static int[] maxTwoSide(int[] changes, int head, int tail, int middle) {
        //存储 最大收益 购买时间 卖出时间的变量
        int maxSum = 0,startIndex = 0,endIndex = 0;

        //如果只有一个元素
        if (head == tail){
            maxSum = changes[head];
            startIndex = head;
            endIndex = tail;

            return new int[]{maxSum,startIndex,endIndex};
        }

        //记录当前的和
        int currentSum = 0;

        //从索引处向左扩展
        int leftSum = Integer.MIN_VALUE;
        for (int i = middle; i >= head; i--) {
            currentSum += changes[i];

            if (leftSum < currentSum){
                leftSum = currentSum;

                startIndex = i;
            }
        }

        //从索引处向右扩展
        currentSum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = middle+1; i <= tail; i++) {
            currentSum += changes[i];

            if (rightSum < currentSum){
                rightSum = currentSum;

                endIndex = i;
            }
        }

        //最大收益
        maxSum = leftSum + rightSum;

        return new int[]{maxSum,startIndex,endIndex};
    }

}
