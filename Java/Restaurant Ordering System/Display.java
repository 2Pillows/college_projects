import java.util.Queue;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Display class that will store a copy of the order queue in two arrays. Each
 * array will contain the order list but one will be sorted by name and the
 * other sorted by order number. When a order is taken and stored in the Order
 * Class the program will update the
 * Display class arrays automatically and sort them in descending order using
 * quick sort and outputs the the contents to the console upon each entry of new
 * data.
 */
public class Display {

    // Nothing to initialize with default constructor
    // public Display() {
    // }

    /**
     * Sorts given queue by name and order number.
     * Displays both sorted queues
     * 
     * @param orderQueue Queue of orders
     */
    public void sortQueue(Queue<OrderData> orderQueue) {
        // Create array from queue
        OrderData[] orderArray = orderQueue.toArray(new OrderData[orderQueue.size()]);

        // Comparator for lastName in OrderData
        Comparator<OrderData> nameComparator = Comparator.comparing(OrderData::getLastName);
        // Sort orderQueue by lastName and store in ordersByName
        OrderData[] ordersByName = quickSort(orderArray, 0, orderArray.length - 1, nameComparator);

        // Comparator for orderNumber in OrderData
        Comparator<OrderData> orderNumberComparator = Comparator.comparingInt(OrderData::getOrderNumber);
        // Sort orderQueue by orderNumber and store in ordersByOrderNumber
        OrderData[] ordersByOrderNumber = quickSort(orderArray, 0, orderArray.length - 1, orderNumberComparator);

        // Display both sorted arrays
        displaySortedQueues(ordersByName, ordersByOrderNumber);
    }

    /**
     * Helper function to sort arrays using quick sort
     * 
     * @param arr        Array to be sorted
     * @param left       Leftmost index
     * @param right      Rightmost index
     * @param comparator Comparator to get value from array to be sorted
     * @return Sorted array
     */
    private OrderData[] quickSort(OrderData[] arr, int left, int right, Comparator<OrderData> comparator) {
        // Create copy of arr to sort and return
        OrderData[] sortedArr = Arrays.copyOf(arr, arr.length);

        // Quick sort new arr
        if (left < right) {
            int pivotIndex = partition(sortedArr, left, right, comparator);
            quickSort(sortedArr, left, pivotIndex - 1, comparator);
            quickSort(sortedArr, pivotIndex + 1, right, comparator);
        }
        return sortedArr;
    }

    /**
     * Helper function for quickSort
     * 
     * @param arr        Array to be sorted
     * @param left       Leftmost index
     * @param right      Rightmost index
     * @param comparator Comparator to get value from array to be sorted
     * @return Sorted array
     */
    private int partition(OrderData[] arr, int left, int right, Comparator<OrderData> comparator) {
        OrderData pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            // If arr[j] >= pivot
            if (comparator.compare(arr[j], pivot) >= 0) {
                i++;
                // Swap arr[i] with arr[j]
                swap(arr, i, j);
            }
        }

        // Swap arr[i + 1] and arr[right]
        swap(arr, i + 1, right);

        return i + 1;
    }

    /**
     * Helper function for partition
     * 
     * @param arr Array storing elements
     * @param i   First index to swap
     * @param j   Second index to swap
     */
    private void swap(OrderData[] arr, int i, int j) {
        OrderData temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Displays both given arrays
     * 
     * @param ordersByName        Array sorted by name to be displayed
     * @param ordersByOrderNumber Array sorted by order number to be displayed
     */
    private void displaySortedQueues(OrderData[] ordersByName, OrderData[] ordersByOrderNumber) {
        System.out.println("-----Order Data Sorted-----");
        System.out.println("Orders by Last Name: ");
        for (OrderData orderData : ordersByName) {
            System.out.println("\t" + orderData);
        }
        System.out.println("");
        System.out.println("Orders by Order Number: ");
        for (OrderData orderData : ordersByOrderNumber) {
            System.out.println("\t" + orderData);
        }
        System.out.println("\n");
    }
}
