package algorithm.graph;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 시간 복잡도 : O(E log E)
public class Dijkstra {

	static class Edge implements Comparable<Edge>{
		public int distance;
		public String vertex;
		
		public Edge(int distance, String vertex) {
			this.distance = distance;
			this.vertex = vertex;
		}
		
		public String toString() {
			return "vertex : "+this.vertex + ", distance : "+this.distance;
		}

		@Override
		public int compareTo(Edge o) {
			return this.distance - o.distance;
		}
	}
	
	public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start){
		HashMap<String, Integer> distances = new HashMap<String, Integer>();
		ArrayList<Edge> nodeList;
		for(String key: graph.keySet()) {
			distances.put(key, Integer.MAX_VALUE);
		}
		
		distances.put(start, 0);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(distances.get(start), start));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int curdistance = cur.distance;
			String curNode = cur.vertex;
			
			if(distances.get(curNode) < curdistance) {
				continue;
			}
			
			nodeList = graph.get(curNode);
			for(int i = 0; i < nodeList.size(); i++) {
				Edge adjacentNode = nodeList.get(i);
				int weight = adjacentNode.distance;
				String adjacent = adjacentNode.vertex;
				int distance = curdistance + weight;
				if(distance < distances.get(adjacent)) {
					distances.put(adjacent, distance);
					pq.add(new Edge(distance, adjacent));
				}
			}
		}
		
		return distances;
	}
	
	public static void main(String[] args) {
		HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
		
		graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8,"B"), new Edge(1,"C"), new Edge(2,"D"))));
		graph.put("B", new ArrayList<Edge>());
		graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5,"B"), new Edge(2,"D"))));
		graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3,"E"), new Edge(5,"F"))));
		graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1,"F"))));
		graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5,"A"))));

		Dijkstra dijkstra = new Dijkstra();
		System.out.println(dijkstra.dijkstraFunc(graph, "A"));
	}

}
