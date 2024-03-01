import java.util.LinkedList;
import java.util.Queue;

/**
 * OrderQueue class that uses a queue to hold the orders in the order they were
 * taken.
 * The queue should contain the customer last name, order number, and order
 * total cost.
 */
public class OrderQueue {
    // Queue to store OrderData
    private Queue<OrderData> orderQueue;
    // Display for sorting and displaying order queue
    private Display display;

    // Default constructor to initialize variables
    public OrderQueue() {
        orderQueue = new LinkedList<>();
        display = new Display();
    }

    // Add an order to the back of the queue and sort
    public void enqueue(OrderData order) {
        orderQueue.offer(order);
        sortAndDisplay();
    }

    // Remove order from the front of the queue and sort
    public void dequeue() {
        orderQueue.poll();
        sortAndDisplay();
    }

    // Remove specific order from the queue and sort
    public void dequeue(OrderData order) {
        orderQueue.remove(order);
        sortAndDisplay();
    }

    // Sort queue using Display's sortQueue()
    private void sortAndDisplay() {
        display.sortQueue(orderQueue);
    }
}