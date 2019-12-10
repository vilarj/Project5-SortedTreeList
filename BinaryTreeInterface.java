package binaryTree;

public interface BinaryTreeInterface <T> extends TreeInterface<T>, TreeIteratorInterface<T> {
	 /** Sets this binary tree to a one-node binary tree
	  * @param rootData the object in the data of the tree's root
	  */
	  public void setTree (T rootData);

	 /** Set this binary tree to a new binary tree with the given root
	   * and subtreees.
	   * @param rootData the object in the data of the tree's root
	   * @param leftTree the left subtree of the new tree
	   * @param rightTree the right subtree of the new tree
	   */
	  public void setTree (T rootData, BinaryTreeInterface<T> leftTree,
	                                  BinaryTreeInterface<T> rightTree);
}
