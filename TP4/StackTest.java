public class StackTest {
    public static void main(String[] args) {
        // Create a Stack object
        Stack stack = new Stack();

        // Test: Check if the stack is empty initially
        System.out.println("Initial Stack size: " + stack.size()); // Expected: 0

        // Test: Add elements to the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Test: Check size after pushing elements
        System.out.println("Stack size after pushing elements: " + stack.size()); // Expected: 3

        // Test: Check the top element (without removing it)
        System.out.println("Top element in the stack: " + stack.peek()); // Expected: 30

        // Test: Pop elements from the stack and check size after each pop
        System.out.println("Popped element: " + stack.pop()); // Expected: 30
        System.out.println("Stack size after first pop: " + stack.size()); // Expected: 2

        System.out.println("Popped element: " + stack.pop()); // Expected: 20
        System.out.println("Stack size after second pop: " + stack.size()); // Expected: 1

        System.out.println("Popped element: " + stack.pop()); // Expected: 10
        System.out.println("Stack size after third pop: " + stack.size()); // Expected: 0
  }
}
