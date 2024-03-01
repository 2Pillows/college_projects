import java.util.Scanner;

/**
 * Main class that will handle operator data input and when an order is added or
 * removed, the program will update the Order Class and Display Class.
 * The user will be presented a menu to add a order, remove a order and display
 * the order list from the queue.
 */
public class Main {
    public static void main(String[] args) {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Queue to store orders
        OrderQueue orderQueue = new OrderQueue();

        // Loop to continuously display menu
        boolean continueOrdering = true;
        while (continueOrdering) {
            displayMenu();
            // Recieve order and check if should continue displaying menu
            continueOrdering = recieveOrder(scanner, orderQueue);
        }

        // Close the scanner
        scanner.close();
    }

    /**
     * Displays menu order number and total cost
     */
    private static void displayMenu() {
        System.out.println("Order Number 1: Burger for $10");
        System.out.println("Order Number 2: Sandwitch for $20");
        System.out.println("Order Number 3: Cereal for $30");
        System.out.println("Order Number 4: Ice Cream for $40");
        System.out.println("Order Number 5: Steak for $50");
    }

    /**
     * Collects user input for their last name and desired order number
     * 
     * @param scanner    Scanner to collect user input
     * @param orderQueue Order queue of all previous customer orders
     * @return True or false if should continue displaying menu
     */
    private static boolean recieveOrder(Scanner scanner, OrderQueue orderQueue) {
        // Boolean for checking if should continue to display menu
        boolean continueOrdering = true;

        // Boolean if order is to add or remove
        boolean addOrder = true;

        // Define user input options with placeholder values
        String lastName = "";
        int orderNumber = -1;

        // Ensure user input is valid
        while (true) {
            // Prompt user for input
            System.out.print(
                    "Enter a valid order 'last name, order number' to add, 'last name, order number, remove' to remove, or 'exit' to quit: ");
            // Collect user input
            String userOrder = scanner.nextLine();

            // User wants to exit program. Break all while loops
            if (userOrder.equalsIgnoreCase("exit")) {
                continueOrdering = false;
                break;
            }

            // Ensure user input is a valid length
            String[] orderDetails = userOrder.split(",");
            if (orderDetails.length != 2 && orderDetails.length != 3) {
                System.out.println(
                        "Invalid input format. Please enter as 'last name, order number' to add, 'last name, order number, remove' to remove, or 'exit' to quit.");
            } else {
                // Begin collecting data from user input

                // Collect last name
                lastName = orderDetails[0].trim();

                // Collect order number
                try {
                    orderNumber = Integer.parseInt(orderDetails[1].trim());
                    if (orderNumber < 1 || orderNumber > 5) {
                        throw new NumberFormatException();
                    } else {
                        // Valid order with last name and order recieved

                        // Check if user wants to add or remove order
                        if (orderDetails.length == 3 && orderDetails[2].trim().equalsIgnoreCase("remove")) {
                            addOrder = false;
                            System.out
                                    .println("Remove order - Last Name: " + lastName + ", Order Number: "
                                            + orderNumber);
                        } else {
                            System.out
                                    .println("Order received - Last Name: " + lastName + ", Order Number: "
                                            + orderNumber);
                        }

                        break; // Exit the loop
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid order number. Please enter a number between 1 and 5.");
                }
            }

        }

        // Add or remove order to queue
        if (continueOrdering && addOrder) {
            orderQueue.enqueue(createOrder(lastName, orderNumber));
        } else if (continueOrdering && !addOrder) {
            orderQueue.dequeue(createOrder(lastName, orderNumber));
        }

        // Return boolean to control outer while loop
        return continueOrdering;
    }

    /**
     * Helper to create OrderData from user last name and order number
     * 
     * @param lastName    Order's last name
     * @param orderNumber Order's number
     * @return OrderData with (lastName, orderNumber, totalCost)
     */
    private static OrderData createOrder(String lastName, int orderNumber) {
        // Determine toatlCost of orderNumber
        double totalCost = orderNumber * 10;
        // Alternative total cost calculation
        // switch (orderNumber) {}

        // Create and return OrderData object
        OrderData newOrder = new OrderData(lastName, orderNumber, totalCost);
        return newOrder;
    }
}
