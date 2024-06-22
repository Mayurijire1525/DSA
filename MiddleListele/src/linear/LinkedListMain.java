package linear;

import java.util.Scanner;



class SinglyList {
//Node class
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
	public int findMid() {
		Node fast=head,slow=head;
		while(fast!=null&& fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}
}
	
public class LinkedListMain {

	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.addLast(70);
		list.display();
		System.out.println("Middle "+list.findMid());
		
		


	}

}
