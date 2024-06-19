

public class LinkedList {
	private Node head;

	public LinkedList() {
		this.head = null;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public boolean insert(int data) {
		Node newnode = new Node(data);
		if (head == null) {
			head = newnode;
			return true;
		}
		Node temp = head;

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(newnode);
		return true;
	}

	public void display() {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}
}