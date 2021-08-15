package algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

// 시간 복잡도 : O(E log E)
public class Prim {

	static class Edge implements Comparable<Edge> {
		public int weigth;
		public String node1;
		public String node2;
		
		public Edge(int weigth, String node1, String node2) {
			this.weigth = weigth;
			this.node1 = node1;
			this.node2 = node2;
		}
		
		public String toString() {
			return "("+this.weigth+ ", "+this.node1+", "+this.node2+")";
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weigth - o.weigth;
		}
	}
	
	public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {
		Edge curEdge, poppedEdge, adjacentEdgeNode;
		ArrayList<Edge> curEdgeList, candidateEdgeList, adjacentEdgeNodes;
		ArrayList<String> connectedNodes = new ArrayList<>();
		ArrayList<Edge> mst = new ArrayList<>();
		HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<String, ArrayList<Edge>>();
		
		for(int i = 0; i < edges.size(); i++) {
			curEdge = edges.get(i);
			if(!adjacentEdges.containsKey(curEdge.node1)) {
				adjacentEdges.put(curEdge.node1, new ArrayList<Edge>());
			}
			
			if(!adjacentEdges.containsKey(curEdge.node2)) {
				adjacentEdges.put(curEdge.node2, new ArrayList<Edge>());
			}
		}
		
		for(int i = 0; i < edges.size(); i++) {
			curEdge = edges.get(i);
			curEdgeList = adjacentEdges.get(curEdge.node1);
			curEdgeList.add(new Edge(curEdge.weigth, curEdge.node1, curEdge.node2));
			curEdgeList = adjacentEdges.get(curEdge.node2);
			curEdgeList.add(new Edge(curEdge.weigth, curEdge.node2, curEdge.node1));
		}
		
		connectedNodes.add(startNode);
		candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i = 0; i < candidateEdgeList.size(); i++) {
			pq.add(candidateEdgeList.get(i));
		}
		
		while(!pq.isEmpty()) {
			poppedEdge = pq.poll();
			if(!connectedNodes.contains(poppedEdge.node2)) {
				connectedNodes.add(poppedEdge.node2);
				mst.add(new Edge(poppedEdge.weigth, poppedEdge.node1, poppedEdge.node2));
				adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge>());
				for(int i = 0; i < adjacentEdgeNodes.size(); i++) {
					adjacentEdgeNode = adjacentEdgeNodes.get(i);
					if(!connectedNodes.contains(adjacentEdgeNode.node2)) {
						pq.add(adjacentEdgeNode);
					}
				}
			}
		}
		return mst;
	}
	
	public static void main(String[] args) {
		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(7, "A", "B"));
		edges.add(new Edge(5, "A", "D"));
		edges.add(new Edge(9, "D", "B"));
		edges.add(new Edge(8, "C", "B"));
		edges.add(new Edge(5, "C", "E"));
		edges.add(new Edge(7, "D", "E"));
		edges.add(new Edge(6, "D", "F"));
		edges.add(new Edge(8, "E", "F"));
		edges.add(new Edge(11, "F", "G"));
		edges.add(new Edge(9, "G", "E"));
		edges.add(new Edge(7, "E", "B"));
		
		Prim pObject = new Prim();
		System.out.println(pObject.primFunc("A", edges));

	}

}
