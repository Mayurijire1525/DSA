package singlylist;

import java.util.Scanner;

class SinglyList {
	static class Node {
		private int data;
		private Node next;

		public Node() {
			data = 0;
			next = null;
		}

		public Node(int val) {
			data = val;
			next = null;
		}
	}

	private Node head;

	public SinglyList() {
		head = null;
	}

	void display() {
		System.out.println("List: ");
		Node trav = head;
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
		System.out.println("");
	}

	public void addFirst(int val) {
		// create new node and init it
		Node newNode = new Node(val);
		// new node next should point ot head
		newNode.next = head;
		// head should point to new node
		head = newNode;

	}

	public void addLast(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
				trav.next = newNode;
			}
		}
	}

	public void addAtPos(int val, int pos) {
		// special 1:if list is empty add node ar the start
		// special 2:if pos<=1 add node at the start

		if (head == null || pos <= 1) {
			addFirst(val);
		} else {
			// allocate &init new node
			Node newNode = new Node(val);

			// traverse till pos-1
			Node trav = head;
			for (int i = 1; i < pos - 1; i++) {
				// special 3:if pos >lenght of list add node at the end
				if (trav.next == null)
					break;
				trav = trav.next;
			}
			// newnode next shoudl point to trav next
			newNode.next = trav.next;
			// trav next should point to newnode
			trav.next = newNode;
		}
	}

	public void delFirst() {
		// special 1:if list is empty throw exception
		if (head == null)
			throw new RuntimeException("-----List is empty----");
		// make head pointing to new node
		head = head.next;
		// old first node will be garbage collected
	}

	public void delAll() {
		head = null;
		// all node will be garbage collected

	}

	public void delAtPos(int pos) {
		// special 1: if pos=1 delete first
		if (pos == 1)
			delFirst();
		// special 2:if list is empty or pos<1 then throw exception
		if (head == null || pos < 1)
			throw new RuntimeException("-----List is empty or Invalid position----");
		// take temp pointer running behind trav
		Node temp = null, trav = head;
		// traverse till pos(trav)
		for (int i = 1; i < pos; i++) {
			// special 3:if pos is beyond list length then throw exception
			if (trav == null)
				throw new RuntimeException("Invalid position");
			temp = trav;
			trav = trav.next;
		}
		// trav is node to be deleted & temp is node before that
		temp.next = trav.next;
		// trav node will be garbage collected
	}

	public void delLast() {
		// special 1:if list is empty throw exception
		if (head == null)
			throw new RuntimeException("List is Empty");
		// special 2:if list has single node,make head null
		if (head.next == null)
			head = null;
		else {
			Node temp = null, trav = head;
			// traverse till last node(trav)and run temp behind it
			while (trav.next != null) {
				temp = trav;
				trav = trav.next;
			}
			// when last node (trav) is deleted second last node (temp) next should be null,
			temp.next = null;
			// last node (trav) will be garbage collected
		}
	}
}

public class SinglyListMain {

	public static void main(String[] args) {
		int choice, val, pos;
		SinglyList list = new SinglyList();
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
				try {
					list.delLast();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:// Del at pos
				System.out.println("Enter element position");
				pos = sc.nextInt();
				list.delAtPos(pos);
				break;
			case 8:// Del all
				list.delAll();
				break;
			default:
				break;
			}
		} while (choice != 0);
		sc.close();

	}

}
