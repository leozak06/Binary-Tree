import java.lang.*;
/*
 * The shell of the class, to be completed as part of CSC115 Assignment 4 : Patient Location.
 */
 
public class BinaryTree<E> {

	/* The root is inherited by any subclass
	 * so it must be protected instead of private.
	 */
	protected TreeNode<E> root;

	/**
	 * Create an empty BinaryTree.
	 */
	public BinaryTree() {
	}

	/**
	 * Create a BinaryTree with a single item.
	 * @param item The only item in the tree.
	 */
	public BinaryTree(E item) {
		root = new TreeNode<E>(item);
	}

	/**
	 * Used only by subclasses and classes in the same package (directory).
	 * @return The root node of the tree.
	 */
	protected TreeNode<E> getRoot() {
		return root;
	}
	private int heightAt(TreeNode item){
		if(isEmpty()){
			return 0;
		}else{
			return 1+Math.max(heightAt(item.left),heightAt(item.right));
		}
	}
	public int height(){
		if(isEmpty()){
			return 0;
		}else{
			return 1+Math.max(heightAt(root.left), heightAt(root.right));
		}
		
	}
	public boolean isEmpty(){
		return root==null;
	}
	public void makeEmpty(){
		root=null;
		
	}

}

	
