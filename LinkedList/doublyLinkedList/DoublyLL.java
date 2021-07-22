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

    // deletion function
    public Node deleteNode(int delVal) {
        // we can also not return head cause head is a class variable and it changes for
        // entire class
        // if we had used static variables and declared the head in the main method we
        // had to return the head
        // if no node
        if (head == null) {
            System.out.println("No node to delete");
            return (head);
        } else {
            // the temp and prev
            Node temp = head;
            Node previous = null;
            // if head node has to be deleted and there is only the head node
            if (temp.next == null && temp.data == delVal) {
                head = null;
                return (head);
            }

            // head node to be deleted and but not the on;ly node
            if (temp.next != null && temp.data == delVal) {
                head = temp.next;
                temp.next.prev = null;
                return (head);
            }
            // traverse until found
            while (temp != null && temp.data != delVal) {
                previous = temp;
                temp = temp.next;
            }
            // if value not present then we reach temp==null
            if (temp == null) {
                System.out.println("Value Not found");
                return (head);
            }
            previous.next = temp.next;
            // if last node then temp.next.prevoius wont be there
            if (temp.next == null) {
                return head;
            }
            temp.next.prev = previous;
            return (head);

        }
    }

    public void deleteAtPos(int pos) {
        int size = calcSize(head);

        if (pos < 1 || pos > size) {
            System.out.println("Invalid position");

        } else {
            Node temp = head;
            // Node previous=null;
            // if only 1 node
            if (pos == 1 && temp.next == null) {
                head = null;
                System.out.println("Value at position 1 which is " + temp.data + " is deleted");
                return;

            }
            if (pos == 1 && temp.next != null) {
                head = temp.next;
                temp.next.prev = null;
                System.out.println("Value at position 1 which is " + temp.data + " is deleted");
                return;
            }

            // traverse until found
            for (int i = 0; i < pos - 2; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next.next == null) {
                System.out.println("Deleted");
                return;
            }
            temp.next.next.prev = temp;
            System.out.println("Value deleted");

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
        list.deleteNode(50);// not present starting node
        list.insertStart(20);
        // list.display();
        list.deleteNode(20);// delete head node ony 1 node
        list.insertStart(30);
        list.insertStart(40);
        list.insertEnd(50);
        list.deleteNode(40);// delete headNode but others present
        list.insertPos(1, 3);
        list.insertPos(5, 100);
        list.deleteNode(3);// delete random node
        list.deleteNode(50);// last node
        list.deleteNode(90);// delete node not present
        // 30
        list.display();
        list.deleteAtPos(1);

    }

}
