class Node {
    // variables
    int data;
    Node next;

    // singly circular LL
    Node(int x) {
        this.data = x;
        this.next = null;
    }

}

public class CircularLL {
    Node head = null;

    public void insertStart(int data) {
        Node newNode = new Node(data);
        // if this is the first node
        if (head == null) {
            head = newNode;
            newNode.next = newNode;

        } else {
            newNode.next = head.next;
            head.next = newNode;
            int temp = head.data;
            head.data = newNode.data;
            newNode.data = temp;

        }

    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        // if this is the first node
        if (head == null) {
            head = newNode;
            newNode.next = newNode;

        } else {
            newNode.next = head.next;
            head.next = newNode;
            int temp = head.data;
            head.data = newNode.data;
            newNode.data = temp;
            head = newNode;

        }
    }

    void display() {
        if (head == null) {
            return;
        }
        Node temp = head;
        // if there is only one node we have to print it so --do while prefered
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

    }

    public static void main(String args[]) {
        // create an object
        CircularLL list = new CircularLL();
        list.insertLast(0);
        list.insertStart(10);
        list.insertStart(20);
        list.insertStart(30);
        list.insertLast(100);
        list.display();

    }

}
