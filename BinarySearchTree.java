package project5Tree;

import java.util.Iterator;
import binaryTree.BinaryNode;
import binaryTree.BinaryTree;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T> {

	public BinarySearchTree() {
		super();
	}

	public BinarySearchTree(T rootEntry) {
		super(rootEntry);
	}

	@Override
	public boolean contains(T entry) {
		return (getEntry(entry) != null);
	}

	@Override
	public T getEntry(T entry) {
		return findEntry(getRoot(), entry);
	}

	private T findEntry(BinaryNode<T> rootNode, T entry) {
		T result = null;

		if (rootNode != null) {
			T rootEntry = rootNode.getData();

			if (entry.equals(rootEntry))
				result = rootEntry;
			else if (entry.compareTo(rootEntry) < 0)
				result = findEntry((BinaryNode<T>) rootNode.getLeftChild(), entry);
			else
				result = findEntry((BinaryNode<T>) rootNode.getRightChild(), entry);
		}
		return result;
	}

	@Override
	public T add(T newEntry) {
		if (isEmpty()) {
			setRoot(new BinaryNode<T> (newEntry));
			return null;
		} else {
			return addEntry(getRoot(), newEntry);
		}

	}

	private T addEntry(BinaryNode<T> node, T newEntry) {
		assert (node != null);
		T rootEntry = node.getData();
		int comparison = newEntry.compareTo(rootEntry);
		if (comparison == 0) {
			node.setData(newEntry);
			return rootEntry;
		} else if (comparison < 0) {
			if (node.hasLeftChild()) {
				return addEntry(node.getLeftChild(), newEntry);
			} else {
			node.setLeftChild(new BinaryNode<T> (newEntry));
			return null;
			}
		} else {
			if (node.hasRightChild())
				return addEntry(node.getRightChild(), newEntry);
			else {
				node.setRightChild(new BinaryNode<T> (newEntry));
				return null;
			}
		}
	}

	@Override
	public T remove(T entry) {
		ReturnObject oldEntry = new ReturnObject(null);
		BinaryNode<T> newRoot = removeEntry(getRoot(), entry, oldEntry);
		setRoot(newRoot);
		return oldEntry.getEntry();
	}

	private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T entry, ReturnObject oldEntry) {
		if (rootNode != null) {
			T rootData = rootNode.getData();
			int comparison = entry.compareTo(rootData);

			if (comparison == 0) {
				oldEntry.setEntry(rootData);
				rootNode = removeFromRoot(rootNode);
			} else if (comparison < 0) {
				BinaryNode<T> leftChild = rootNode.getLeftChild();
				BinaryNode<T> subtreeRoot = removeEntry(leftChild, entry, oldEntry);
				rootNode.setLeftChild(subtreeRoot);
			} else {
				BinaryNode<T> rightChild = rootNode.getRightChild();
				rootNode.setRightChild(removeEntry(rightChild, entry, oldEntry));
			}
		}
		return rootNode;
	} // end removeEntry

	private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode) {
		// Case 1: rootNode has two children
		if (rootNode.hasLeftChild() && rootNode.hasRightChild()) {
			// Find node with largest entry in left subtree
			BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
			BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
			// Replace entry in root
			rootNode.setData(largestNode.getData());
			// Remove node with largest entry in left subtree
			rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
		} // end if
			// Case 2: rootNode has at most one child
		else if (rootNode.hasRightChild())
			rootNode = rootNode.getRightChild();
		else
			rootNode = rootNode.getLeftChild();
		// Assertion: If rootNode was a leaf, it is now null
		return rootNode;
	} // end removeEntry

	private BinaryNode<T> findLargest(BinaryNode<T> rootNode) {
		if (rootNode.hasRightChild())
			rootNode = findLargest(rootNode.getRightChild());

		return rootNode;
	} // end findLargest

	private BinaryNode<T> removeLargest(BinaryNode<T> rootNode) {
		if (rootNode.hasRightChild()) {
			BinaryNode<T> rightChild = rootNode.getRightChild();
			rightChild = removeLargest(rightChild);
			rootNode.setRightChild(rightChild);
		} else
			rootNode = rootNode.getLeftChild();
		return rootNode;
	} // end removeLargest

	@Override
	public Iterator<T> getInorderIterator() {
		return super.getInorderIterator();
	}

	private class ReturnObject {
		private T oldEntry;

		public ReturnObject(T oldEntry) {
			this.oldEntry = oldEntry;
		}

		public T getEntry() {
			return oldEntry;
		}

		public void setEntry(T newEntry) {
			oldEntry = newEntry;
		}
	}
}
