/*
 * Name: Leoza Kabir
 * Student ID: V00840048
 * Date: 12/03/2016
 * File Name: BinarySearchTree.java
 * Details: CSC 115 Assignment <4>
 * Programmer Note: The BinarySearchTree class extends BinaryTree by specifically storing elements with an internal order imposed on them.  
 *					Ordeing is impoosed by only allowing elements that implement  Comparable, in other words, the element class 
 *					implements a compareTo method that determines which of two elements come earlier in an ordered list. This class
 *					contains methods that insert a new item into the tree, deletes an item from the tree, retrieves an item from the tree
 *					and places items in the tree in a sorted manner. 
 */

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	// the root is inherited from BinaryTree.

	/**
	 * Create an empty BinarySearchTree.
	 */
	public BinarySearchTree() {
		super();
	}

	/**
	 *Inserts a new item into the tree by maintaining its order. 
	 *If the item is already in the tree, nothing happens
	 *@param item the item to be inserted
	 */
 	public void insert(E item){
		root=insertN(root, item);
		
	}
	/**
	 *private method to insert item into tree
	 *@param newItem the item to be inserted
	 *@param treeNode the node
	 *@return the node
	 */
	private TreeNode<E>insertN(TreeNode<E> treenode, E newItem){
		if(treenode==null){
			//create new node. Position of insertion is found
			treenode=new TreeNode<E>(newItem);
		}else if(newItem.compareTo(treenode.item) < 0){
			//search the left subtree
			treenode.left=insertN(treenode.left,newItem);
		}else{
			//search the right subtree
			treenode.right=insertN(treenode.right,newItem);
		} 	
		return treenode;
	}
	/**
	 *Looks for the item in the tree equivalent to key
	 @param key the item to look for
	 @return the item if it is in the tree, null if it is a root
	 */
	public E retrieve(E key){
		TreeNode<E> newNode=retrieveNode(root,key);
		if(newNode==null){
			return null;
		}
		
		return newNode.item;
		
	}
	/**
	 *private method to look for the item in tree
	 *@param search the item to look for
	 *@param treeNode the node
	 *@return the node containing the item
	 */
	private TreeNode<E> retrieveNode(TreeNode<E> treeNode, E searchKey){
		if(treeNode==null){
			return null;
		}else if(searchKey.compareTo(treeNode.item)==0){
			//item is in the root of a subtree
			return treeNode;
		}else if(searchKey.compareTo(treeNode.item)<0){
			//search left subtree
			return retrieveNode(treeNode.left,searchKey);
		}else{
			//search right subtree
			return retrieveNode(treeNode.right,searchKey);
		}
	}
	/**
	 *Finds the item equivalent to key and removes it.
	 *@param key the item to be removed
	 */
	public void delete(E key){
		root=deleteNode(root,key);
		
	}
	/**
	 *private method to remove item in tree
	 *@param key the item to remove.
	 *@param treeNode the node.
	 *@return the new root.
	 */
	private TreeNode<E>deleteNode(TreeNode<E> treeNode, E key){
		if(treeNode.left==null && treeNode.right==null){ //treeNode is a leaf
			return null; 
		}else if(key.compareTo(treeNode.item)<0){
			//search the left subtree
			treeNode.left=deleteNode(treeNode.left,key);
		}else if(key.compareTo(treeNode.item)>0){
			//search the right subtree
			treeNode.right=deleteNode(treeNode.right,key);
		}else{ 
			if(treeNode.right==null){
				treeNode=treeNode.left;
			}else{
				treeNode.item=min(treeNode.right).item;
				treeNode.right=deleteNode(treeNode.right,key);
			}
		}
		return treeNode;
	}
	/**
	 *private method to find the smallest item in tree
	 *@param treeNode the node
	 *@return the node containing the smallest item
	 */
	private TreeNode<E>min(TreeNode<E>treeNode){
		if(treeNode==null)
			return null;
		else if(treeNode.left==null)
			return treeNode;
		return min(treeNode.left);
	}
	
	/*private TreeNode<E> search(TreeNode<E>treeNode, E searchKey){
		if(treeNode==null){
			return null;
		}else if(root.equals(searchKey)){
			return root;
		}else if(searchKey.compareTo(root.item)>0){
			return search(treeNode.left,searchKey);
		}else{
			return search(treeNode.right,searchKey);
		}
	}*/


	/**
	 * Places all the items in the tree into a sorted list.
	 * @return the sorted list.
	 */
	public ArrayList<E> inOrder() {
		ArrayList<E> list = new ArrayList<E>();
		collectInOrder(list,root);
		return list;
	}

	/**
	 *Traverses the tree in order and places items into list
	 *@param list the list items are placed in
	 *@param node the node
	 */
	private void collectInOrder(ArrayList<E> list, TreeNode<E> node){
		if(node==null){
			return;
		}
 		collectInOrder(list,node.left);
		list.add(node.item);
		collectInOrder(list,node.right);
	}

	/**
	 * Internal test harness.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		/*BinarySearchTree<Integer> newTree=new BinarySearchTree<Integer>();
		newTree.insert(10);
		newTree.insert(5);
		newTree.insert(20);
		newTree.insert(15);
		newTree.insert(3);
		newTree.insert(7);
		newTree.insert(35);
		newTree.delete(10);
		newTree.delete(7);
		DrawableBTree<Integer> dbt = new DrawableBTree<Integer>(newTree);
		dbt.showFrame();
		System.out.println(newTree.retrieve(7));*/

		BinarySearchTree<PatientLocation> tree = new BinarySearchTree<PatientLocation>();
		PatientLocation p1 = new PatientLocation("Duck", "Donald", 338);
		PatientLocation p2 = new PatientLocation("Mouse", "Minnie",116);
		PatientLocation p3 = new PatientLocation("Dog", "Goofie",422);
		PatientLocation p4 = new PatientLocation("Newman","Alfred",607);
		tree.insert(p1);
		tree.insert(p4);
		tree.insert(p3);
		tree.insert(p2);
		//tree.delete(p4);
		ArrayList<PatientLocation> list  = tree.inOrder();
		System.out.println(list);
		//draw the tree in its current state:
		DrawableBTree<PatientLocation> dbt = new DrawableBTree<PatientLocation>(tree);
		dbt.showFrame();
	}

}
