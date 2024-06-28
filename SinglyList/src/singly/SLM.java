package singly;

import java.util.Scanner;

class SinglyLinear {
    private Node head;
    private Node tail;

    public SinglyLinear() {
        head = null;
        tail = null;
    }

    static class Node {
        private int data;
        private Node next;

        public Node(int val) {
            data = val;
            next = null;
        }
    }

    public void addFirst(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void display() {
        System.out.println("List:");
        Node trav = head;
        while (trav != null) {
            System.out.print(trav.data + " -> ");
            trav = trav.next;
        }
        System.out.println("null");
    }

	public void addAtPos(int pos, int val) {
		if(head==null || pos<=1) {
			addFirst(val);
		}else {
			Node newNode=new Node(val);
			Node trav=head;
			for(int i=1; i<pos-1; i++) {
				if(head.next==null)
					break;
				trav=trav.next;
			}
			newNode.next=trav.next;
			trav.next=newNode;
		}
		
	}

	public void delFirst() {
		if(head==null) {
			throw new RuntimeException("List is empty");
		}
		head=head.next;
		
	}

	public void delLast() {
		if(head==null)
			throw new RuntimeException("List is empty");
		if(head.next==null)
			head=null;
		else {
			Node temp=null,trav=head;
			while(trav.next!=null) {
				temp=trav;
				trav=trav.next;
			}
			temp.next=null;
				
		}
		
	}

	public void delAtPos(int pos) {
		if(pos==1)
			delFirst();
		if (head == null || pos < 1)
			throw new RuntimeException("-----List is empty or Invalid position----");
		Node temp=null,trav=head;
		for(int i=1; i<pos; i++) {
			if (trav == null)
				throw new RuntimeException("Invalid position");
			temp=trav;
			trav=trav.next;
		}
		temp.next=trav.next;
			
		
	}
	
    
}

public class SLM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinear sl = new SinglyLinear();

        boolean exit = false;
        int val, ch,pos;
        while (!exit) {
            System.out.print(
                    "1. AddFirst\n2. AddLast\n3. AddAtPos\n4. DelFirst\n5. DelLast\n6. DelAtPos\n7. Display\n0. Exit\nEnter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1: // addFirst
                    System.out.println("Enter new element");
                    val = sc.nextInt();
                    sl.addFirst(val);
                    break;
                case 2: // addLast
                    System.out.println("Enter new element");
                    val = sc.nextInt();
                    sl.addLast(val);
                    break;
                case 3:
                    // Implement addAtPos
                	System.out.println("Enter position to add value");
                	pos=sc.nextInt();
                	 System.out.println("Enter new element");
                     val = sc.nextInt();
                     sl.addAtPos(pos,val);
            
                    break;
                case 4:
                	sl.delFirst();
                    // Implement delFirst
                    break;
                case 5:
                    // Implement delLast
                	sl.delLast();
                    break;
                case 6:
                     // Implement delAtPos
                	System.out.println("Enter position to delete");
                	pos=sc.nextInt();
                	sl.delAtPos(pos);
                    break;
                case 7: // display
                    sl.display();
                    break;
                case 0: // exit
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
        sc.close();
    }
}
