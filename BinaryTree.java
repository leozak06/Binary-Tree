/*
 * The shell of the class, to be completed as part of CSC115 Assignment 4 : Patient Location.
 */


/*
 * NOTE TO STUDENT:
 * Complete this class as per the BinaryTree.html specification document.
 * Fill in any of the parts that have the comment:
 *	/******* COMPLETE *******/
 * Do not change method headers or code that has been supplied.
 * Write as many methods as you need to make the code simple and easy to understand.
 * All methods must be properly commented.
 * Delete all messages to you, including this one, before submtting.
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

 	/******* COMPLETE *******/

}

	
