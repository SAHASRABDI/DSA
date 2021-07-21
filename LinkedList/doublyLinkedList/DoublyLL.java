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
        list.insertStart(20);
        // list.display();
        list.insertStart(30);
        list.insertStart(40);
        list.display();

    }

}
