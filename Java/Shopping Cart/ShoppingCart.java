import java.util.ArrayList;

// Class that creates a Bag data structure to act as a shopping cart
public class ShoppingCart {

    // Iniitalizing private fields
    private ArrayList<String> myBag;
    private int numberofProducts;
    // Constant for capacity of the Bag
    private static final int Default_Capacity = 2;

    // Default constuctor to create Bag and counter of items
    public ShoppingCart() {
        myBag = new ArrayList<>();
        numberofProducts = 0;
    }

    // Method to add items to the Bag, increments numberofProducts
    public void add(String entry) {
        myBag.add(entry);
        numberofProducts += 1;
    }

    // Returnss the Bag as an array
    public Object[] toArray() {
        return myBag.toArray();
    }

    // Returns a boolean if the Bag has reached capacity
    public boolean isFull() {
        return myBag.size() == Default_Capacity;
    }
}
