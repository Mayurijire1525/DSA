 package singly;

import java.util.Scanner;



class SinglyCircularList{
	//Node class
	static class Node{

		//Node class fields
		private int data;
		private Node next;
		
		//Node class method
		public Node() {
			data=0;
			next=null;
		}
		public Node(int val) {
			data=val;
			next=null;
		}
	}
	//List class fields
	private Node head;
	
	//List class methods
	public SinglyCircularList() {
		head=null;
		
	}
	public boolean isEmpty() {
		return head==null;
	}
	public void display() {
		System.out.println("----------List---------");
		//special 1:list is empty then return
		if(isEmpty())
			return;
		//print all nodes in list
		Node trav=head;
				do {
				System.out.println(trav.data);
				trav=trav.next;
				}while(trav!=head);					
		}
	public void addLast(int val) {
		//create new node and init it
		Node newNode=new Node(val);
		//special 1:if list is empty newnode is th efirst node make it circular
		if(isEmpty()) {
			head=newNode;
			newNode.next=head;
		}
		//traverse till last node(trav.next=head)
		Node trav=head;
		while(trav.next!=head)
			trav=trav.next;
		//newnode next to head
		newNode.next=head;
		//last node trav next to newnode
		trav.next=newNode;
		
	}
	public void addFirst(int val) {
		//create new node and init it
		Node newNode=new Node(val);
		//special 1:if list is empty newnode is th efirst node make it circular
		if(isEmpty()) {
			head=newNode;
			newNode.next=head;
		}
		//traverse till last node(trav.next=head)
		Node trav=head;
		while(trav.next!=head) {
			trav=trav.next;
		}
		//newnode next to head
		newNode.next=head;
		//last node trav next to newnode
		trav.next=newNode;
		//make head to newNode
		head=newNode;
	}

	public void addAtPos(int val, int pos) {
		//special 1:if list is empty add node ar the start
		//special 2:if pos<=1 add node at the start
		
		if(head==null || pos<=1){
			addFirst(val);
		}else {
		//allocate &init new node
		Node newNode=new Node(val);
		
		//traverse till pos-1
		Node trav=head;
		for(int i=1; i<pos-1; i++) {
			//special 3:if pos >lenght of list add node at the end
			if(trav.next==head)
				break;
			trav=trav.next;
		}
		//newnode next shoudl point to trav next
		newNode.next=trav.next;
		//trav next should point to newnode 
		trav.next=newNode;
		}	
	}
	public void delFirst() {
		//special 1:if list is empty throw exception
		if(isEmpty())
			throw new RuntimeException("List is empty");
		//special 2:if list has single node then make head is null
		if(head.next==null)
			head=null;
		
		//traverse till last node(trav)
		else {
		Node trav=head;
	
		while(trav.next!=head)
			trav=trav.next;
		//take head to the next(2nd) node
		head=head.next;
		
		//the last node(trav) next should be to new head
		trav.next=head;
		}
		
	}
	public void delAtPos(int pos) {
		//special 1: if pos=1 delete first
		if(pos==1)
			delFirst();
		//special 2:if list is empty or pos<1 then throw exception
		if(head==null || pos<1)
			throw new RuntimeException("-----List is empty or Invalid position----");
		//take temp pointer running behind trav
		  Node temp=null,trav=head;
		  //traverse till pos(trav)
		  for(int i=1; i<pos; i++) {
			  //special 3:if pos is beyond list length then throw exception
			  if(trav.next==head)
				  throw new RuntimeException("Invalid position");
			  temp=trav;
			  trav=trav.next;
		  }
		  //trav is node to be deleted & temp is node before that
		  temp.next=trav.next;
		  //trav node will be garbage collected
	}
	public void delLast() {
		//special 1:if list is empty throw exception
		if(head==head)
			throw new RuntimeException("List is Empty");
		//special 2:if list has single node,make head head
		if(head.next==head)
			head=null;
		else {
		Node temp=null,trav=head;
		//traverse till last node(trav)and run temp behind it
		while(trav.next!=head) {
			temp=trav;
			trav=trav.next;
		}
		//when last node (trav) is deleted second last node (temp) next should be head,
		temp.next=head;
		//last node (trav) will be garbage collected
	}
	}
	public void delAll() {
		 head.next=null;
		 head=null;
	}
}

public class SinglyListMain {

		public static void main(String[] args) {
			int choice,val,pos;
			SinglyCircularList list=new SinglyCircularList();
			Scanner sc=new Scanner(System.in);
			do {
				System.out.println("0.Exit.\n 1.Display.\n 2.Add First.\n 3.Add Last.\n 4.Add at pos.\n 5.Del first.\n 6.Del last.\n 7.Del at pos.\n 8.Del All.");
				System.out.println("Enter choice");
				choice=sc.nextInt();
				
				switch(choice) {
				case 0:
					break;
				case 1:
					list.display();
					break;
				case 2://Add first
					System.out.println("Enter new element");
					val=sc.nextInt();
					list.addFirst(val);
					break;
				case 3://Add last
					System.out.println("Enter new element");
					val=sc.nextInt();
					list.addLast(val);
				break;				
				case 4://Add at pos
					System.out.println("Enter new element");
					val=sc.nextInt();
					System.out.println("Enter element position");
					pos=sc.nextInt();
					list.addAtPos(val,pos);
					break;
				case 5://Del first
					try{
						list.delFirst();
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 6://Del last
					try {
						list.delLast();
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 7://Del at pos
					System.out.println("Enter element position");
					pos=sc.nextInt();
					list.delAtPos(pos);
					break;
				case 8://Del all
					list.delAll();
					break;
				default:
					break;
					}
			}while(choice!=0);
				sc.close();
			

		}

	}


