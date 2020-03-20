package swu.xl.algorithm.code_03_17.experiment_1;

/**
 * leetcode 面试题08.06
 */
public class Hanoi {
    //操作的次数
    private static int time = 1;

    public static void move(Tower a, Tower b, Tower c) {
        //开始移动
        move(a.size(),a,b,c);

        //移动成功后
        System.out.println(a+" "+b+" "+c);
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
            //先把上面 n - 1 个盘子从 A 移到 B
            move(n-1,a,c,b);
            //再将最大的盘子从 A 移到 C
            move(1,a,b,c);
            //再将 B 上 n - 1 个盘子从 B 移到 C（子问题，递归）
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
