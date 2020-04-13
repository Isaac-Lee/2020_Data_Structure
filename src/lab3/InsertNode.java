package lab3;

import java.util.Scanner;

public class InsertNode {

    static class MyNode {
        public int data;
        public MyNode next;

        public MyNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class MyList {
        public MyNode head;
        public MyNode tail;

        public MyList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int data) {
            MyNode node = new MyNode(data);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    static void printMyList(MyNode head) {
        MyNode node = head;
        while(node != null) {
            System.out.print(String.valueOf(node.data) + " ");
            node = node.next;
        }
        
        System.out.println();
    }

    static MyNode insertNodeAt(MyNode head, int data, int position) {
    	MyNode node = head;
    	MyNode newNode = new MyNode(data);
    	int index = 0;
    	
    	while (node.next != null) {
    		if (position == 0) {
        		newNode.next = head;
        		head = newNode;
        		break;
        	} 
    		if (index == position-1) {
    			newNode.next = node.next;
        		node.next = newNode;
        		break;
    		} else {
    			node = node.next;
    		}
    		if (node.next == null) {
    			node.next = newNode;
    			break;
    		}
    		index ++;
    	}
    	return head;
    }

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MyList list = new MyList();

        int cnt = scanner.nextInt();

        for (int i = 0; i < cnt; i++) {
            int data = scanner.nextInt();

            list.insertNode(data);
        }

        int data = scanner.nextInt();

        int position = scanner.nextInt();

        MyNode head = insertNodeAt(list.head, data, position);

        printMyList(head);
        
        scanner.close();
    }
}

