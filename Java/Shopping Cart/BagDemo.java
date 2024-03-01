// Testing Class for ShoppingCart
public class BagDemo {

    // Method to test add() method using isFull()
    private static void testAddl() {
        ShoppingCart shoppingCart = new ShoppingCart();
        System.out.println("Is Full = " + shoppingCart.isFull());
        shoppingCart.add("First Item");
        System.out.println("Item Added...");
        System.out.println("Is Full = " + shoppingCart.isFull());
        shoppingCart.add("Second Item");
        System.out.println("Item Added...");
        System.out.println("Is Full = " + shoppingCart.isFull());
    }

    // Method to test toArray() by displaying myBag
    private static void displayBag() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add("Apples");
        shoppingCart.add("Carrots");
        Object[] shoppingCartAry = shoppingCart.toArray();
        for (Object i : shoppingCartAry) {
            System.out.println(i);
        }

    }

    // Main method to run testing methods
    public static void main(String[] args) {
        System.out.println("Adding Items:");
        testAddl();

        System.out.println("\nShopping Cart Items:");
        displayBag();
    }
}
