package swu.xl.algorithm.code_05_19.experiment_2;

import java.util.HashMap;
import java.util.LinkedList;

public class ShortestPathTest {
    public static void main(String[] args) {
        HashMap<String, LinkedList<NodeInAdjacencyList>> routeGraph =
                new HashMap<String, LinkedList<NodeInAdjacencyList>>();
        routeGraph.put("A", new LinkedList<NodeInAdjacencyList>());
        routeGraph.get("A").add(new NodeInAdjacencyList("B", 2));
        routeGraph.get("A").add(new NodeInAdjacencyList("C", 4));
        routeGraph.put("B", new LinkedList<NodeInAdjacencyList>());
        routeGraph.get("B").add(new NodeInAdjacencyList("C", 1));
        routeGraph.get("B").add(new NodeInAdjacencyList("D", 3));
        routeGraph.get("B").add(new NodeInAdjacencyList("E", 2));
        routeGraph.put("C", new LinkedList<NodeInAdjacencyList>());
        routeGraph.get("C").add(new NodeInAdjacencyList("E", 3));
        routeGraph.put("D", new LinkedList<NodeInAdjacencyList>());
        routeGraph.get("D").add(new NodeInAdjacencyList("F", 2));
        routeGraph.put("E", new LinkedList<NodeInAdjacencyList>());
        routeGraph.get("E").add(new NodeInAdjacencyList("D", 3));
        routeGraph.get("E").add(new NodeInAdjacencyList("F", 2));
        routeGraph.put("F", new LinkedList<NodeInAdjacencyList>());

        LinkedList<NodeWithShortestPath> shortest_route = ShortestPath.getByDijkstra(routeGraph, "A");
        for(NodeWithShortestPath node : shortest_route) {
            System.out.println(node.name + " - (from " + node.from +  ") - " + node.route_length);
        }
    }
}
