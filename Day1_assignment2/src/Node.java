
public class Node {
	private Product data;
	private Node next;
	
	public Node(Product data) {
		super();
		this.data = data;
		this.next = null;
	}

	public Product getData() {
		return data;
	}

	public void setData(Product data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	

	}

