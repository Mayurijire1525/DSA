package bstree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import bstree.BinarySearchTree.Node;

class BinarySearchTree {
	static class Node {
		// Node fields
		private int data;
		private Node left, right;

		// Node methods
		public Node() {
			setData(0);
			left = null;
			right = null;
		}

		public Node(int val) {
			setData(val);
			left = null;
			right = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
	}

	// Tree fields
	private Node root;

	// Tree methods
	public BinarySearchTree() {
		root = null;
	}

	void add(int val) {
		Node newNode = new Node(val);
		if (root == null)
			root = newNode;
		else {
			Node trav = root;
			while (true) {
				if (val < trav.getData()) {
					if (trav.left != null)
						trav = trav.left;
					else {
						trav.left = newNode;
						break;
					}
				} else {
					if (trav.right != null)
						trav = trav.right;
					else {
						trav.right = newNode;
						break;
					}
				}
			}
		}
	}

	private void preorder(Node trav) {
		if (trav == null)
			return;
		System.out.print(trav.getData() + " ");
		preorder(trav.left);
		preorder(trav.right);
	}

	public void preorder() {
		System.out.print("PRE: ");
		preorder(root);
		System.out.println();
	}

	private void inorder(Node trav) {
		if (trav == null)
			return;
		inorder(trav.left);
		System.out.print(trav.getData() + " ");
		inorder(trav.right);
	}

	public void inorder() {
		System.out.print("IN: ");
		inorder(root);
		System.out.println();
	}

	private void postorder(Node trav) {
		if (trav == null)
			return;
		postorder(trav.left);
		postorder(trav.right);
		System.out.print(trav.getData() + " ");
	}

	public void postorder() {
		System.out.print("POST: ");
		postorder(root);
		System.out.println();
	}

	public void preorderNonRecursive() {
		System.out.print("PRE: ");
		Stack<Node> s = new Stack<>();
		Node trav = root;
		while (trav != null || !s.empty()) {
			while (trav != null) {
				System.out.print(trav.getData() + " ");
				if (trav.right != null)
					s.push(trav.right);
				trav = trav.left;
			}
			if (!s.empty())
				trav = s.pop();
		}
		System.out.println();
	}

	public void inorderNonRecursive() {
		System.out.print("IN: ");
		Stack<Node> s = new Stack<>();
		Node trav = root;
		while (trav != null || !s.empty()) {
			while (trav != null) {
				s.push(trav);
				trav = trav.left;
			}
			if (!s.empty()) {
				trav = s.pop();
				System.out.print(trav.getData() + " ");
				trav = trav.right;
			}
		}
		System.out.println();
	}

	private void deleteAll(Node trav) {
		if (trav == null)
			return;
		deleteAll(trav.left);
		deleteAll(trav.right);
		trav.left = null;
		trav.right = null;
	}

	public void deleteAll() {
		deleteAll(root);
		root = null;
	}

	public int height(Node trav) {
		if (trav == null)
			return -1;
		int hl = height(trav.left);
		int hr = height(trav.right);
		return Math.max(hl, hr) + 1;
	}

	public int height() {
		return height(root);
	}

	public Node bfs(int key) {
		
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			Node trav = q.poll();
			if (key == trav.getData())
				return trav;
			if (trav.left != null)
				q.offer(trav.left);
			if (trav.right != null)
				q.offer(trav.right);
		}
		return null;
	}
	public Node dfs(int key) {
		Stack<Node> q = new Stack<>();
		q.push(root);
		while (!q.isEmpty()) {
			Node trav = q.pop();
			if (key == trav.getData())
				return trav;
			if (trav.left != null)
				q.push(trav.left);
			if (trav.right != null)
				q.push(trav.right);
		}
		return null;
	}
	public Node binSearch(int key) {
		Node trav=root;
		while(trav!=null) {
		if(key==trav.data)
			return trav;
		if(key<trav.data)
			trav=trav.left;
		else
			trav=trav.right;
	}
	return null;
	}
}

public class BSTreeMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinarySearchTree t = new BinarySearchTree();
		t.add(50);
		t.add(30);
		t.add(10);
		t.add(90);
		t.add(100);
		t.add(40);
		t.add(70);
		t.add(80);
		t.add(60);
		t.add(20);
		t.preorder();
		t.preorderNonRecursive();
		t.inorder();
		t.inorderNonRecursive();
		t.postorder();
		System.out.println("Height: " + t.height());
		System.out.print("Enter element to find: ");
		int val = sc.nextInt();
		Node temp = t.bfs(val);
		if (temp == null)
			System.out.println("BFS: Not found");
		else
			System.out.println("BFS found: " + temp.getData());
		temp = t.dfs(val);
		if (temp == null)
			System.out.println("DFS: Not found");
		else
			System.out.println("DFS found: " + temp.getData());
		
		System.out.println("BFS found: " + temp.getData());
		temp = t.binSearch(val);
		if (temp == null)
			System.out.println("BS: Not found");
		else
			System.out.println("BS found: " + temp.getData());
		
		t.deleteAll();
		t.inorder();
		System.out.println("Height: " + t.height());
		sc.close();
	}
}
