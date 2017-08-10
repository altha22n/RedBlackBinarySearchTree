/**
 * Created by peter on 3/10/17.
 */
public class RedBlackBSTNode<T extends Comparable<T>> extends
		BinarySearchTreeNode<T> {
	boolean isBlack;
	boolean isNull;

	/**
	 * first constructor that creates null
	 */
	public RedBlackBSTNode() {
		// calls super
		super();
		isNull = true;
		isBlack = true;

	}

	/**
	 * second constructor
	 * 
	 * @param d
	 */
	public RedBlackBSTNode(T d) {
		// call super
		super(d);
		// set null and black as false
		isNull = false;
		isBlack = false;
		// create left,right and parent nodes
		RedBlackBSTNode leftNode = new RedBlackBSTNode();
		RedBlackBSTNode rightNode = new RedBlackBSTNode();
		RedBlackBSTNode parentNode = new RedBlackBSTNode();

		// this is left and right
		left = leftNode;
		right = rightNode;
		parent = parentNode;

	}

	/**
	 * empty insert method
	 * 
	 * @param n
	 */
	public void insert(RedBlackBSTNode<T> n) {

	}

	/**
	 * validate leafnodeblack makes sure that all the leaf nodes as black
	 * 
	 * @return
	 */
	public boolean validateLeafNodesBlack() {
		// if this is null
		if (this.isNull() == true) {
			// return true
			return true;
		}
		// if the left child is null
		if (this.getLeft() == null) {
			// return false
			return false;
		}
		// if the right child is null return false
		if (this.getRight() == null) {
			// if(this.isBlack()==true){
			return false;
		}
		// call it recursively on both children
		return getLeft().validateLeafNodesBlack()
				&& getRight().validateLeafNodesBlack();
	}

	/**
	 * validateRedHasBlackChildren makes sure all the red nodes have black
	 * children
	 * 
	 * @return
	 */
	public boolean validateRedHasBlackChildren() {
		// if this is null
		if (this.isNull()) {
			// return true
			return true;
		}
		// if this node is red and left child is red
		// or this node is red and right child is red
		if ((this.isRed() && this.getLeft().isRed())
				|| (this.isRed() && this.getRight().isRed())) {

			// return false
			return false;

		} else {
			// else return call it recursively on both children
			return this.getLeft().validateRedHasBlackChildren()
					&& this.getRight().validateRedHasBlackChildren();
		}

	}

	/**
	 * validateBlackHeight makes sure the black height is correct
	 * 
	 * @return
	 */
	public int validateBlackHeight() {
		// if this is null
		if (this.isNull()) {
			// return 0
			return 0;
		}
		// create two ints
		// leftHeight and rightHeight and call validateBlackHeight recursively
		// on them
		int leftHeight = ((RedBlackBSTNode) this.left).validateBlackHeight();
		int rightHeight = ((RedBlackBSTNode) this.right).validateBlackHeight();
		// if this node's left child is black
		if (((RedBlackBSTNode) this.left).isBlack()) {
			// increase leftHeight
			leftHeight++;
		}
		// if leftHeight is less than 0
		if (leftHeight < 0) {
			// return -1
			return -1;
		}
		// if rightHeight is less than 0
		if (rightHeight < 0) {
			// return -1
			return -1;
		}
		// if this node's right child is black
		if (((RedBlackBSTNode) this.right).isBlack()) {
			// increase the height
			rightHeight++;
		}
		// if both height are different
		if (rightHeight == leftHeight) {
			// increase either one of them bc they're equal
			return rightHeight;
			// else return -1
		} else {
			return -1;
		}
	}

	public boolean isBlack() {
		return isBlack;
	}

	public void setBlack() {
		isBlack = true;
	}

	public boolean isRed() {
		return !isBlack;
	}

	public void setRed() {
		isBlack = false;
	}

	public boolean isNull() {
		return isBlack() && isNull;
	}

	public boolean isNotNull() {
		return !isNull;
	}

	public RedBlackBSTNode getLeft() {
		return (RedBlackBSTNode) super.getLeft();
	}

	public RedBlackBSTNode getRight() {
		return (RedBlackBSTNode) super.getRight();
	}

	public RedBlackBSTNode getParent() {
		return (RedBlackBSTNode) super.getParent();
	}

	public RedBlackBSTNode getGrandParent() {
		return this.getParent().getParent();
	}

	public boolean isParentLeftChild() {
		return this.getParent() == this.getGrandParent().getLeft();
	}

	public RedBlackBSTNode getUncle() {
		if (isParentLeftChild()) {
			return this.getGrandParent().getRight();
		} else {
			return this.getGrandParent().getLeft();
		}
	}

	public boolean isLeftChild() {
		return (this == this.getParent().getLeft());
	}

	public boolean isRightChild() {
		return (this == this.getParent().getRight());
	}

	public String toString() {
		if (isNull()) {
			return "Node: isNull";
		} else {
			if (isRed())
				return "Node: Red " + getData().toString();
			else
				return "Node: Black " + getData().toString();
		}
	}

	public int compareTo(RedBlackBSTNode<T> n) {
		return this.getData().compareTo(n.getData());
	}
}
