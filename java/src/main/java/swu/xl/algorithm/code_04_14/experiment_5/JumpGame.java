package swu.xl.algorithm.code_04_14.experiment_5;

/**
 * 跳跃游戏
 */
public class JumpGame {
    //暴力求解法
    //思路：遍历每一个位置，找到该位置可以跳的所有位置，打上标记
    //缺点：有的位置可能多次被打上标记，浪费时间
    public static boolean canJumpByBruteForce(int[] nums){
        //记录每一个位置是否可以跳
        boolean[] reachable = new boolean[nums.length];
        //第一个位置默认是可以跳的
        reachable[0] = true;

        //枚举每一个位置，给每个位置可以跳到的位置打上标记
        for (int i = 0; i < nums.length - 1; i++) {
            //判断当前位置是否可以到达
            if (reachable[i]){
                //找到当前位置可以跳的所有位置（不能越界），打上标记
                for (int j = 1; j <= nums[i] && i+j < nums.length; j++) {
                    reachable[i+j] = true;
                }
            }
        }

        return reachable[nums.length-1];
    }

    //动态规划
    //思路：主要解决了暴力求解可能多次打上标记的问题
    //倒着跳，从倒数第二个位置开始跳看是否能跳到第一个（子问题：第二个能否跳到第一个也倒着跳）
    //不能的话从倒数第三个位置开始跳看是否能跳到第一个
    //...
    //这样就避免了重复打标记的问题
    public static boolean canJumpByDp(int[] nums){
        return canJump(nums,nums.length-1);
    }

    //能否从第tail+1个位置跳到第一个位置
    public static boolean canJump(int[] nums, int tail){
        //递归结束的条件
        //判断是否跳到了第一个
        if (tail == 0){
            return true;
        }

        //依次倒着跳，找到结果就跳出来
        for (int i = tail-1; i >= 0; i--){
            //判断当前位置是否可以跳到上一个位置
            if (i + nums[i] >= tail) {
                //慢慢跳
                return canJump(nums,i);
            }
        }

        //代码进入到这里肯定没成功
        return false;
    }

    //巧妙解法：不能出现 "0" 点
    //两个选择：1.不能出现0点
    //        2.该0点可以被跳掉
    public static boolean canJumpByZeroPoint(int[] nums){
        //数组长度
        int n = nums.length;

        //是否有0点,默认状态-1,没有0点
        int zeroPoint = -1;

        //从倒数第二个位置开始
        for (int i = n-2; i >= 0; i--) {
            //判断当前位置是不是0点
            if (nums[i] == 0){
                //存在0点
                //首先记录第一个0点
                //如果之后出现了可以跳过的点
                //那么就算之间出现的新的0点
                //也会被跳过去，无需考虑
                //
                //如果跳不过去，白搭
                if (zeroPoint == -1){
                    //设置0点的位置
                    zeroPoint = i;
                }
            }else if (zeroPoint != -1) {
                //当前位置不是0点，且之前有0点，检查是否能跳过
                if (i + nums[i] > zeroPoint) {
                    zeroPoint = -1;
                }
            }

        }

        return zeroPoint == -1;
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        int[] num1 = {2,3,1,1,4};
        int[] num2 = {3,2,1,0,4};

        System.out.println(canJumpByBruteForce(num1));
        System.out.println(canJumpByBruteForce(num2));

        System.out.println(canJumpByDp(num1));
        System.out.println(canJumpByDp(num2));

        System.out.println(canJumpByZeroPoint(num1));
        System.out.println(canJumpByZeroPoint(num2));
    }
}
