package algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;

public class Comparator_compare {
	static class Edge implements Comparable<Edge>{
		public int distance;
		public String vertex;
		
		public Edge(int distance, String vertex) {
			this.distance = distance;
			this.vertex = vertex;
		}

		@Override
		public int compareTo(Edge o) {
			return this.distance - o.distance;
		}
	}
	
	public static void main(String[] args) {
		Edge e1 = new Edge(10, "A");
		Edge e2 = new Edge(15, "A");
		Edge e3 = new Edge(12, "A");
		Edge edges[] = new Edge[] {e1, e2, e3};
		
		Arrays.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o2.distance - o1.distance;
			}
		});
		
		for(Edge cur : edges) {
			System.out.println(cur.distance+" "+cur.vertex);
		}
	}
}
