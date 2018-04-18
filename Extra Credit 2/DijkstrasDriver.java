import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import javax.print.attribute.standard.PrinterLocation;

public class DijkstrasDriver {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdgeToGraph("A", "B", 5);
		g.addEdgeToGraph("B", "C", 2);
		g.addEdgeToGraph("A", "D", 9);
		g.addEdgeToGraph("C", "D", 3);
		g.addEdgeToGraph("A", "E", 2);
		g.addEdgeToGraph("E", "F", 3);
		g.addEdgeToGraph("D", "F", 2);
		g.printGraph();
		dijkstras(g);
		
		
		Graph g1 = new Graph();
		g1.addEdgeToGraph("A", "D", 1);
		g1.addEdgeToGraph("A", "B", 3);
		g1.addEdgeToGraph("B", "C", 1);
		g1.addEdgeToGraph("B", "D", 3);
		g1.addEdgeToGraph("D", "E", 6);
		g1.addEdgeToGraph("D", "C", 1);
		g1.addEdgeToGraph("E", "F", 2);
		g1.addEdgeToGraph("C", "F", 4);
		g1.addEdgeToGraph("C", "E", 1);
		prims(g1);
		
		
		

	}
	
	//Dijkstra's algorithm finds shortest path between nodes in a graph
	public static void dijkstras(Graph g) {
		//functions like a min priority queue
		Map<String, Integer>heapMap = new HashMap<String, Integer>();
		//map that ensures parent-child relations
		Map<String, String> pathMap = new HashMap<String, String>();
		//map that tracks the total distance from the source to intended vertex
		Map<String, Integer> distanceMap = new HashMap<String, Integer>();
		
		//attains all the vertices of the graph
		ArrayList<Vertex> everyVertex = g.getVertices();
		
		//initialize every vertex with a size of infinity
		for(int i=0;i<everyVertex.size();i++) {
			heapMap.put(everyVertex.get(i).getVertexName(), Integer.MAX_VALUE);
		}
		
		
		boolean firstTime = true;
		while(!heapMap.isEmpty()) {
			String current = heapMap.entrySet().iterator().next().getKey();
			int minimum= heapMap.entrySet().iterator().next().getValue();
			
			//looking for the vertex with the minimum setting
			for(Map.Entry<String, Integer> mp : heapMap.entrySet()) {
				if(firstTime) {
					current = mp.getKey();
					minimum = 0;
					firstTime = false;
				}
				if(mp.getValue()<minimum) {
					minimum = mp.getValue();
					current = mp.getKey();
				}
			}
			//remove the minimum vertex from the heapMap
			heapMap.remove(current);
			
			distanceMap.put(current, minimum);
			
			ArrayList<Edge> neighbors = g.getVertex(current).getAdjacencyList();
			
			for(Edge u : neighbors) {
				//if the adjacent node is not in the mapHeap, then scout another neighbor because its been fully crossed off / explored
				if(!heapMap.containsKey(u.getDestination().getVertexName())) {
					continue;
				}
				//if the (weight of u)+total distance to get to current < distance to get to vertex u
				else if(u.getWeight()+distanceMap.get(current) < heapMap.get(u.getDestination().getVertexName()) ) {
					heapMap.put(u.getDestination().getVertexName(), u.getWeight() + distanceMap.get(current) );
					pathMap.put(u.getDestination().getVertexName(), current);
				}
			}
			
		}
		System.out.println(pathMap);
		System.out.println(distanceMap);
	}
	
	//Prim's algorithm for finding minimum spanning tree of a graph
	public static void prims(Graph g) {
	
		StringBuilder result = new StringBuilder();
		boolean firstTime = true;
		Map<String, Integer>heapMap = new HashMap<String, Integer>();
		Map<String, String> mstBranches = new HashMap<String, String>();
		
		ArrayList<Vertex> everyVertex = g.getVertices();
		//initialize every vertex with a size of infinity
		for(int i=0;i<everyVertex.size();i++) {
			heapMap.put(everyVertex.get(i).getVertexName(), Integer.MAX_VALUE);
		}
		
		String current = heapMap.entrySet().iterator().next().getKey();
		int minimum= heapMap.entrySet().iterator().next().getValue();
		
		while(!heapMap.isEmpty()) {
			//looking for the vertex with the minimum setting
			for(Map.Entry<String, Integer> mp : heapMap.entrySet()) {
				if(firstTime) {
					current = mp.getKey();
					minimum = 0;
					firstTime = false;
				}
				if(mp.getValue()<minimum) {
					minimum = mp.getValue();
					current = mp.getKey();
				}
			}
			
			if(mstBranches.containsKey(current)) {
				result.append(mstBranches.get(current));
			}
			
			ArrayList<Edge> neighbors = g.getVertex(current).getAdjacencyList();
			for(Edge u : neighbors) {
				if(!heapMap.containsKey(u.getDestination().getVertexName())) {
					continue;
				}
				else {
					if(u.getWeight()<heapMap.get(u.getDestination().getVertexName())) {
						heapMap.put(u.getDestination().getVertexName(), u.getWeight());
						mstBranches.put(u.getDestination().getVertexName(), current);
					}
				}
			}
		}
		
		
	}
	
	
}
