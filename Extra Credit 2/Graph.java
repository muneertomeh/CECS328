import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
	private HashMap<String, Vertex > vertexMap = new HashMap<String, Vertex>();
	
	public Graph() {
	
	}
	
	//Returns the number of vertices in a graph
	public int orderOfVertices() {
		return vertexMap.size();
	}
	
	
	
	public HashMap<String, Vertex> getVertexMap(){
		return vertexMap;
	}
	
	public ArrayList<Vertex> getVertices() {
		ArrayList<Vertex> toBeReturned = new ArrayList<Vertex>();
		for(Map.Entry<String, Vertex> mp : vertexMap.entrySet()) {
			toBeReturned.add(mp.getValue());
		}
		
		return toBeReturned;
	}
	
	
	//This method adds an edge between a source vertex and destination vertex into the graph
	public void addEdgeToGraph(String beginName, String endName, int cost) {
		int i =0;
		while(i<2) {
			Vertex dest = new Vertex(endName);
			//if the vertex already exists in the graph, then take the vertex out to add an adjacent edge to that vertex, and reinsert into the map once again
			if(vertexMap.containsKey(beginName)) {
				Vertex v = vertexMap.get(beginName);
				v.addConnection(new Edge(dest, cost));
				System.out.println(beginName + " " + v);
				vertexMap.put(beginName, v);
			}
			//else, the source node doesn't exist, so add it to the graph alongside with its adjacent edge
			else {
				Vertex source = new Vertex(beginName);
				source.addConnection(new Edge(dest, cost));
				vertexMap.put(beginName, source);
			}
			i++;
			//swap vertex names to readd the same edge again but on top of the last one
			String temp = beginName;
			beginName = endName;
			endName = temp;
		}
		
	}
	
	//prints the entire graph with its vertices and their adjacency edges
	public void printGraph() {
		for(Map.Entry<String, Vertex> mp1 : vertexMap.entrySet()) {
			ArrayList<Edge> temp = mp1.getValue().getAdjacencyList();
			for(Edge e:temp) {
				System.out.println(mp1.getValue().getVertexName() + " " + e.toString());
			}
		}
	}
	
	public Vertex getVertex(String v) {
		for(Map.Entry<String, Vertex> mp : vertexMap.entrySet()) {
			if(mp.getValue().getVertexName().equals(v)) {
				return mp.getValue();
			}
		}
		System.out.println("CRAP HASNT ");
		return null;
	}
	
}
