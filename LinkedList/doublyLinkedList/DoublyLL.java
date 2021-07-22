class Node {
    int data;
    Node next;
    Node prev;

    // contructor
    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

class DoublyLL {

    // ariable
    Node head = null;

    // function
    public Node insertStart(int val) {
        // create a new node
        Node newNode = new Node(val);
        // even if head==null then the next of the new node will be null
        newNode.next = head;

        // if atleast 1 node
        if (head != null) {
            head.prev = newNode;

        }

        head = newNode;

        return (head);
    }

    public void insertEnd(int val) {
        // create a node
        Node newNode = new Node(val);
        // 1st Node is the data type 2nd Node() is the class name which calls the
        // constructor of class Node
        // for traversal

        // condition 1:if only no node
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        // condition 2:if atleast 1 node
        while (temp.next != null) {
            temp = temp.next;

        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public int calcSize(Node node) {
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return (size);

    }

    public void insertPos(int pos, int val) {
        int size = calcSize(head);
        // check if invalid pos
        if (pos < 1 || pos > size) {
            System.out.println(pos + " Invalid position ");
        } else {
            // create a new node
            Node newNode = new Node(val);
            // as traversal needed so keep a temp value
            Node temp = head;

            while (--pos > 0) {
                temp = temp.next;
            }
            if (temp.next == null) {
                temp.next = newNode;
                newNode.prev = temp;
            } else {
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next.prev = newNode;
                temp.next = newNode;
            }

        }

    }

    public void display() {
        Node end = null;
        Node node = head;
        System.out.println("List in the forward direction");
        while (node != null) {
            System.out.print(node.data + " ");
            end = node;// the the node until it turns null last node
            node = node.next;
        }
        System.out.println("List in backward direction");

        while (end != null) {

            System.out.print(end.data + " ");
            end = end.prev;

        }
        System.out.println();
    }

    // main method
    public static void main(String args[]) {
        DoublyLL list = new DoublyLL();
        // list.insertEnd(2);// no node first
        list.insertStart(20);
        // list.display();
        list.insertStart(30);
        list.insertStart(40);
        list.insertEnd(50);
        list.insertPos(1, 3);
        list.insertPos(5, 100);
        list.display();

    }

}
