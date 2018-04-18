
public class Node {
	private int value;
	private Node left;
	private Node right;
	private int level;
	
	public Node(int i, int l) {
		value = i;
		this.left = null;
		this.right = null;
		level = l;

		
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public void setLeft(Node n) {
		this.left = n;
	}
	
	
	public Node getRight() {
		return this.right;
	}
	
	public void setRight(Node n) {
		this.right = n;
	}
	
	public int getValue() {
		return value;
	}
	
	public String toString() {
		return this.value + " ";
	}
}
