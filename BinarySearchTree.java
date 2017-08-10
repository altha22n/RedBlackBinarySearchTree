/**
 * This class contains methods that can be implemented on a BinarySearchTree.
 * @author Nada al-Thawr
 *
 * @param <T>placeholder for type of data given
 */
public class BinarySearchTree<T extends Comparable<T>> {
	//variable for root
	BinarySearchTreeNode<T> root;

	/**
	 * Empty constructor
	 */
	public BinarySearchTree() {
	}
	
	/**
	 * Constructor that creates a BST with root as the data given 
	 * @param root
	 */
	public BinarySearchTree(BinarySearchTreeNode<T> root) {
		this.root = root;
	}
	
	/**
	 * Gets the root
	 * @return returns a BinarySearchTreeNode
	 */
	public BinarySearchTreeNode getRoot() {
		//returns root
		return this.root;
	}
	/***
	 * 
	 * In insert I changed it from boolean to void because 
	 * There were some errors in RBBST
	 * I also commented the last line which returned either true or false
	 */
	
	
	/**
	 * Inserts the data given into the tree
	 * @param data to be inserted
	 * @return returns true if insert worked, and false otherwise
	 */
	public void insert(T data) {
		//if root is null
		if (root == null) {
			//then create a root node that takes the data given
			root = new BinarySearchTreeNode<T> (data);
		}
		//otherwise calls insert from BSTNode class on root
		 root.insert(data);
	}
	
	/**
	 * Searches for data given
	 * @param data to be searched for
	 * @return returns a BinarySearchTreeNode
	 */
	public BinarySearchTreeNode search(T data) {
		//if the root points to null
		if (root == null) {
			//then return null
			return null;
		}
		//otherwise, calls search from BSTNode class on root
		return root.search(data);
	}
}
