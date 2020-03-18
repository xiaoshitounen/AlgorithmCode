package swu.xl.algorithm.code_03_17.experiment_1;

public class Hanoi {
    //操作的次数
    private static int time = 1;

    public static void move(Tower a, Tower b, Tower c) {
        //开始移动
        move(a.size(),a,b,c);

        //移动成功后
        System.out.println("A:"+a.nums+" "+"B:"+b.nums+" "+"C:"+c.nums);
    }

    public static void move(int n, Tower a, Tower b, Tower c){
        if (n == 1){
            //打印当前三个圆盘的数据
            System.out.println("A:"+findTowerByName(a,b,c,"A").nums+" "+"B:"+findTowerByName(a,b,c,"B").nums+" "+"C:"+findTowerByName(a,b,c,"C").nums);

            //找出被移除的元素
            int move = a.remove();
            c.add(move);

            //打印移动信息
            System.out.println("Operation "+time+": Move "+move+" from "+a.name+" to "+c.name);
            time++;
        }else {
            move(n-1,a,c,b);
            move(1,a,b,c);
            move(n-1,b,a,c);
        }
    }

    /**
     * 根据名字找到Tower
     * @param a
     * @param b
     * @param c
     * @param name
     * @return
     */
    public static Tower findTowerByName(Tower a, Tower b, Tower c, String name){
        if (a.name.equals(name)){
            return a;
        }else if (b.name.equals(name)){
            return b;
        }

        return c;
    }
}
