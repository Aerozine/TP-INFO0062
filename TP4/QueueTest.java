public class QueueTest {
    public static void main(String[] args) {
        // Create a Queue object
        Queue queue = new Queue();

        // Test: Check if the queue is empty initially
        System.out.println("Initial Queue size: " + queue.size()); // Expected: 0

        // Test: Add elements to the queue
        queue.put(10);
        queue.put(20);
        queue.put(30);

        // Test: Check size after adding elements
        System.out.println("Queue size after adding elements: " + queue.size()); // Expected: 3

        // Test: Check the first element (without removing it)
        System.out.println("First element in the queue: " + queue.first()); // Expected: 10

        // Test: Remove elements from the queue and check size after each removal
        System.out.println("Removed element: " + queue.get()); // Expected: 10
        System.out.println("Queue size after first get(): " + queue.size()); // Expected: 2

        System.out.println("Removed element: " + queue.get()); // Expected: 20
        System.out.println("Queue size after second get(): " + queue.size()); // Expected: 1

        System.out.println("Removed element: " + queue.get()); // Expected: 30
        System.out.println("Queue size after third get(): " + queue.size()); // Expected: 0
    }
}
