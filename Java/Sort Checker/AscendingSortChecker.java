import java.util.Comparator;

/**
 * Main class to check if any given array is in ascending order
 */
public class AscendingSortChecker {

    /**
     * Checks if a given array is sorted using given comparator
     * 
     * @param <T>        Type of object in array
     * @param array      Array containg objects
     * @param comparator Comparator to check objects in array
     * @return Boolean true or false if sorted in ascending order or not
     */
    public <T> boolean isSorted(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            if (comparator.compare(array[i], array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}