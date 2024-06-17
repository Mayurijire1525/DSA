
public class LinkedList {
	private Node head;
	
	public Node getHead() {
		return head;
	}
	
	public LinkedList() {
		head=null;
	}
	
	public boolean insert(int data) {
		Node newNode=new Node(data);
		if(newNode==null) {
			return false;
		}
		
	if(head==null) {
		head=newNode;
		return true;
	}
	
	Node temp=head;
	if(head.getData()==data) {
		return false;
	}
	
	while(temp.getNext()!=null) {
		temp=temp.getNext();
		if(temp.getData()==data) {
			return false;
		}
	}
	temp.setNext(newNode);
	return true;
	
}
	public void display() {
		Node temp=head;
		
		while(temp!=null) {
			System.out.print(temp.getData()+" ");
			temp=temp.getNext();
		}
		System.out.println();
	}
	
	public int maxele() {
		int max=head.getData();
		Node temp=head.getNext();
		
		while(temp!=null) {
			if(temp.getData()>max) {
				max=temp.getData();
			}
			temp=temp.getNext();
		}
		return max;
	}
	public int minele() {
		int min=head.getData();
		Node temp=head.getNext();
		
		while(temp!=null) {
			if(temp.getData()<min) {
				min=temp.getData();
			}
			temp=temp.getNext();
		}
		return min;
	}
	public int sumofeven() {
		int sum=0;
		Node temp=head;
		while(temp!=null) {
			if(temp.getData()%2==0) {
				sum+=temp.getData();
			}
			temp=temp.getNext();
		}
		return sum;
	}
}
