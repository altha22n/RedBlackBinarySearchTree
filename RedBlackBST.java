/**
 * Created by peter on 3/10/17.
 */
public class RedBlackBST<T extends Comparable<T>> extends BinarySearchTree<T> {
	RedBlackBSTNode<T> root;

	/**
	 * 1st constructor
	 */
	public RedBlackBST() {
		// root
		root = new RedBlackBSTNode();
	}

	/**
	 * 2nd constructor
	 * 
	 * @param n
	 */
	public RedBlackBST(RedBlackBSTNode n) {
		root = n;
	}

	/**
	 * left rotate
	 * 
	 * @param x
	 */
	public void left_rotate(RedBlackBSTNode x) {
		// create a new node
		RedBlackBSTNode y = new RedBlackBSTNode();
		// y is the right child of x
		y = x.getRight();
		// temp is the right of x
		RedBlackBSTNode temp = x.getRight();
		// set left of y as temp
		y.setLeft(temp);
		// if the left child of y is not null
		if (y.getLeft().getData() != null) {
			// z is the parent of the left child of y
			x = y.getLeft().getParent();
		}
		// set the parent of y as the parent of x
		y.setParent(x.getParent());
		// if the parent of x is null
		if (x.getParent().getData() == null) {
			// let the root be y
			root = y;
		}

		// else if x is the same as it's paren't left child
		// let y be the left child of x's parent
		else if (x == x.getParent().getLeft()) {

			y = x.getParent().getLeft();
		} else {
			// else let y be the right child of x's parent
			y = x.getParent().getRight();

		}
		// y is the parent of x
		y = x.getParent();
	}

	/**
	 * right rotate
	 * 
	 * @param x
	 */
	public void right_rotate(RedBlackBSTNode x) {
		// create a new node z
		RedBlackBSTNode z = new RedBlackBSTNode<>();
		// set z as the left child of x
		z = x.getLeft();
		// create a node y and set it as the right child of x
		RedBlackBSTNode y = x.getRight();
		// set y as the right child of z
		z.setRight(y);
		// of the right child of z is not null
		if (z.getRight().getData() != null) {
			// set x as the right child
			x = z.getRight().getParent();
		}
		// set the parent as x's parent too
		z.setParent(x.getParent());
		// if x's parent is null
		if (x.getParent().getData() == null) {
			// set root as z
			root = z;
		}
		// else if x is equal to the right child
		else if (x == x.getParent().getRight()) {
			// set z as the right child
			z = x.getParent().getRight();
		} else {
			// set z as the left child of x's parent
			z = x.getParent().getLeft();
		}
		// set z as x parent
		z = x.getParent();
	}

	/**
	 * insert with all the cases
	 */
	public void insert(T d) {
		// create three new nodes
		RedBlackBSTNode y = new RedBlackBSTNode();

		RedBlackBSTNode x = new RedBlackBSTNode();
		// create z and put the parameter as d
		RedBlackBSTNode z = new RedBlackBSTNode(d);
		// set x as the root
		x = root;

		// if the root is null, z should become the root
		if (root.isNull()) {
			// root should be the parent of z first
			z.setParent(root);
			// then root is set to z
			root = z;

		}
		// while the root (x) is not null
		while (!x.isNull()) {
			// set y as equal to x
			y = x;
			// if z is bigger than z
			if (z.getData().compareTo(x.getData()) < 0) {
				// x is its left child
				x = x.getLeft();
			} else {
				// else x is its right child
				x = x.getRight();
			}
		}
		// set the parent of z as y
		z.setParent(y);
		// if y is null
		if (y.isNull()) {
			// set the root as z
			root = z;

		}
		// else if z is bigger than y
		else if (z.getData().compareTo(y.getData()) < 0) {
			// y becomes the left child of y
			y.setLeft(z);

		}

		else {
			// else y is the right child of z
			y.setRight(z);

		}
		// create a new temp node that gets the right child of z
		RedBlackBSTNode temp = z.getRight();
		// set temp as the left child of z
		temp = z.getLeft();
		// set z as red
		z.setRed();
		// call fix up on z
		fixup(z);

	}

	/**
	 * 
	 * @param z
	 */
	public void fixup(RedBlackBSTNode z) {
		// create a new node as y
		RedBlackBSTNode y = new RedBlackBSTNode();
		// while z's parent is red
		while (z.getParent().isRed()) {
			// if z's parent is equal to the left child of it's grandparent's
			// left child)
			if (z.getParent() == z.getGrandParent().getLeft()) {
				// set y as z's grandparents right child
				y = z.getGrandParent().getRight();
				// if y is red
				if (y.isRed()) {
					// set the parent of z as black
					z.getParent().setBlack();
					// set y as black
					y.setBlack();
					// set the grandparent as red
					z.getGrandParent().setRed();
					// set z as its grandparent
					z = z.getParent().getParent();
				} else {
					// else if z is equal to the right child of its parent
					if (z == z.getParent().getRight()) {
						// let z get its parent
						z = z.getParent();
						// call left rotate on z
						left_rotate(z);
					}
					// get the parent of z and set it as black
					z.getParent().setBlack();
					// set the grandparent as red
					z.getGrandParent().setRed();
					// call right rotate on z's grandparent
					right_rotate(z.getGrandParent());
				}
				// else
			} else {
				// set y as the grandparent left - which is the uncle
				y = z.getGrandParent().getLeft();
				// if y is red
				if (y.isRed()) {
					// set z's parent as black
					z.getParent().setBlack();
					// set y as black
					y.setBlack();
					// set z's grandparents as red
					z.getGrandParent().setRed();
					// keep getting the grandparents
					z = z.getGrandParent();
				} else {
					// if z is equal to the pareent's left child ( the sibling)
					if (z == z.getParent().getLeft()) {
						// get the parent
						z = z.getParent();
						// and call right rotate on z
						right_rotate(z);
					}
					// set the parent of z as black
					z.getParent().setBlack();
					// set the grandparent as red
					z.getGrandParent().setRed();
					// call left rotate on z's grandparents
					left_rotate(z.getGrandParent());
				}
			}
		}
		// set the root as black
		root.setBlack();
	}

	public RedBlackBSTNode getRoot() {

		return (RedBlackBSTNode) this.root;
	}

	public boolean validateLeafNodesBlack() {

		return getRoot().validateLeafNodesBlack();
	}

	public boolean validateRedHasBlackChildren() {

		return getRoot().validateRedHasBlackChildren();
	}

	public boolean validateBlackHeight() {

		return (getRoot().validateBlackHeight() >= 0);
	}

	public boolean validateRootNodeBlack() {

		return getRoot().isBlack();
	}

	public boolean validate() {
		return (this.validateRedHasBlackChildren()
				&& this.validateBlackHeight() && this.validateLeafNodesBlack() && this
					.validateRootNodeBlack());
	}
}
