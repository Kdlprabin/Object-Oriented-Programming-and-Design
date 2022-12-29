//custom linkedList from scratch
public class PrabinList {
    Node head;
    Node tail;
    int size;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;
    }

    void insertLast(int value) {
        Node node = new Node(value);
        tail = node;
        size++;
    }

    void display() {
        Node temp = head;
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.value);
            System.out.print(",");
            temp = temp.next;
        }
        System.out.print("]");
    }
}
