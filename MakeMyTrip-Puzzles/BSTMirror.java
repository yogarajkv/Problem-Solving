package com.map.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BSTMirror {

	class Node {
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

	private void mirror( Node current) {

		if(current==null)
			return ;
		mirror(current.left);
		mirror(current.right);
		
		Node temp = current.left;
		current.left = current.right;
		current.right= temp;		
		
	}

	public static void main(String[] args) {

		List<Integer> l2 = new LinkedList<Integer>();
		l2.add(2);
		l2.add(12);
		l2.add(13);
		BSTMirror ml = new BSTMirror();
		Node root = null;
		for (Integer i : l2) {
			root = ml.insert(root, i);
		}

		ml.inOrder(root);
		ml.mirror(root);
		System.out.println();
		ml.inOrder(root);

	}

}
