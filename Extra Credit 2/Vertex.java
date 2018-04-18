import java.util.ArrayList;

public class Vertex {
	private String vertexName;
	private ArrayList<Edge> adjacency;
	
	
	public Vertex(String vN) {
		this.vertexName = vN;
		adjacency = new ArrayList<Edge>();
	}
	
	//This method adds an edge to the adjacency list
	public void addConnection(Edge e) {
		adjacency.add(e);
	}
	
	//Returns the name of the vertex name
	public String getVertexName() {
		return this.vertexName;
	}
	
	//Returns the adjacency list for a certain vertex
	public ArrayList<Edge> getAdjacencyList(){
		return this.adjacency;
	}

	
}
