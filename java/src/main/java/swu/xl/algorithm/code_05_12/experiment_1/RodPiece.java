package swu.xl.algorithm.code_05_12.experiment_1;

public class RodPiece implements Comparable<RodPiece> {
    //木块的长度
    int length;
    //木块对应的价值
    int value;

    //构造方法
    public RodPiece(int length, int value) {
        this.length = length;
        this.value = value;
    }

    @Override
    public int compareTo(RodPiece rodPiece) {
        if ((double)value / (double)length - (double)rodPiece.value / (double)rodPiece.length > 0){
            return 1;
        }else if ((double)value / (double)length - (double)rodPiece.value / (double)rodPiece.length < 0) {
            return -1;
        }else {
            return 0;
        }
    }
}
