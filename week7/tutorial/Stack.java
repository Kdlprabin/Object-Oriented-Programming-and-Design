import java.util.ArrayList;

public class Stack {
    ArrayList<Integer> stack = new ArrayList<Integer>();

    void push(int value) {
        stack.add(value);
    }
    int peek(){
        return stack.get(stack.size()-1);

    }
    int pop(){
        int temp = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return temp;
    }
    void display(){
        System.out.println(stack);
    }
}
