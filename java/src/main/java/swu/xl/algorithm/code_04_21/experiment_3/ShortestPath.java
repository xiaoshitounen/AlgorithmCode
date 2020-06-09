package swu.xl.algorithm.code_04_21.experiment_3;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class ShortestPath {
    /**
     * 最短路径问题（有向无环图）
     * @param routes
     * @param distances
     * @param origin
     * @param destination
     * @return
     */
    public static LinkedList<String> getByDP(
            HashMap<String, LinkedList<String>> routes,
            HashMap<String, LinkedList<Integer>> distances,
            String origin, String destination) {

        HashMap<String, String> shortest_routes = new HashMap<>();
        HashMap<String, Integer> shortest_distances = new HashMap<>();

        //加入起点边信息 起点不需要存储点信息
        shortest_distances.put("A",0);

        //创建队列
        Queue<String> q = new LinkedList<>();
        //加入第一个点
        q.add("A");

        //所有的点的最短路径求完
        while (q.peek() != null){
            //取出队列首元素
            String node = q.remove();

            //求出到达取出元素所需的距离
            int base_distance = shortest_distances.get(node);

            //求解出当前点可以到达点的距离信息
            if (routes.get(node) != null){
                //node能达到的结点的点信息
                LinkedList<String> endString = routes.get(node);
                //node能达到的结点的边信息
                LinkedList<Integer> endInteger = distances.get(node);

                //循环遍历指定结点指向的所有结点
                for (int i = 0; i < endString.size(); i++) {
                    //如果已经可以到达，比较距离
                    if (shortest_distances.get(endString.get(i)) != null){
                        if (shortest_distances.get(endString.get(i)) > base_distance + endInteger.get(i)){
                            shortest_routes.put(endString.get(i), node);
                            shortest_distances.put(endString.get(i), base_distance + endInteger.get(i));
                        }
                    }else {
                        //没有到达过，直接加入点信息，边信息
                        shortest_routes.put(endString.get(i), node);
                        shortest_distances.put(endString.get(i), base_distance + endInteger.get(i));

                        //加入到队列中
                        q.add(endString.get(i));
                    }
                }
            }
        }

        //返回
        LinkedList<String> route = new LinkedList<>();
        route.add("F");

        //还没有到起点
        while (!shortest_routes.get(destination).equals(origin)){
            //加入数据
            route.add(shortest_routes.get(destination));

            //前移
            destination = shortest_routes.get(destination);
        }
        route.add(origin);
        Collections.reverse(route);

        return route;
    }
}


