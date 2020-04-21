package swu.xl.algorithm.code_04_21.experiment_3;

import java.util.HashMap;
import java.util.LinkedList;

public class ShortestPathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, LinkedList<String>> routes = new HashMap<String, LinkedList<String>>(); 
		HashMap<String, LinkedList<Integer>> distances = new HashMap<String, LinkedList<Integer>>();
		
		routes.put("A", new LinkedList<String>());
		distances.put("A", new LinkedList<Integer>());
		routes.get("A").add("B1"); distances.get("A").add(4);
		routes.get("A").add("B2"); distances.get("A").add(5);
		
		routes.put("B1", new LinkedList<String>());
		distances.put("B1", new LinkedList<Integer>());
		routes.get("B1").add("C1"); distances.get("B1").add(2);
		routes.get("B1").add("C2"); distances.get("B1").add(3);
		routes.get("B1").add("C3"); distances.get("B1").add(6);
		
		routes.put("B2", new LinkedList<String>());
		distances.put("B2", new LinkedList<Integer>());
		routes.get("B2").add("C2"); distances.get("B2").add(8);
		routes.get("B2").add("C3"); distances.get("B2").add(7);
		routes.get("B2").add("C4"); distances.get("B2").add(7);
		
		routes.put("C1", new LinkedList<String>());
		distances.put("C1", new LinkedList<Integer>());
		routes.get("C1").add("D1"); distances.get("C1").add(5);
		routes.get("C1").add("D2"); distances.get("C1").add(8);
		
		routes.put("C2", new LinkedList<String>());
		distances.put("C2", new LinkedList<Integer>());
		routes.get("C2").add("D1"); distances.get("C2").add(4);
		routes.get("C2").add("D2"); distances.get("C2").add(5);
		
		routes.put("C3", new LinkedList<String>());
		distances.put("C3", new LinkedList<Integer>());
		routes.get("C3").add("D2"); distances.get("C3").add(3);
		routes.get("C3").add("D3"); distances.get("C3").add(4);
		
		routes.put("C4", new LinkedList<String>());
		distances.put("C4", new LinkedList<Integer>());
		routes.get("C4").add("D2"); distances.get("C4").add(8);
		routes.get("C4").add("D3"); distances.get("C4").add(4);
		
		routes.put("D1", new LinkedList<String>());
		distances.put("D1", new LinkedList<Integer>());
		routes.get("D1").add("E1"); distances.get("D1").add(3);
		routes.get("D1").add("E2"); distances.get("D1").add(5);
		
		routes.put("D2", new LinkedList<String>());
		distances.put("D2", new LinkedList<Integer>());
		routes.get("D2").add("E1"); distances.get("D2").add(6);
		routes.get("D2").add("E2"); distances.get("D2").add(2);
		
		routes.put("D3", new LinkedList<String>());
		distances.put("D3", new LinkedList<Integer>());
		routes.get("D3").add("E1"); distances.get("D3").add(1);
		routes.get("D3").add("E2"); distances.get("D3").add(3);
		
		routes.put("E1", new LinkedList<String>());
		distances.put("E1", new LinkedList<Integer>());
		routes.get("E1").add("F"); distances.get("E1").add(4);
		
		routes.put("E2", new LinkedList<String>());
		distances.put("E2", new LinkedList<Integer>());
		routes.get("E2").add("F"); distances.get("E2").add(3);	

		LinkedList<String> route = ShortestPath.getByDP(routes,distances,"A","F");
		System.out.println(route.toString());
		
	}

}
