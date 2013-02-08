package algs.model;

/**
 * Base structure for a BinaryTree ensures there is a typed left and right child.
 * 
 * @param <T>  Basic type of the nodes of the binary tree.
 * 
 * @author George Heineman
 * @version 1.0, 6/15/08
 * @since 1.0
 */
public interface IBinaryTreeNode<T> {
	
	/**
	 * Return the left son associated with this node.
	 */
	T getLeftSon();
	
	/**
	 * Return the right son associated with this node.
	 */
	T getRightSon ();
	
}
