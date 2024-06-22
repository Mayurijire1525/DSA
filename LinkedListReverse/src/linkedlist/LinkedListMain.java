package linkedlist;

class SinglyList {
	static class Node {
		private int data;
		private Node next;

		public Node() {
			this.data = 0;
			this.next = null;
		}

		public Node(int val) {
			this.data = val;
			this.next = null;
		}
	}

	private Node head;

	public SinglyList() {
		head = null;
	}

	public void addLast(int val) {
		Node newNode = new Node(val);

		if (head == null) {
			head = newNode;
		} else {
			Node trav = head;
			while (trav.next != null)
				trav = trav.next;
			trav.next = newNode;
		}
	}

	public void display() {
		System.out.print("List: ");
		Node trav = head;
		while (trav != null) {
			System.out.print(trav.data + " -> ");
			trav = trav.next;
		}
		System.out.println("null");
	}

	public void reverse() {
		Node oldhead=head;
		head=null;
		while(oldhead!=null) {
		Node temp=oldhead;
		oldhead=oldhead.next;
		
		temp.next=head;
		head=temp;
		}
	}
		
}

public class LinkedListMain {

	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.display();
		list.reverse();
		list.display();
	}
}
