package singly;

import java.util.Scanner;
import java.util.Stack;

class singlycircular{
	private Node head;
	
	public singlycircular() {
		head=null;
	}
	
	static class Node{
		private int data;
		private Node next;
		
		public Node() {
			data=0;
			next=null;
		}
		public Node(int val) {
			data=val;
			next=null;
		
	}
		
}

	public boolean isEmpty() {
		return head==null;
	}
	
	public void display() {
		System.out.println("List----------------");
		Node trav=head;
		
		do {
			System.out.print(trav.data+"->");
			trav=trav.next;
		}while(trav.next!=head);
		System.out.println();
	}

	public void addFirst(int val) {
		Node newNode=new Node(val);
		if(isEmpty()) {
			head=newNode;
			newNode.next=head;
		}
		Node trav=head;
		while(trav.next!=head) {
			trav=trav.next;
		}
		newNode.next=head;
		trav.next=newNode;
		head=newNode;
		
	}

	public void addLast(int val) {
		Node newNode=new Node(val);
		Node trav=head;
		if (isEmpty()) {
			head = newNode;
			newNode.next = head;
		}
		while(trav.next!=head) {
			trav=trav.next;
		}
		newNode.next=head;
		trav.next=newNode;
		
	}

	public void addAtPos(int val, int pos) {
		Node newNode=new Node(val);
		if(head==null || pos<=1) {
			addFirst(val);
		}else {
			Node temp=null,trav=head;
			for(int i=1; i<pos-1; i++) {
				if(trav.next==head)
					break;
				trav=trav.next;
			}
			newNode.next=trav.next;
			trav.next=newNode;
		}
		
	}

	public void delFirst() {
		if (isEmpty())
			throw new RuntimeException("List is empty");
		// special 2:if list has single node then make head is null
		if (head.next == null)
			head = null;

		// traverse till last node(trav)
		else {
			Node trav = head;

			while (trav.next != head)
				trav = trav.next;
			// take head to the next(2nd) node
			head = head.next;

			// the last node(trav) next should be to new head
			trav.next = head;
		}
		
}

	public void delLast() {
		Node trav=head;
		if(head==head)
			throw new RuntimeException("List is Empty");
		if(head.next==head)
			head=null;
		Node temp=null;
		while(trav.next!=head) {
			temp=trav;
		    trav=trav.next;
		}
		trav.next=head;
	}

	public void delAtPos(int pos) {
		if (head == head)
			throw new RuntimeException("List is Empty");
		// special 2:if list has single node,make head head
		if (head.next == head)
			head = null;
		else {
			Node temp=null,trav=head;
			while(trav.next!=head) {
				temp=trav;
				trav=trav.next;
			}
			temp.next=trav.next;
		}
		
	}

	public void delAll() {
		head.next=null;
		head=null;
		
	}
	public void displayRev() {
		Stack<Node> st=new Stack();
		Node temp=head;
		
		while(temp!=null) {
			st.push(temp);
			temp=temp.next;
		}
		while(!st.isEmpty()) {
			System.out.print(st.pop().data+" ");
		}
		System.out.println();
	}
}


public class SCM {

	public static void main(String[] args) {
		int choice, val, pos;
		singlycircular list = new singlycircular();
		Scanner sc = new Scanner(System.in);
		boolean exit=false;
		while(!exit){
			System.out.println(
					"0.Exit.\n 1.Display.\n 2.Add First.\n 3.Add Last.\n 4.Add at pos.\n 5.Del first.\n 6.Del last.\n 7.Del at pos.\n 8.Del All.\n9.Reverse");
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
			case 9:
				list.displayRev();
			default:
				break;
			}
		} 
		sc.close();

	}

}
