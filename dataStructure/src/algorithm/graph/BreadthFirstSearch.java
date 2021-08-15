package algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 시간 복잡도 : O(V+E) <= V 노드 수, E 간선 수
public class BreadthFirstSearch {
	
	public ArrayList<String> search(HashMap<String, ArrayList<String>> graph, String startNode){
		ArrayList<String> visited = new ArrayList<>();
		ArrayList<String> needVisit = new ArrayList<>();
		
		visited.add(startNode);
		needVisit.addAll(graph.get(startNode));
		while(!needVisit.isEmpty()) {
			String node = needVisit.remove(0);
			
			if(!visited.contains(node)) {
				visited.add(node);
				needVisit.addAll(graph.get(node));
			}
		}
		return visited;
	}

	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> graph = new HashMap<>();
		
		graph.put("A", new ArrayList(Arrays.asList("B", "C")));
		graph.put("B", new ArrayList(Arrays.asList("A", "D")));
		graph.put("C", new ArrayList(Arrays.asList("A", "G", "H", "I")));
		graph.put("D", new ArrayList(Arrays.asList("B", "E", "F")));
		graph.put("E", new ArrayList(Arrays.asList("D")));
		graph.put("F", new ArrayList(Arrays.asList("D")));
		graph.put("G", new ArrayList(Arrays.asList("C")));
		graph.put("H", new ArrayList(Arrays.asList("C")));
		graph.put("I", new ArrayList(Arrays.asList("C", "J")));
		graph.put("J", new ArrayList(Arrays.asList("I")));

		BreadthFirstSearch bfs = new BreadthFirstSearch();
		System.out.println(bfs.search(graph, "A"));
	}

}
