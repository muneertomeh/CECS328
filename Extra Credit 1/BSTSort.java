import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BSTSort {

	public static void main(String[] args) {
		BST bst = new BST();
		int input = 10;
		for (int i=0; i<input; i++) {
			int randomNumber = (int) Math.floor(Math.random()*2000)-1000;
			System.out.println(randomNumber);
			bst.insert(bst.getRoot(), randomNumber,0);
		}
		
		System.out.println();
		bst.inOrderTraversal(bst.getRoot());
		System.out.println();
		bst.printTree();
		

	}
	

}
