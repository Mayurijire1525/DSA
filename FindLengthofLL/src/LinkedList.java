
public class LinkedList {
	Node head;
	
	public void push(int data) {
		Node newNode=new Node(data);
		newNode.next=head;
		head=newNode;
	}
	public int getcount() {
		Node temp=head;
		int count=0;
		while(temp!=null) {
			count++;
			temp=temp.next;
		}
		return count;
	}
	
	public static void main(String[] args) {
		LinkedList llist=new LinkedList();
		
		llist.push(1);
		llist.push(2);
		llist.push(3);
		llist.push(4);
		llist.push(5);
		llist.push(6);

		System.out.println("Count of nodes is->"+llist.getcount());
	}



}
