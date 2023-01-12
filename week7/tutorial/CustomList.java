import java.util.ArrayList;

//custom linkedList from scratch
public class CustomList {
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
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    void insertLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            insertFirst(value);
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    void removeAll() {
        while (head != null) {
            head = null;
        }
        size = 0;
    }

    void removeFirst() {
        head = head.next;
        size--;
    }

    void removeLast() {
        Node temp = head;
        for (int i = 1; i < size - 1; i++) {
            temp = temp.next;
        }
        tail = null;
        temp.next = null;
        size--;
    }

    void remove(int index) {
        if(index <=0){
            removeFirst();
            return;
        }
        if(index > size){
            removeLast();
            return;
        }
        Node temp = head;
        Node temp2;
        for (int i = 1; i < index - 1; i++) {
            temp = temp.next;
        }
        temp2 = temp.next;
        temp.next = temp2.next;
        temp2 = null;
        size--;
    }

    void replace(int value, int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.value = value;
    }

    void insert(int value, int index) {
        if (index >= size) {
            insertLast(value);
            return;
        }
        if (index == 0 || head == null || tail == null) {
            insertFirst(value);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index - 1; i++) {
            temp = temp.next;
        }
        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    void display() {
        Node temp = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while (temp != null) {
            arr.add(temp.value);
            temp = temp.next;
        }
        System.out.println(arr);
    }

    void size() {
        System.out.println(size);
    }
}