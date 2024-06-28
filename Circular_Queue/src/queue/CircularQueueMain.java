package queue;

import java.util.Scanner;

class CircularQueue {
    private int[] arr;
    private int rear, front;
    private int size;

    public CircularQueue(int size) {
        arr = new int[size];
        this.size = size;
        rear = -1;
        front = -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public void push(int val) {
        if (isFull())
            throw new RuntimeException("Queue is full");
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % size;
        arr[rear] = val;
    }

    public void pop() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return arr[front];
    }
}

public class CircularQueueMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularQueue q = new CircularQueue(6);
        int choice, val;
        do {
            System.out.println("\n0.Exit\n1.Push\n2.Pop\n3.Peek\nEnter choice");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // push
                    try {
                        System.out.println("Enter value to push");
                        val = sc.nextInt();
                        q.push(val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2: // pop
                    try {
                        val = q.peek();
                        q.pop();
                        System.out.println("Popped " + val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3: // peek
                    try {
                        val = q.peek();
                        System.out.println("Peek " + val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        } while (choice != 0);
        sc.close();
    }
}
