//import java.util.*;
//name of the program file should be the class name 

/*at this point i have multiple classes and only one have  main method
So use    javac *.java inside the directory of the program
otherwise the javac LinkedList.java (name of the program)
then jave LinkedList ( name of the class with the main method) */

class Node {
    // variables
    Node next;
    int data;

    // constructor
    // constructor has the same name as it's class and initialises the class
    // variable
    // To create a new node everytime an object is created of class Node
    Node(int x) {
        this.data = x;
        this.next = null;
    }
}

class LinkedList {
    // variables
    // the value of head remains the same within the class
    Node head = null;// declare the head and initialise with null

    public int calcSize(Node node) {
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return (size);

    }

    // The first function to insert at the start\
    public Node insertStart(int val) {
        // create a new node with the help of Node class
        Node newNode = new Node(val);
        // condition 1: Head==null(no node) or atleast 1 node
        newNode.next = head;
        head = newNode;

        return head;

    }

    public void insertLast(int val) {
        // create a node
        Node newNode = new Node(val);// the constructor is called and initialised
        // condition 1:if there are no nodes so its basically insert at start
        if (head == null) {
            head = newNode;
            return;// as no more needs to be done
        }

        // condition 2:atleast there is 1 node
        Node temp = head;// For traversal to the end

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

    }

    // insert NOT AT but AFTER a particular position
    public void insertPos(int val, int pos) {
        // check if the position given is negative or greater than the size of the list
        // find the size of ll
        int size = calcSize(head);
        if (pos < 1 || pos > size) {
            System.out.println(pos + " Invalid position ");
        } else {
            // create a new node
            Node newNode = new Node(val);
            // as traversal needed so keep a temp value
            Node temp = head;
            // we can use for loop too
            // #1->2->3->4->5->NULL
            // POS=3
            // Temp at head that is (#1)
            // --POS=2 (2)
            // --pos=1 (3)
            // --pos=0 come out od the loop
            // now temp= (3)
            // newnode (0)
            // #1->2->3->0->4->5->null
            while (--pos > 0) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;

        }

    }

    public void display() {
        Node node = head;// initialse the node to head for traversal and printing
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        // reached the last node and come out of the loop
        System.out.println();

    }

    // main method
    public static void main(String args[]) {
        // create object of LinkedList class
        LinkedList list = new LinkedList();// list is the object
        list.insertStart(20);
        list.insertStart(30);
        list.insertStart(40);
        list.insertLast(16);
        list.insertLast(17);
        list.insertLast(18);
        list.insertPos(25, 3);
        list.display();

    }
}