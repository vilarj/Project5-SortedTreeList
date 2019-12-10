package project5Tree;

import java.util.Iterator;

import binaryTree.BinaryTree;
import binaryTree.BinaryTreeInterface;
import encoding.Decoder;

public class treeTesting {
	public static void main(String[] args) {
		SortedTreeList<String> t = new SortedTreeList <>();
		BinarySearchTree<String> s = new BinarySearchTree<>();
		//BinaryTreeInterface<String> emptyTree = new BinaryTree <>();
		//BinaryTreeInterface<String> gTree = new BinaryTree <>();
		//s.add("h");
		
		
		
		t.addEntry("h");
		t.addEntry("a");
		t.addEntry("z");
		
		
		Iterator<String> it = t.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println(t.contains("a"));
		
		System.out.println(t.getPosition("a"));
		System.out.println(t.getEntry(1));
		
		//System.out.println(t.getLength());
		
		//t.clear();
		System.out.println(t.isEmpty());
		
		Object[] arr = t.toArray();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	

}

