package queue;

import java.util.Scanner;

class LinearQueue {
    private int[] arr;
    private int rear, front;

    public LinearQueue(int size) {
        arr = new int[size];
        rear = -1;
        front = -1;
    }

    public boolean isFull() {
        return rear == arr.length - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void push(int val) {
        if (isFull())
            throw new RuntimeException("Queue is full");
        rear++;
        arr[rear] = val;
    }

    public void pop() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        front++;
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return arr[front + 1];
    }
}

public class LinearQueueMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearQueue s = new LinearQueue(6);
        int choice, val;
        do {
            System.out.println("\n0.Exit\n1.Push\n2.Pop\n3.Peek\nEnter choice");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // push
                    try {
                        System.out.println("Enter value to push");
                        val = sc.nextInt();
                        s.push(val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2: // pop
                    try {
                        val = s.peek();
                        s.pop();
                        System.out.println("Popped " + val);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        val = s.peek();
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
