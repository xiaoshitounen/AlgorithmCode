package swu.xl.algorithm.code_05_26.experiment_1;

import java.util.HashMap;
import java.util.LinkedList;

public class MinSpanningTreeTest {
    public static void main(String[] args) {
        HashMap<String, LinkedList<NodeInAdjacencyList>> graph =
                new HashMap<String, LinkedList<NodeInAdjacencyList>>();
        graph.put("0", new LinkedList<NodeInAdjacencyList>());
        graph.get("0").add(new NodeInAdjacencyList("1", 25));
        graph.get("0").add(new NodeInAdjacencyList("3", 75));
        graph.get("0").add(new NodeInAdjacencyList("4", 150));
        graph.put("1", new LinkedList<NodeInAdjacencyList>());
        graph.get("1").add(new NodeInAdjacencyList("0", 25));
        graph.get("1").add(new NodeInAdjacencyList("2", 50));
        graph.get("1").add(new NodeInAdjacencyList("5", 150));
        graph.put("2", new LinkedList<NodeInAdjacencyList>());
        graph.get("2").add(new NodeInAdjacencyList("1", 50));
        graph.get("2").add(new NodeInAdjacencyList("5", 120));
        graph.put("3", new LinkedList<NodeInAdjacencyList>());
        graph.get("3").add(new NodeInAdjacencyList("0", 75));
        graph.get("3").add(new NodeInAdjacencyList("4", 100));
        graph.put("4", new LinkedList<NodeInAdjacencyList>());
        graph.get("4").add(new NodeInAdjacencyList("0", 150));
        graph.get("4").add(new NodeInAdjacencyList("3", 100));
        graph.get("4").add(new NodeInAdjacencyList("6", 300));
        graph.get("4").add(new NodeInAdjacencyList("7", 325));
        graph.put("5", new LinkedList<NodeInAdjacencyList>());
        graph.get("5").add(new NodeInAdjacencyList("1", 150));
        graph.get("5").add(new NodeInAdjacencyList("2", 120));
        graph.get("5").add(new NodeInAdjacencyList("8", 200));
        graph.put("6", new LinkedList<NodeInAdjacencyList>());
        graph.get("6").add(new NodeInAdjacencyList("4", 300));
        graph.get("6").add(new NodeInAdjacencyList("7", 100));
        graph.get("6").add(new NodeInAdjacencyList("9", 250));
        graph.put("7", new LinkedList<NodeInAdjacencyList>());
        graph.get("7").add(new NodeInAdjacencyList("4", 325));
        graph.get("7").add(new NodeInAdjacencyList("6", 100));
        graph.get("7").add(new NodeInAdjacencyList("8", 100));
        graph.get("7").add(new NodeInAdjacencyList("10", 400));
        graph.put("8", new LinkedList<NodeInAdjacencyList>());
        graph.get("8").add(new NodeInAdjacencyList("5", 200));
        graph.get("8").add(new NodeInAdjacencyList("7", 100));
        graph.get("8").add(new NodeInAdjacencyList("10", 300));
        graph.put("9", new LinkedList<NodeInAdjacencyList>());
        graph.get("9").add(new NodeInAdjacencyList("6", 250));
        graph.get("9").add(new NodeInAdjacencyList("10", 50));
        graph.put("10", new LinkedList<NodeInAdjacencyList>());
        graph.get("10").add(new NodeInAdjacencyList("7", 400));
        graph.get("10").add(new NodeInAdjacencyList("8", 300));
        graph.get("10").add(new NodeInAdjacencyList("9", 50));


        LinkedList<Edge> edges1 = MinSpanningTree.getByPrim(graph);
        System.out.println("Results from Prim:");
        for(Edge e : edges1) {
            System.out.println(e);
        }

        LinkedList<Edge> edges2 = MinSpanningTree.getByKruskal(graph);
        System.out.println("Results from Kruskal:");
        for(Edge e : edges2) {
            System.out.println(e);
        }
    }
}
