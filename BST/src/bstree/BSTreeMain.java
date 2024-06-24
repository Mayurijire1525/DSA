package bstree;

import java.util.Stack;

class BinarySearchTree {
	static class Node {
		// Node fields
		private int data;
		private Node left, right;
		// Node method

		public Node() {
			data = 0;
			left = null;
			right = null;
		}

		public Node(int val) {
			data = val;
			left = null;
			right = null;
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
				if (val < trav.data) {
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
		System.out.print(trav.data + ", ");
		preorder(trav.left);
		preorder(trav.right);
	}

	public void preorder() {
		System.out.print("PRE :");
		preorder(root);
		System.out.println();
	}

	private void inorder(Node trav) {
		if (trav == null)
			return;
		inorder(trav.left);
		System.out.print(trav.data + ", ");
		inorder(trav.right);
	}

	public void inorder() {
		System.out.print("IN :");
		inorder(root);
		System.out.println();
	}

	private void postorder(Node trav) {
		if (trav == null)
			return;
		postorder(trav.left);
		postorder(trav.right);
		System.out.print(trav.data + ", ");
	}
 
	public void postorder() {
		System.out.print(" POST :");
		postorder(root);
		System.out.println();
	}
	public void preorderNonRecursive() {
		System.out.print ("PRE: ");
		Stack<Node> s=new Stack<>();
		Node trav=root;
		while(trav!=null || !s.empty()) {
			while(trav!=null) {
				System.out.print(trav.data+", ");
				if(trav.right!=null)
					s.push(trav.right);
				trav=trav.left;
			}
			if(!s.empty())
				trav=s.pop();
		}
		System.out.println();
	}
	public void inorderNonRecursive() {
		System.out.print ("IN: ");
		Stack<Node> s=new Stack<>();
		Node trav=root;
		while(trav!=null || !s.empty()) {
			while(trav!=null) {
					s.push(trav);
				trav=trav.left;
			}
			if(!s.empty())
				trav=s.pop();
			System.out.print(trav.data+", ");
			trav=trav.right;
		}
		System.out.println();
	}
	private void deleteAll(Node trav) {
		if(trav==null)
			return;
		deleteAll(trav.left);
		deleteAll(trav.right);
		trav.left=null;
		trav.right=null;
		trav=null;
	}
	public void deleteAll() {
		deleteAll(root);
		root=null;
	}
	public int height(Node trav) {
		if(trav==null)
			return -1;
		int hl=height(trav.left);
		int hr=height(trav.right);
		int max=hl>hr?hl:hr;
		return max+1;
	}
	public int height() {
		return height(root);
	}
}

public class BSTreeMain {

	public static void main(String[] args) {
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
		System.out.println("Height "+t.height());
		// t.display();
		t.deleteAll();
		t.inorder();
		System.out.println("Height "+t.height());
	}
}
