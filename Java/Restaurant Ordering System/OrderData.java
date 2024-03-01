
/**
 * Helper class for OrderQueue
 * Stored order details for last name, order number, and total cost
 */
public class OrderData {
    // Private variables that store order data
    private String lastName;
    private int orderNumber;
    private double totalCost;

    // Default constructor to set class variables
    public OrderData(String lastName, int orderNumber, double totalCost) {
        this.lastName = lastName;
        this.orderNumber = orderNumber;
        this.totalCost = totalCost;
    }

    // Getters for order details
    public String getLastName() {
        return lastName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public double getTotalCost() {
        return totalCost;
    }

    // Override toString() to properly display OrderData
    @Override
    public String toString() {
        return lastName + ", " + orderNumber + ", $" + totalCost;
    }

    // Override equals to ensure dequeue can find OrderData to remove
    @Override
    public boolean equals(Object obj) {
        // Equal if both objects are same object
        if (this == obj) {
            return true;
        }

        // Not euqal if obj is null or not in same class
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Convert obj to OrderData object
        OrderData other = (OrderData) obj;

        // Compare lastName, orderNumber, and totalCost variables
        return lastName.equals(other.lastName) && orderNumber == other.orderNumber && totalCost == other.totalCost;
    }

}
