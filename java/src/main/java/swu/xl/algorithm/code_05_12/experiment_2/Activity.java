package swu.xl.algorithm.code_05_12.experiment_2;

public class Activity implements Comparable<Activity> {
    //编号
    int No;
    //活动开始时间
    int startTime;
    //活动结束时间
    int endTime;

    //构造方法
    public Activity(int no, int startTime, int endTime) {
        No = no;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Activity activity) {
        return endTime - activity.endTime;
    }
}
