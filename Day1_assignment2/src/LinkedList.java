public class LinkedList {
	private Node head;

	public LinkedList() {
		this.head = null;
	}

	public boolean insertEle(Product data) {
		Node newNode = new Node(data);

		if (newNode == null) {
			return false;
		}

		if (head == null) {
			head = newNode;
			return true;
		}

		Node temp = head;
		if (head.getData() == data) {
			return false;
		}

		while (temp.getNext() != null) {
			temp = temp.getNext();
			if (temp.getData() == data) {
				return false;
			}
		}
		temp.setNext(newNode);
		return true;
	}

	public void displayProducts() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
		
	}

}