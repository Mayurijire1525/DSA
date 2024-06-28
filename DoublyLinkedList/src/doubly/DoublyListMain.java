
package doubly;

import java.util.Scanner;

class DoublyList {
	// Node class
	static class Node {
		// Node class fields
		private int data;
		private Node next;
		private Node prev;

		// Node class methods
		public Node() {
			data = 0;
			next = null;
			prev = null;
		}

		public Node(int val) {
			data = val;
			next = null;
			prev = null;
		}
	}

	// List class fields
	private Node head;

	// List class method
	public DoublyList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void display() {
		// forward display
		System.out.println("-----Forward List-----");
		Node trav = head;
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
	}

	public void displayreverse() {
		// reverse display
		System.out.println("----Reverse list----");
		if (head == null)
			return;
		// traverse till last
		Node trav = head;
		while (trav.next != null)
			trav = trav.next;

		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.prev;
		} 
	}

	public void addLast(int val) {
		// create new node & init it
		Node newNode = new Node(val);
		// special 1: if list is empty make new node as first node of list
		if (head == null) {
			head = newNode;
		} else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			// add new node after trav
			trav.next = newNode;
			// newNode prev to last node
			newNode.prev = trav;
		}
	}

	public void addFirst(int val) {
		// create new node and init it
		Node newNode = new Node(val);
		// if list is empty
		if (isEmpty()) {
			head = newNode;
		} else {
			// new node next should point to head
			newNode.next = head;
			head.prev = newNode;
			// head should point to new node
			head = newNode;
		}
	}

	public void addAtPos(int val, int pos) {
		// special 1: if list is empty add node at the start
		// special 2: if pos <= 1 add node at the start
		if (head == null || pos <= 1) {
			addFirst(val);
		} else {
			// allocate & init new node
			Node newNode = new Node(val);

			// traverse till pos-1
			Node temp, trav = head;
			for (int i = 1; i < pos - 1; i++) {
				// special 3: if pos > length of list add node at the end
				if (trav.next == null)
					break;
				trav = trav.next;
			}
			// take temp pointer to node after trav
			temp = trav.next;
			// newNode next should point to trav next
			newNode.next = temp;
			newNode.prev = trav;
			// trav next should point to newNode
			trav.next = newNode;
			if (temp != null)
				temp.prev = newNode;
		}
	}

	public void delFirst() {
		// if list is empty throw exception
		if (head == null)
			throw new RuntimeException("List is empty");
		// special 2: if list has single node, make head null
		if (head.next == null) {
			head = null;
			return;
		}
		// make head pointing to next node
		head = head.next;
		// the old first node will be garbage collected
		// second node (new head) prev should be null
		head.prev = null;
	}

	public void delAtPos(int pos) {
		// special 1: if pos = 1 delete first
		if (pos == 1) {
			delFirst();
			return;
		}
		// special 2: if list is empty or pos < 1 then throw exception
		if (head == null || pos < 1)
			throw new RuntimeException("-----List is empty or Invalid position----");
		// take trav pointer to the node at given position
		Node trav = head;
		for (int i = 1; i < pos; i++) {
			// special 3: if pos is beyond list length then throw exception
			if (trav.next == null)
				throw new RuntimeException("Invalid position");
			trav = trav.next;
		}
		// unlink the node at position
		if (trav.prev != null)
			trav.prev.next = trav.next;
		if (trav.next != null)
			trav.next.prev = trav.prev;
	}
}

public class DoublyListMain {

	public static void main(String[] args) {
		int choice, val, pos;
		DoublyList list = new DoublyList();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(
					"0.Exit.\n 1.Display.\n 2.Add First.\n 3.Add Last.\n 4.Add at pos.\n 5.Del first.\n 6.Del last.\n 7.Del at pos.\n 8.Del All.");
			System.out.println("Enter choice");
			choice = sc.nextInt();

			switch (choice) {
			case 0:
				break;
			case 1:
				list.display();
				list.displayreverse();
				break;
			case 2:// Add first
				System.out.println("Enter new element");
				val = sc.nextInt();
				list.addFirst(val);
				break;
			case 3:// Add last
				System.out.println("Enter new element");
				val = sc.nextInt();
				list.addLast(val);
				break;
			case 4:// Add at pos
				System.out.println("Enter new element");
				val = sc.nextInt();
				System.out.println("Enter element position");
				pos = sc.nextInt();
				list.addAtPos(val, pos);
				break;
			case 5:// Del first
				try {
					list.delFirst();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:// Del last
//                    try {
//                        list.delLast();
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
				break;
			case 7:// Del at pos
				System.out.println("Enter element position");
				pos = sc.nextInt();
				try {
					list.delAtPos(pos);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 8:// Del all
//                    list.delAll();
				break;
			default:
				break;
			}
		} while (choice != 0);
		sc.close();
	}
}
