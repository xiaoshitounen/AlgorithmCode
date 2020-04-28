package swu.xl.algorithm.code_04_28.experiment_1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
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

        //存储到达某一个点的最短距离的上一个点的信息
        HashMap<String, String> shortest_routes = new HashMap<>();
        //存储到达某一个点的最短距离
        HashMap<String, Integer> shortest_distances = new HashMap<>();

        //加入起点边信息 起点不需要存储点信息
        shortest_distances.put(origin,0);

        //创建队列
        Queue<String> q = new LinkedList<>();
        //加入第一个点
        q.add("A");

        //所有的点的最短路径求完
        while (q.peek() != null){
            //取出队列首元素
            String node = q.remove();

            //求解出当前点可以到达点的距离信息
            if (routes.get(node) != null){
                //将当前点可以到达的所有下一个点放到队列中
                q.addAll(routes.get(node));

                //依次求解当前点到它可以到达的所有点的距离
                //可能1：这个点没有到达过，直接填入求解的值
                //可能2：这个点到达过，需要判断能否更短
                for (int i = 0; i < routes.get(node).size(); i++) {
                    //取得当前点要到达的点
                    String toNode = routes.get(node).get(i);

                    //取出距离
                    int dist = distances.get(node).get(i);

                    //可能1 还没有到达 直接加入
                    if (!shortest_distances.containsKey(toNode)){
                        shortest_routes.put(toNode,node);
                        shortest_distances.put(toNode,shortest_distances.get(node) + dist);
                    }else {
                        //可能2 到达过 判断能否更短
                        if (shortest_distances.get(toNode) > shortest_distances.get(node) + dist){
                            shortest_routes.put(toNode,node);
                            shortest_distances.put(toNode,shortest_distances.get(node) + dist);
                        }
                    }
                }
            }
        }

        //返回路径
        LinkedList<String> route = new LinkedList<>();
        route.add(destination);
        while (shortest_routes.get(route.get(0)) != null){
            route.add(0,shortest_routes.get(route.get(0)));
        }

        return route;
    }
}