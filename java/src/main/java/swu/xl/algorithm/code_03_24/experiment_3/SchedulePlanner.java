package swu.xl.algorithm.code_03_24.experiment_3;

public class SchedulePlanner {
    /**
     * 比赛日常表
     * @param k
     * @return
     */
    public static int[][] getSchedule(int k){
        //求得参赛人数
        int n = (int) Math.pow(2,k);
        //System.out.println(n);

        //创建日常二维数组
        int[][] schedule = new int[n][n];

        //明确第一位同学的比赛情况和确定每一组选手
        scheduleInit(schedule,n);

        //枚举剩下每一位选手
        for (int i = 1; i < n; i++) {
            //枚举当前选手的所有比赛
            for (int j = 1; j < n; j++) {
                //找到当前位置可以参赛的选手
                schedule[i][j] = findPerson(schedule,i,j,n);
            }
        }

        return schedule;
    }

    /**
     * 找到可以参赛的选手
     * @param schedule
     * @param row
     * @param col
     * @param n
     * @return
     */
    private static int findPerson(int[][] schedule, int row, int col, int n) {
        //存储参赛的选手
        int person = 0;

        //遍历每一个参赛选手
        for (int p = 1; p <= n; p++) {
            //表明该选手是否符合身份
            int flag = 0;

            //首先该选手在当天不能和其他人比赛
            //从第一个选手枚举到上一个选手
            //比较枚举的值是否和他们冲突
            for (int x = 0; x < row; x++) {
                if (schedule[x][col] == p){
                    flag = 1;
                    break;
                }
            }

            //如果第一个条件不满足，直接枚举下一个可能
            if (flag == 1){
                continue;
            }

            //其次该选手还没有和当前选手比较
            //从当前选手的第一常比赛一直枚举到上一场比赛
            //比较枚举的值是否参加过
            for (int y = 0; y < col; y++) {
                if (schedule[row][y] == p){
                    flag = 1;
                    break;
                }
            }

            //找到了就返回，否则继续枚举
            if (flag == 1){
                continue;
            }else {
                person = p;
                return p;
            }
        }

        return person;
    }

    /**
     * 时间安排表初始化
     * @param schedule
     * @param n
     */
    private static void scheduleInit(int[][] schedule, int n) {
        for (int i = 0; i < n; i++) {
            schedule[0][i] = i+1;
        }

        for (int i = 1; i < n; i++) {
            schedule[i][0] = i+1;
        }
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        int[][] schedule = getSchedule(3);

        int row = schedule.length;
        int col = schedule[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(schedule[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
