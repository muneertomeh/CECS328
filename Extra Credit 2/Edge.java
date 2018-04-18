
public class Edge {
	private Vertex destination;
	private int weight;
	
	public Edge(Vertex v, int w) {
		this.destination = v;
		this.weight = w;
	}
	
	public Vertex getDestination() {
		return this.destination;
	}
	
	
	public int getWeight() {
		return this.weight;
	}
	
	@Override
	public String toString() {
		return "-> {" + this.destination.getVertexName() + " , " + this.weight + "}";
		
	}
}
