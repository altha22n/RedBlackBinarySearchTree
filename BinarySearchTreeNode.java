/**
 * This class contains methods that can be implemented on a BinarySearchTreeNode.
 * @author Nada Al-Thawr
 *
 * @param <T> placeholder for type of data given
 */
public class BinarySearchTreeNode<T extends Comparable<T>> {
	//variables for data, left, right and parent
	protected T data;
	protected BinarySearchTreeNode<T> left;
	protected BinarySearchTreeNode<T> right;
	protected BinarySearchTreeNode<T> parent;

	/**
	 * Empty constructor
	 */
	public BinarySearchTreeNode() {
	}

	/**
	 * Constructor that points variable data to parameter data
	 * @param data for information that is given
	 */
	public BinarySearchTreeNode(T data) {
		this.data = data;
	}

	/**
	 * Get the data stored at this node.
	 * @return Object data.
	 */
	public T getData(){
		return data;
	}

	/**
	 * Set the data stored at this node.
	 * @param data for information that is given
	 */
	public void setData(T data){
		//points variable data to parameter data
		this.data = data;
	}

	/**
	 * Get the left child.
	 * @return BinarySearchTreeNode that is left child, or null if no child.
	 */
	public BinarySearchTreeNode<T> getLeft(){
		//returns leftChild
		return left;
	}

	/**
	 * Get the right child.
	 * @return BinarySearchTreeNode that is right child, or null if no child.
	 */
	public BinarySearchTreeNode<T> getRight(){
		//returns right child
		return right;
	}

	/**
	 * Gets the parent
	 * @return BinarySearchTreeNode that is parent
	 */
	public BinarySearchTreeNode<T> getParent() {
		return parent;
	}

	/**
	 * Sets parent.
	 * @param node that parent should point to
	 */
	public void setParent(BinarySearchTreeNode<T> parent) {
		this.parent = parent;
	}

	/**
	 * Set the left child.
	 * @param left for information that is given
	 */
	public void setLeft( BinarySearchTreeNode<T> left ){
		//points variable leftChild to left
		this.left = left;
	}

	/**
	 * Set the right child.
	 * @param right for information that is given
	 */
	public void setRight( BinarySearchTreeNode<T> right ){
		//points variable right child to right
		this.right = right;
	}

	/**
	 * Inserts data into the BST.
	 * @param data for the data given
	 * @return returns true if insert worked and false otherwise
	 */
	public boolean insert(T data) {
		//if data passed in is equal to data at this node
		if (data == this.data) {
			//then don't insert
			return false;
		}
		//otherwise, if data is less than data at this node
		else if(data.compareTo(this.data)<0) {
			//then if there is no left child
			if (this.getLeft() == null) {
				//create a new left child node
				left = new BinarySearchTreeNode(data);
				//point left of this to left
				this.setLeft(left);
				//point parent of left to this
				left.setParent(this);
				return true;
			}
			//otherwise if there is a left child
			//then recursively calls insert
			return left.insert(data);
		}
		//if data is more than data at this node
		else if (data.compareTo(this.data)>0) {
			//then if there is no right child
			if (this.getRight() == null) {
				//create a new right child node
				right = new BinarySearchTreeNode(data);
				//point right of this to right
				this.setRight(right);
				//point parent of this to right
				right.setParent(this);
				return true;
			}
			//otherwise if there is a right child
			//then recursively call insert
			return right.insert(data);
		}
		return false;
	}

	/**
	 * Searches for a node in the list
	 * @param data the information to be searched for
	 * @return returns a BSTNode
	 */
	public BinarySearchTreeNode search(T data) {
		//if data is equal to data at this node
		if (data.compareTo(this.data)==0) {
			//then return this node
			return this;
		}
		//otherwise if data is less than data at this node
		else if (data.compareTo(this.data)<=0) {
			//and there is no more left child
			if (this.getLeft()==null) {
				//then return null
				return null;

			}
			//otherwise if there are still left children
			//then recursively call search
			return this.getLeft().search(data);
		}
		//otherwise if data is more than data at this node
		else {
			//and if there are no more right children
			if (this.getRight()==null) {
				//then return null
				return null;
			}
			//otherwise if there are still right children
			else{ 
				//then recursively calls search
				return this.getRight().search(data);
			}
		}
	}
}
