import java.util.ArrayList;

public class Queue {
    ArrayList<Integer> queue = new ArrayList<>();

    void enqueue(int value) {
        if (queue.size() == 0) {
            queue.add(value);
            return;
        }
        queue.add(0, value);
    }

    int dequeue() {
        int temp = queue.get(queue.size() - 1);
        queue.remove(queue.size() - 1);
        return temp;
    }
    int peek(){
        return queue.get(queue.size() - 1);
    }
    void display() {
        System.out.println(queue);
    }
}
