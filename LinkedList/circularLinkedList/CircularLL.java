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

    public int calcSize() {

        if (head.next == head) {
            return (1);
        } else {
            int size = 0;
            Node temp = head.next;
            while (temp != head) {
                temp = temp.next;
                size++;
            }
            System.out.println(size + 1);
            return (size + 1);
        }
    }

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

    public void deleteStart() {
        if (head == null) {
            System.out.println("No node to delete");
            return;
        }
        if (head.next == head) {
            head = null;

        } else {
            head.data = head.next.data;
            head.next = head.next.next;

        }

    }

    public void deleteAtPos(int pos) {
        if (head == null) {
            System.out.println("No node to delete");
            return;
        }
        int size = calcSize();
        if (pos < 1 || pos > size) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            deleteStart();
            return;
        }
        Node current = head;
        for (int i = 0; i < pos - 2; i++) {
            current = current.next;
        }
        current.next = current.next.next;

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
        System.out.println();

    }

    public static void main(String args[]) {
        // create an object
        CircularLL list = new CircularLL();
        list.deleteAtPos(2);
        list.insertLast(0);
        list.display();
        list.deleteStart();
        list.insertStart(10);
        list.display();
        list.insertStart(20);
        list.insertStart(30);
        list.insertLast(100);
        list.display();
        list.deleteAtPos(4);
        list.display();
        list.deleteStart();
        list.deleteAtPos(20);
        list.display();

    }

}
