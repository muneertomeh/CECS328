import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST {
	private Node root;
	
	public BST() {
		root = new Node(50, 0);
	}
	
	//getter for the BST's root
	public Node getRoot() {
		return root;
	}

	//Searches for a specific element within the binary search tree
	public boolean search(Node root, int key) {
		if(root==null) {
			return false;
		}
		else if(root.getValue() == key) {
			return true;
		}
		else {
			if(key<root.getValue()) {
				search(root.getLeft(), key);
			}
			else {
				search(root.getRight(), key);
			}
		}
		return true;
	}
	
	//Inserts a node into the binary search tree
	public void insert(Node current, int key, int currentLevel) {
		if(current==null) {
			root = new Node(key, currentLevel);
		}
		
		else if(key < current.getValue()){
			currentLevel++;
			if(current.getLeft()==null) {
				Node newNode = new Node(key, currentLevel);
				current.setLeft(newNode);
			}
			else {
				insert(current.getLeft(), key, currentLevel);
			}
			
		}
		else {
			currentLevel++;
			if(current.getRight() == null) {
				Node newNode = new Node(key, currentLevel);
				current.setRight(newNode);
			}
			else {
				insert(current.getRight(),key, currentLevel);
			}
		}
		
		
	}
	
	//This method prints the tree level by level
	public void printTree() {
		Node n = root;
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		
		StringBuilder str = new StringBuilder();
		while(!q.isEmpty()) {
			Node current = q.remove();
			str.append(current.toString());
			
			if(current.getLeft() !=null) {
				q.add(current.getLeft());
			}
			if(current.getRight()!= null) {
				q.add(current.getRight());
			}
			//if the queue is empty, that means printing of the tree is done
			if(!q.isEmpty()) {
				//if the current node's level does not match the top node's level in the queue, this means that there are no more nodes at the current level
				if(q.peek().getLevel()!= current.getLevel()) {
					System.out.println(str.toString());
					str = new StringBuilder();
				}
			}
			else {
				System.out.println(str.toString());
			}
			
		}
		
		
	}
	
	
	
	public void inOrderTraversal(Node root) {
		if(root!=null) {
			inOrderTraversal(root.getLeft());
			System.out.println(root.getValue() + " " + root.getLevel());
			inOrderTraversal(root.getRight());
		}
	}
	
}
