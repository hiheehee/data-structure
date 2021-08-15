package algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

// 시간 복잡도 : O(E log V)
public class PrimImproved {

	static class Edge implements Comparable<Edge> {
		public int weigth;
		public String node;
		
		public Edge(String node, int weigth) {
			this.weigth = weigth;
			this.node = node;
		}
		
		public String toString() {
			return "("+this.node+ ", "+this.weigth+")";
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weigth - o.weigth;
		}
	}
	
	static class Path {
		public int weigth;
		public String node1;
		public String node2;
		
		public Path(String node1, String node2, int weigth) {
			this.weigth = weigth;
			this.node1 = node1;
			this.node2 = node2;
		}
		
		public String toString() {
			return "("+this.node1+", "+this.node2+", "+this.weigth+")";
		}
	}
	
	public ArrayList<Path> improvedPrimFunc(HashMap<String, HashMap<String, Integer>> graph, String startNode){
		ArrayList<Path> mst = new ArrayList<>();
		PriorityQueue<Edge> keys = new PriorityQueue<>();
		HashMap<String, String> mstPath = new HashMap<>();
		HashMap<String, Edge> keysObjects = new HashMap<>();
		HashMap<String, Integer> linkedEdges;
		Edge edgeObject, linkedEdge;
		Integer totalWeight = 0;
		
		for(String key: graph.keySet()) {
			if(key == startNode) {
				edgeObject = new Edge(key, 0);
				mstPath.put(key,key);
			}else {
				edgeObject = new Edge(key, Integer.MAX_VALUE);
				mstPath.put(key, null);
			}
			keys.add(edgeObject);
			keysObjects.put(key, edgeObject);
		}
		
		while(!keys.isEmpty()) {
			Edge poppedEdge = keys.poll();
			keysObjects.remove(poppedEdge.node);
			
			mst.add(new Path(mstPath.get(poppedEdge.node), poppedEdge.node, poppedEdge.weigth));
			totalWeight += poppedEdge.weigth;
			
			linkedEdges = graph.get(poppedEdge.node);
			for(String adjacent: linkedEdges.keySet()) {
				if(keysObjects.containsKey(adjacent)) {
					linkedEdge = keysObjects.get(adjacent);
					
					if(linkedEdges.get(adjacent) < linkedEdge.weigth) {
						linkedEdge.weigth = linkedEdges.get(adjacent);
						mstPath.put(adjacent, poppedEdge.node);
						keys.remove(linkedEdge);
						keys.add(linkedEdge);
					}
				}
			}
		}
		return mst;
	}
	
	public static void main(String[] args) {
		HashMap<String, HashMap<String, Integer>> mygraph = new HashMap<>();
		HashMap<String, Integer> edges = new HashMap<>();
		edges.put("B", 7);
		edges.put("D", 5);
		mygraph.put("A", edges);
		
		edges = new HashMap<>();
		edges.put("A", 7);
		edges.put("C", 8);
		edges.put("E", 7);
		edges.put("D", 9);
		mygraph.put("B", edges); 
		
		edges = new HashMap<>();
		edges.put("B", 8);
		edges.put("E", 5);
		mygraph.put("C", edges); 
		
		edges = new HashMap<>();
		edges.put("A", 5);
		edges.put("B", 9);
		edges.put("E", 7);
		edges.put("F", 6);
		mygraph.put("D", edges); 
		
		edges = new HashMap<>();
		edges.put("B", 7);
		edges.put("C", 5);
		edges.put("D", 7);
		edges.put("F", 8);
		edges.put("G", 9);
		mygraph.put("E", edges); 
		
		edges = new HashMap<>();
		edges.put("D", 6);
		edges.put("E", 8);
		edges.put("G", 11);
		mygraph.put("F", edges); 
		
		edges = new HashMap<>();
		edges.put("E", 9);
		edges.put("F", 11);
		mygraph.put("G", edges); 
		
		PrimImproved piObject = new PrimImproved();
		System.out.println(piObject.improvedPrimFunc(mygraph, "A"));
	}

}
