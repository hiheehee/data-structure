package algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class Kruskal {
	
	HashMap<String, String> parent = new HashMap<>();
	HashMap<String, Integer> rank = new HashMap<>();

	static class Edge implements Comparable<Edge> {
		public int weigth;
		public String nodeV;
		public String nodeU;
		
		public Edge(int weigth, String nodeV, String nodeU ) {
			this.weigth = weigth;
			this.nodeU = nodeU;
			this.nodeV = nodeV;
		}
		
		public String toString() {
			return "("+this.weigth+ ", "+this.nodeV+", "+this.nodeU+")";
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weigth - o.weigth;
		}
	}
	
	public String find(String node) {
		// path compression 기법
		if(parent.get(node) != node) {
			parent.put(node, this.find(this.parent.get(node)));
		}
		return this.parent.get(node);
	}
	
	public void union(String nodeV, String nodeU) {
		String root1 = find(nodeV);
		String root2 = find(nodeU);
		
		// union-by-rank 기법
		if(rank.get(root1) > rank.get(root2)){
			parent.put(root2, root1);
		}else {
			parent.put(root1, root2);
			if(rank.get(root1) == rank.get(root2)) {
				rank.put(root2, rank.get(root2)+1);
			}
		}
	}
	
	public void makeSet(String node) {
		parent.put(node, node);
		rank.put(node, 0);
	}
	
	public ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges){
		ArrayList<Edge> mst = new ArrayList<>();
		Edge curEdge;
		
		// 1. 초기화
		// 시간 복잡도 : O(V)
		for(int i = 0; i < vertices.size(); i++) {
			makeSet(vertices.get(i));
		}
		
		// 2. 간선 weight 기반 sorting
		//  시간 복잡도 : O(E log E)
		Collections.sort(edges);
		
		// 3. 
		// O(E)
		for(int i = 0; i < edges.size(); i++) {
			curEdge = edges.get(i);
			if(this.find(curEdge.nodeV) != this.find(curEdge.nodeU)) {
				this.union(curEdge.nodeV, curEdge.nodeU);
				mst.add(curEdge);
			}
		}
		
		return mst;
	}
	
	public static void main(String[] args) {
		ArrayList<String> vertices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(7, "A", "B"));
		edges.add(new Edge(7, "B", "A"));
		edges.add(new Edge(5, "A", "D"));
		edges.add(new Edge(5, "D", "A"));
		edges.add(new Edge(9, "D", "B"));
		edges.add(new Edge(9, "B", "D"));
		edges.add(new Edge(8, "C", "B"));
		edges.add(new Edge(8, "B", "C"));
		edges.add(new Edge(5, "C", "E"));
		edges.add(new Edge(5, "E", "C"));
		edges.add(new Edge(7, "E", "D"));
		edges.add(new Edge(7, "D", "E"));
		edges.add(new Edge(6, "D", "F"));
		edges.add(new Edge(6, "F", "D"));
		edges.add(new Edge(8, "F", "E"));
		edges.add(new Edge(8, "E", "F"));
		edges.add(new Edge(11, "F", "G"));
		edges.add(new Edge(11, "G", "F"));
		edges.add(new Edge(9, "E", "G"));
		edges.add(new Edge(9, "G", "E"));
		edges.add(new Edge(7, "E", "B"));
		edges.add(new Edge(7, "B", "E"));
		
		Kruskal kObject = new Kruskal();
		System.out.println(kObject.kruskalFunc(vertices, edges));
	}

}