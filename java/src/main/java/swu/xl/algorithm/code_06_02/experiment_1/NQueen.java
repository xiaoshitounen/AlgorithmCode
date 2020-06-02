package swu.xl.algorithm.code_06_02.experiment_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueen {
    /**
     * 递归的方式求解N皇后问题
     * @param n 皇后的数目
     */
    public static LinkedList<List<Integer>> getByRecursion(int n){
        //存储所有放置N皇后方式的集合
        LinkedList<List<Integer>> NQueens = new LinkedList<>();
        //存储一种放置N皇后方式的集合
        List<Integer> queens = new ArrayList<>();

        //初始化数据
        for (int i = 0; i < n; i++) {
            queens.add(-1);
        }

        //递归求解
        solveNQueue(queens,0,NQueens);

        return NQueens;
    }

    /**
     * 递归求解
     * @param queens
     * @param currentQueue
     * @param NQueens
     */
    private static void solveNQueue(List<Integer> queens, int currentQueue, LinkedList<List<Integer>> NQueens) {
        //获取每一行放置皇后的的列数
        int column = queens.size();

        //依次放置在每一列
        for (int i = 0; i < column; i++) {
            //设置当前皇后放置的位置
            queens.set(currentQueue,i);

            //判断是否可以放置
            if (check(queens,currentQueue)) {
                //判断是否都放置完毕
                if (currentQueue != column - 1){
                    //接着放置
                    solveNQueue(queens,currentQueue+1,NQueens);
                }else {
                    //放置完毕，产生了一种放置方法
                    List<Integer> temp_queues = new ArrayList<>(queens);
                    NQueens.add(temp_queues);
                }
            }
        }
    }

    /**
     * 迭代的方式求解N皇后的问题
     * @param n
     * @return
     */
    public static LinkedList<List<Integer>> getByIterate(int n){
        //存储所有放置N皇后方式的集合
        LinkedList<List<Integer>> NQueens = new LinkedList<>();
        //存储一种放置N皇后方式的集合
        List<Integer> queens = new ArrayList<>();

        //初始化数据
        for (int i = 0; i < n; i++) {
            queens.add(-1);
        }

        int currentQueue = 0;
        while (currentQueue >= 0){
            //放置当前皇后的位置
            queens.set(currentQueue,queens.get(currentQueue)+1);

            //如果发现位置不可以，往后移动直到找到一个适合的位置
            while (!check(queens,currentQueue) && queens.get(currentQueue) < n) {
                //找到合适的位置放置皇后
                queens.set(currentQueue,queens.get(currentQueue)+1);
            }

            if (queens.get(currentQueue) == n){
                //如果超出了位置，说明无法放置，回到上一层
                currentQueue--;
            }else {
                //判断是否都放置完毕
                if (currentQueue != n-1){
                    //接着放置
                    currentQueue++;
                    queens.set(currentQueue,-1);
                }else {
                    //放置完毕，产生了一种放置方法
                    List<Integer> temp_queues = new ArrayList<>(queens);
                    NQueens.add(temp_queues);
                }
            }
        }

        return NQueens;
    }


    /**
     * 检查位置是否合理
     * @param queues
     * @param currentQueue
     * @return
     */
    private static boolean check(List<Integer> queues, int currentQueue){
        for (int i = 0; i < currentQueue; i++) {
            if (Math.abs(queues.get(i) - queues.get(currentQueue)) == Math.abs(i - currentQueue)
                    || queues.get(i) == queues.get(currentQueue)){
                return false;
            }
        }

        return true;
    }

    /**
     * 测试程序
     * @param args
     */
    public static void main(String[] args) {
        //递归的方式
        LinkedList<List<Integer>> NQueues = getByRecursion(4);
        System.out.println("递归的方式：");
        for (List<Integer> queues : NQueues) {
            for (int i = 0; i < queues.size(); i++) {
                System.out.print(queues.get(i)+" ");
            }
            System.out.println();
        }

        //迭代的方式
        NQueues = getByIterate(4);
        System.out.println("迭代的方式：");
        for (List<Integer> queues : NQueues) {
            for (int i = 0; i < queues.size(); i++) {
                System.out.print(queues.get(i)+" ");
            }
            System.out.println();
        }
    }
}
