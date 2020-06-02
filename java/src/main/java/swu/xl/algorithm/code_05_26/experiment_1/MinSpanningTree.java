package swu.xl.algorithm.code_05_26.experiment_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinSpanningTree {
    /**
     * Prim算法求解最小生成树-节点贪心算法
     * @param graph
     * @return
     */
    public static LinkedList<Edge> getByPrim(HashMap<String, LinkedList<NodeInAdjacencyList>> graph) {
        //存储最终连接的边的信息或者说已决集
        LinkedList<Edge> spanningTree = new LinkedList<>();
        //模拟双向链表的头结点
        NodeWithDistanceInRankedList unsettled = null;
        //存储未决集的节点
        HashMap<String, NodeWithDistanceInRankedList> nodes_with_distance = new HashMap<>();

        //模拟双向链表加入第一个点
        HashSet<String> vertexSet = new HashSet<>(graph.keySet());
        String startVertex = vertexSet.iterator().next();
        NodeWithDistanceInRankedList previous = new NodeWithDistanceInRankedList(startVertex,startVertex,0,null,null);
        nodes_with_distance.put(startVertex,previous);
        unsettled = previous;
        vertexSet.remove(startVertex);

        //依次在双向链表中加入剩余的点
        for (String v : vertexSet) {
            NodeWithDistanceInRankedList newNode = new NodeWithDistanceInRankedList(v, startVertex, Integer.MAX_VALUE, previous, null);
            previous.next = newNode;
            nodes_with_distance.put(v,newNode);
            previous = newNode;
        }

        while (unsettled != null){
            //如果不是第一个点就加入已决集
            if (!unsettled.name.equals(startVertex)){
                spanningTree.add(new Edge(unsettled.name,unsettled.from));
                unsettled.distance = 0;
            }

            //依次判断
            for (NodeInAdjacencyList node : graph.get(unsettled.name)) {
                //如果有更短到达的边
                if (node.road_length < nodes_with_distance.get(node.name).distance){
                    nodes_with_distance.get(node.name).changeDistance(unsettled.name,node.road_length);
                }
            }

            //模拟的头指针后移
            if (unsettled.next != null){
                unsettled.next.previous = null;
            }
            unsettled = unsettled.next;
        }


        return spanningTree;
    }

    /**
     * Kruskal算法求解最小生成树-连边贪心算法
     * @param graph
     * @return
     */
    public static LinkedList<Edge> getByKruskal(HashMap<String, LinkedList<NodeInAdjacencyList>> graph) {
        //存储最终连接的边的信息或者说已决集
        LinkedList<Edge> spanningTree = new LinkedList<>();

        //创建并查集并初始化数据
        Union<String> vertexUnion = new Union<>();
        for (String v : graph.keySet()) {
            vertexUnion.add(v);
        }

        //优先队列
        PriorityQueue<EdgeWithLength> edgePQ = new PriorityQueue<>();
        //存储点
        HashSet<String> edgeStrSet = new HashSet<>();

        //优先队列和边信息的集合数据填充
        for (String v : graph.keySet()) {
            for (NodeInAdjacencyList adjNode : graph.get(v)) {
                //创建这条边的信息
                String edgeStr = new Edge(v, adjNode.name).toString();

                //如果这条边还没有包含进来
                if (!edgeStrSet.contains(edgeStr)){
                    //创建含有边值的边加入优先队列
                    EdgeWithLength e = new EdgeWithLength(v, adjNode.name, adjNode.road_length);
                    edgePQ.add(e);

                    //这条边的信息加入到集合中
                    edgeStrSet.add(edgeStr);
                }
            }
        }

        //依次找到最短的边是所有点都加入到集合中
        while (edgePQ.size() > 0){
            //弹出一个含有边值的边
            EdgeWithLength edge = edgePQ.poll();

            //判断能否加入
            if (!vertexUnion.isSameUnion(edge.firstVertex,edge.secondVertex)){
                //加入
                spanningTree.add(new Edge(edge.firstVertex,edge.secondVertex));

                //并查集 内容更新
                vertexUnion.union(edge.firstVertex,edge.secondVertex);
            }
        }

        return spanningTree;
    }
}
