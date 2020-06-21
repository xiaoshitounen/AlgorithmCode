package swu.xl.algorithm.code_06_16.experiment_1;

/**
 * 物品
 */
public class Item {
    //物品的重量
    double weight;
    //物品的价值
    double value;
    //物品的平均价值
    double unit_value;

    public Item(double weight, double value){
        this.weight = weight;
        this.value = value;
        this.unit_value = value/weight;
    }
}
