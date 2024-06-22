package doubly;

import java.util.Scanner;

class DoublyCircularList {
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

	// List class methods
	public DoublyCircularList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void display() {
		// forward display
		System.out.println("-----Forward List-----");
		if (head == null)
			return;

		Node trav = head;
		do {
			System.out.println(trav.data);
			trav = trav.next;
		} while (trav != head);
	}

	public void displayreverse() {
		// reverse display
		System.out.println("----Reverse list----");
		if (head == null)
			return;

		Node trav = head.prev;
		do {
			System.out.println(trav.data);
			trav = trav.prev;
		} while (trav != head.prev);
	}

	public void addLast(int val) {
		// create new node & init it
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			head.next = head;
			head.prev = head;
		} else {
			Node last = head.prev;
			last.next = newNode;
			newNode.prev = last;
			newNode.next = head;
			head.prev = newNode;
		}
	}

	public void addFirst(int val) {
		Node newNode = new Node(val);
		if (isEmpty()) {
			head = newNode;
			head.next = head;
			head.prev = head;
		} else {
			Node last = head.prev;
			newNode.next = head;
			newNode.prev = last;
			head.prev = newNode;
			last.next = newNode;
			head = newNode;
		}
	}

	public void addAtPos(int val, int pos) {
		if (head == null || pos <= 1) {
			addFirst(val);
		} else {
			Node newNode = new Node(val);
			Node trav = head;
			for (int i = 1; i < pos - 1; i++) {
				trav = trav.next;
				if (trav == head)
					break; // if pos > length of list, add at the end
			}
			Node temp = trav.next;
			trav.next = newNode;
			newNode.prev = trav;
			newNode.next = temp;
			temp.prev = newNode;
		}
	}

	public void delFirst() {
		if (head == null)
			throw new RuntimeException("List is empty");

		if (head.next == head) {
			head = null;
		} else {
			Node last = head.prev;
			head = head.next;
			head.prev = last;
			last.next = head;
		}
	}

	public void delLast() {
		if (head == null)
			throw new RuntimeException("List is empty");

		if (head.next == head) {
			head = null;
		} else {
			Node last = head.prev;
			Node secondLast = last.prev;
			secondLast.next = head;
			head.prev = secondLast;
		}
	}

	public void delAtPos(int pos) {
		if (pos == 1) {
			delFirst();
			return;
		}
		if (head == null || pos < 1)
			throw new RuntimeException("List is empty or invalid position");

		Node trav = head;
		for (int i = 1; i < pos; i++) {
			trav = trav.next;
			if (trav == head)
				throw new RuntimeException("Invalid position");
		}
		trav.prev.next = trav.next;
		trav.next.prev = trav.prev;
	}

	public void delAll() {
		head = null;
	}
}

public class DoublyListMain {
	public static void main(String[] args) {
		int choice, val, pos;
		DoublyCircularList list = new DoublyCircularList();
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
			case 2: // Add first
				System.out.println("Enter new element");
				val = sc.nextInt();
				list.addFirst(val);
				break;
			case 3: // Add last
				System.out.println("Enter new element");
				val = sc.nextInt();
				list.addLast(val);
				break;
			case 4: // Add at pos
				System.out.println("Enter new element");
				val = sc.nextInt();
				System.out.println("Enter element position");
				pos = sc.nextInt();
				list.addAtPos(val, pos);
				break;
			case 5: // Del first
				try {
					list.delFirst();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6: // Del last
				try {
					list.delLast();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7: // Del at pos
				System.out.println("Enter element position");
				pos = sc.nextInt();
				try {
					list.delAtPos(pos);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 8: // Del all
				list.delAll();
				break;
			default:
				break;
			}
		} while (choice != 0);
		sc.close();
	}
}
