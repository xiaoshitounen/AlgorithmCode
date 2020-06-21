package swu.xl.algorithm.code_06_16.experiment_2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Assignment {

    public static int[] get(int[][] cost_matrix) {
        //记录有多少个人可以安排
        int n = cost_matrix.length;

        //记录最佳安排和最少的花费
        int[] best_assignment = new int[n];
        int min_cost = Integer.MAX_VALUE;

        //当前安排的人
        int current_person = 0;

        //记录安排情况和花费
        int[] assignment = new int[n];
        int cost = 0;

        //记录工作的安排情况，-1表示没有安排
        int[] job_flag = new int[n];
        for (int i = 0; i < n; i++) {
            job_flag[i] = -1;
        }

        //计算最小的花费
        int lower_bound = get_lower_bound(assignment,job_flag,current_person-1,cost,cost_matrix);

        //生成初始根节点
        PriorityQueue<NodeInPriorityQueue> queue = new PriorityQueue<>();
        queue.add(
                new NodeInPriorityQueue(
                        assignment,
                        current_person,
                        cost,
                        job_flag,
                        lower_bound
                )
        );
        printPQ(queue);

        //循环得到结果
        while (!queue.isEmpty()){
            //弹出最小上界节点
            NodeInPriorityQueue node = queue.poll();

            //如果该节点下界小于当前最好情况下的花费
            if (node.lower_bound < min_cost) {
                //获取当前操作的是第几个person
                current_person = node.current_person;

                //判断是不是叶子节点
                if (current_person == n-1){
                    //刷新工作安排的情况
                    for (int j = 0; j < n; j++) {
                        //刷新
                        if (node.job_flag[j] == -1){
                            node.assignment[current_person] = j;
                            node.cost += cost_matrix[current_person][j];
                        }
                    }

                    //刷新最小的花费
                    if (node.cost < min_cost){
                        min_cost = node.cost;
                        best_assignment = node.assignment.clone();
                    }
                }else {
                    //工作依次安排
                    for (int i = 0; i < n; i++) {
                        if (node.job_flag[i] == -1){
                            //计算人员安排情况
                            assignment = node.assignment.clone();
                            assignment[current_person] = i;

                            //计算工作安排情况
                            job_flag = node.job_flag.clone();
                            job_flag[i] = current_person;

                            //计算花费
                            cost = node.cost + cost_matrix[current_person][i];

                            //计算下界
                            lower_bound = get_lower_bound(assignment, job_flag,current_person,cost,cost_matrix);

                            //添加节点
                            queue.add(
                                    new NodeInPriorityQueue(
                                        assignment,
                                        current_person+1,
                                        cost,
                                        job_flag,
                                        lower_bound
                                    )
                            );
                        }
                    }
                }
            }

            printPQ(queue);
            printBest(best_assignment,min_cost);
        }

        return best_assignment;
    }

    /**
     * 计算节点下界
     * @param assignment
     * @param job_flag
     * @param current_person
     * @param cost
     * @param cost_matrix
     * @return
     */
    private static int get_lower_bound(int[] assignment, int[] job_flag, int current_person, int cost, int[][] cost_matrix) {
        //获取person的数量
        int n = cost_matrix.length;

        //下界的初值(当前确定的)
        int lower_bound = cost;

        //计算下界(计算当前person之后的)
        for (int i = current_person+1; i < n; i++){
            int temp = cost_matrix[i][0];

            for (int j = 1; j < n; j++) {
                if (job_flag[j] == -1){
                    if (cost_matrix[i][j] < temp){
                        temp = cost_matrix[i][j];
                    }
                }
            }

            lower_bound = lower_bound + temp;
        }

        return lower_bound;
    }

    /**
     * 打印优先队列
     * @param queue
     */
    private static void printPQ(PriorityQueue<NodeInPriorityQueue> queue) {
        System.out.println("-----------");

        for (NodeInPriorityQueue node : queue) {
            System.out.println(node);
        }
    }

    /**
     * 打印当前最好的情况
     * @param best_pack
     * @param min_cost
     */
    private static void printBest(int[] best_pack, double min_cost) {
        System.out.println("Best:"+ Arrays.toString(best_pack) +" "+min_cost);
    }
}
