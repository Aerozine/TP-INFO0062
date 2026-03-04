public class Stack {
    private Node top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public int pop() {
        if (top == null) throw new IllegalStateException("Stack is empty.");
        int value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }

    public int peek() {
        if (top == null) throw new IllegalStateException("Stack is empty.");
        return top.getValue();
    }

    public int size() {
        return size;
    }
}
