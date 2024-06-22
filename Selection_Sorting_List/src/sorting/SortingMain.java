package sorting;

import java.util.Scanner;

class SinglyList {
	// Node class
	static class Node {
		private int data;
		private Node next;

		public Node(int val) {
			data = val;
			next = null;
		}
	}

	private Node head;

	public SinglyList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addLast(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			trav.next = newNode;
		}
	}

	public void display() {
		System.out.println("-----List-----");
		Node trav = head;
		while (trav != null) {
			System.out.print(trav.data + " ");
			trav = trav.next;
		}
		System.out.println();
	}

	public void selectionSort() {
		if (head == null) {
			return;
		}

		for (Node i = head; i.next != null; i = i.next) {
			Node min = i;
			for (Node j = i.next; j != null; j = j.next) {
				if (j.data < min.data) {
					min = j;
				}
			}
			int temp = i.data;
			i.data = min.data;
			min.data = temp;
		}
	}
}

public class SortingMain {
	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of elements:");
		int n = sc.nextInt();
		System.out.println("Enter the elements:");
		for (int i = 0; i < n; i++) {
			list.addLast(sc.nextInt());
		}

		System.out.println("Selection sort");
		System.out.println("Before:");
		list.display();

		list.selectionSort();

		System.out.println("After:");
		list.display();

		sc.close();
	}
}
