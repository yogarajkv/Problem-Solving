package com.map.practice;

import java.util.LinkedList;
import java.util.List;
/*
 * Merge two unsorted List
 */
public class MergeUnsortedList {

	class Node
	{
		int data;
		Node left;
		Node right;
	}
	
	private Node getNewNode(final int val) {
		Node temp = new Node();
		temp.left = null;
		temp.right = null;
		temp.data = val;
		return temp;
	}

	private Node insert(Node root, int val) {
		if (root == null) {
			root = getNewNode(val);
		} else if (val <= root.data) {
			root.left = insert(root.left, val);

		} else if (val > root.data) {
			root.right = insert(root.right, val);
		}
		return root;
	}

	private void inOrder(final Node root) {

		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public static void main(String[] args) {
		
		List<Integer> l1 = new LinkedList<Integer>();
		l1.add(10);
		l1.add(1);
		l1.add(3);
		l1.add(3);
		l1.add(7);
		l1.add(8);
		
		List<Integer> l2 = new LinkedList<Integer>();
		l2.add(2);
		l2.add(12);
		l2.add(5);
		
		
		MergeUnsortedList ml = new MergeUnsortedList();
		Node root = null;
		for(Integer i: l1)
		{
			root  = ml.insert(root, i);
		}
		for(Integer i:l2)
		{
			ml.insert(root, i);
		}
		
		ml.inOrder(root);
		
	}

}
