import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by peter on 3/10/17.
 */
public class RedBlackBSTTest {
	protected RedBlackBST<Integer> emptyRBTree;
	protected RedBlackBST<Integer> oneRBTree;
	protected RedBlackBST<Integer> threeRBTree;

	@Before
	public void setup() {
		emptyRBTree = new RedBlackBST();
		oneRBTree = new RedBlackBST(new RedBlackBSTNode(new Integer(25)));
		oneRBTree.getRoot().setBlack();

		RedBlackBSTNode<String> root = new RedBlackBSTNode(new Integer(20));
		root.setParent(new RedBlackBSTNode());
		root.setRight(new RedBlackBSTNode(new Integer(42)));
		root.getRight().setParent(root);
		root.setLeft(new RedBlackBSTNode(new Integer(15)));
		root.getLeft().setParent(root);
		root.setBlack();
		threeRBTree = new RedBlackBST(root);
	}

	@Test
	public void constructorTest() {
		assertNotNull(emptyRBTree);

		assertNotNull(oneRBTree);
		assertEquals(new Integer(25), oneRBTree.getRoot().getData());

		assertNotNull(threeRBTree);
		assertEquals(new Integer(20), threeRBTree.getRoot().getData());
		assertEquals(new Integer(15), threeRBTree.getRoot().getLeft().getData());
		assertEquals(new Integer(42), threeRBTree.getRoot().getRight()
				.getData());
	}

	@Test
	public void validateLeafNodesBlack() {
		assertTrue(emptyRBTree.validateRootNodeBlack());
		assertTrue(oneRBTree.validateLeafNodesBlack());
		assertTrue(threeRBTree.validateLeafNodesBlack());
		threeRBTree.getRoot().getLeft().getLeft().setRed();
		assertFalse(threeRBTree.validateLeafNodesBlack());
	}

	@Test
	public void validateRedHasBlackChildren() {
		assertTrue(emptyRBTree.validateRedHasBlackChildren());
		assertTrue(oneRBTree.validateRedHasBlackChildren());
		assertTrue(threeRBTree.validateRedHasBlackChildren());
		threeRBTree.getRoot().setRed();
		assertFalse(threeRBTree.validateRedHasBlackChildren());
	}

	@Test
	public void validateBlackHeight() {
		assertEquals(true, emptyRBTree.validateBlackHeight());
		assertEquals(true, oneRBTree.validateBlackHeight());
		assertEquals(true, threeRBTree.validateBlackHeight());
		threeRBTree.getRoot().getLeft().setBlack();
		threeRBTree.getRoot().setRed();
		assertEquals(false, threeRBTree.validateBlackHeight());
	}

	@Test
	public void validateRootNodeBlack() {
		assertTrue(emptyRBTree.validateRootNodeBlack());
		assertTrue(oneRBTree.validateRootNodeBlack());
		assertTrue(threeRBTree.validateRootNodeBlack());
		threeRBTree.getRoot().setRed();
		assertFalse(threeRBTree.validateRootNodeBlack());
	}

	@Test
	public void right_rotateTest() {
		threeRBTree.right_rotate(threeRBTree.getRoot());
		assertEquals(new Integer(15), threeRBTree.getRoot().getData());
	}

	@Test
	public void left_rotateTest() {
		threeRBTree.left_rotate(threeRBTree.getRoot());
		assertEquals(new Integer(42), threeRBTree.getRoot().getData());
	}

	@Test
	public void insertTestBase() {
		emptyRBTree.insert(new Integer(20));
		emptyRBTree.insert(new Integer(15));
		emptyRBTree.insert(new Integer(45));
		assertTrue(emptyRBTree.validate());
		assertTrue(emptyRBTree.getRoot().getParent().isNull());
	}

	@Test
	public void insertTestCaseOne() {

		emptyRBTree.insert(new Integer(3));
		emptyRBTree.insert(new Integer(1));
		emptyRBTree.insert(new Integer(4));
		assertTrue(emptyRBTree.validate());

	}

	@Test
	public void insertTestCaseTwo() {

		emptyRBTree.insert(new Integer(25));
		emptyRBTree.insert(new Integer(23));
		emptyRBTree.insert(new Integer(22));
		emptyRBTree.insert(new Integer(21));

		assertTrue(emptyRBTree.validate());

	}

	@Test
	public void insertTestCaseThree() {
		emptyRBTree.insert(new Integer(30));
		emptyRBTree.insert(new Integer(25));
		emptyRBTree.insert(new Integer(19));

		assertTrue(emptyRBTree.validate());

	}

	@Test
	public void insertTestCaseFour() {
		emptyRBTree.insert(new Integer(31));
		emptyRBTree.insert(new Integer(21));
		emptyRBTree.insert(new Integer(35));
		emptyRBTree.insert(new Integer(32));
		
		assertTrue(emptyRBTree.validate());
		
	}

	@Test
	public void insertTestCaseFive() {
		
		emptyRBTree.insert(new Integer(12));
		emptyRBTree.insert(new Integer(10));
		emptyRBTree.insert(new Integer(20));
		
		assertTrue(emptyRBTree.validate());
		
	}

	@Test
	public void insertTestCaseSix() {
		
		emptyRBTree.insert(new Integer(30));
		emptyRBTree.insert(new Integer(25));
		emptyRBTree.insert(new Integer(32));
		emptyRBTree.insert(new Integer(35));
		
		assertTrue(emptyRBTree.validateBlackHeight());
		assertTrue(emptyRBTree.validate());
		
	}

}
