package swu.xl.algorithm.code_05_12.experiment_2;

import java.util.Arrays;
import java.util.LinkedList;

class ActivitySelection {
    /**
     * 活动选择问题-贪心
     * @param activityStartEndTime
     * @return
     */
    public static LinkedList<Integer> selectFrom(int[][] activityStartEndTime){
        //活动的个数
        int n = activityStartEndTime.length;

        //存储每一个活动对应的Activity的集合
        Activity[] activities = new Activity[n];
        //初始化
        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(i + 1, activityStartEndTime[i][0], activityStartEndTime[i][1]);
        }

        //按照活动结束时间从小到大排序
        Arrays.sort(activities);

        //存储选择的活动
        LinkedList<Integer> selectActivities = new LinkedList<>();
        //第一个活动直接加入
        selectActivities.add(activities[0].No);
        //记录之前活动的结束时间
        int previousEndTime = activities[0].endTime;

        //贪心找到所有的活动
        for (int i = 0; i < n; i++) {
            if (activities[i].startTime >= previousEndTime) {
                //添加活动
                selectActivities.add(activities[i].No);

                //更新上一个活动的结束时间
                previousEndTime = activities[i].endTime;
            }
        }

        return selectActivities;
    }
}
