package swu.xl.algorithm.code_05_19.experiment_2;

import java.util.HashMap;
import java.util.LinkedList;

import swu.xl.algorithm.code_04_28.experiment_1.ShortestPath;

public class Dijkstra {
    /**
     * 迪杰斯特拉算法-求解带权有向图的最短路径问题
     * @param routeGraph
     * @param start
     * @return
     */
    public static LinkedList<NodeWithShortestPath> getByDijkstra(HashMap<String,LinkedList<NodeInAdjacencyList>> routeGraph, String start){
        //存储已决集的结点
        LinkedList<NodeWithShortestPath> shortest_route = new LinkedList<>();

        //模拟优先队列存储未决集的节点
        HashMap<String, NodeWithShortestPathInRankedList> nodes_with_shortest_route = new HashMap<>();

        //模拟存储未决节点集合的头指针
        NodeWithShortestPathInRankedList rankedList = null;
        //模拟存储未决集节点集合的尾指针
        NodeWithShortestPathInRankedList previous = null;

        //遍历所有位置 创建双向循环列表的过程
        for (String node_name : routeGraph.keySet()) {
            //创建未决集的节点
            NodeWithShortestPathInRankedList new_node;

            //如果是第一个节点
            if (node_name.equals(start)){
                //创建第一个节点 前置指针和后置指针都是null
                new_node = new NodeWithShortestPathInRankedList(node_name,0,start,null,null);
                //头指针指向第一个节点
                rankedList = new_node;
            }else {
                //创建新的结点 前置指针指向上一个节点，后置指针是null
                new_node = new NodeWithShortestPathInRankedList(node_name,(int)Integer.MAX_VALUE,"",previous,null);
                //上一个节点的后置指针指向新的结点
                previous.next = new_node;
            }

            //尾指针指向最后的结点
            previous = new_node;

            //存储未决节点，用来下面的遍历
            nodes_with_shortest_route.put(node_name,new_node);
        }

        //只有还有未决集的节点，就继续
        while (rankedList != null){
            //第一个节点直接加入
            shortest_route.add(new NodeWithShortestPath(rankedList.name,rankedList.from, rankedList.route_length));

            //遍历每一个未决集节点 调整位置
            for (NodeInAdjacencyList node : routeGraph.get(rankedList.name)) {
                //如果到达未决集节点的距离有变化，判断是否更小
                if (node.road_length + rankedList.route_length < nodes_with_shortest_route.get(node.name).route_length){
                    //更新数据以及交换位置
                    nodes_with_shortest_route.get(node.name).changeRoute(rankedList.name,node.road_length + rankedList.route_length);
                }
            }

            //未决结点成为已决结点，弹出
            if (rankedList.next != null){
                //即将成为头节点的结点的前置指针置空
                rankedList.next.previous = null;
            }
            //头指针指向新的位置
            rankedList = rankedList.next;
        }

        return shortest_route;
    }

    public static void main(String[] args) {
        HashMap<String,LinkedList<NodeInAdjacencyList>> routeGraph = new HashMap<>();

        routeGraph.put("A",new LinkedList<NodeInAdjacencyList>());
        routeGraph.get("A").add(new NodeInAdjacencyList("B",2));
        routeGraph.get("A").add(new NodeInAdjacencyList("C",4));

        routeGraph.put("B",new LinkedList<NodeInAdjacencyList>());
        routeGraph.get("B").add(new NodeInAdjacencyList("C",1));
        routeGraph.get("B").add(new NodeInAdjacencyList("D",3));
        routeGraph.get("B").add(new NodeInAdjacencyList("E",2));

        routeGraph.put("C",new LinkedList<NodeInAdjacencyList>());
        routeGraph.get("C").add(new NodeInAdjacencyList("E",3));

        routeGraph.put("D",new LinkedList<NodeInAdjacencyList>());
        routeGraph.get("D").add(new NodeInAdjacencyList("F",2));

        routeGraph.put("E",new LinkedList<NodeInAdjacencyList>());
        routeGraph.get("E").add(new NodeInAdjacencyList("D",3));
        routeGraph.get("E").add(new NodeInAdjacencyList("F",2));

        routeGraph.put("F",new LinkedList<NodeInAdjacencyList>());

        LinkedList<NodeWithShortestPath> shortest_route = getByDijkstra(routeGraph, "A");
        for (NodeWithShortestPath node : shortest_route) {
            System.out.println(node.name+" -（from "+node.from+"）- "+node.route_length);
        }
    }
}












