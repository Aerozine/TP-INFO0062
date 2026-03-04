public class Queue {
    private Node head, tail;
    private int size;

    public Queue() {
        head = tail = null;
        size = 0;
    }

    public void put(int value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public int get() {
        if (head == null) throw new IllegalStateException("Queue is empty.");
        int value = head.getValue();
        head = head.getNext();
        if (head == null) tail = null;
        size--;
        return value;
    }

    public int first() {
        if (head == null) throw new IllegalStateException("Queue is empty.");
        return head.getValue();
    }

    public int size() {
        return size;
    }
}
