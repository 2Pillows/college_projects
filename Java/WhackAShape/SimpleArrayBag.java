/**
 * 
 */
package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * Creates a ArrayBag that will store T objects of a 
 * total length of 25. Includes method to add, get size,
 * test if empty, pick a random object, and remove.
 * 
 * The SimpleArrayBag class used a library from VT in its Build Path which is why it won't compile.
 * 
 * @author henrysmith
 * @version Oct 4, 2020
 * @param <T> Any Object that will be used in the bag
 */

public class SimpleArrayBag<T> implements SimpleBagInterface<T> {

    /**
     * Creates the field T[] bag, length of bag,
     * and number of entries.
     */
    private T[] bag;
    private static final int MAX = 25;
    private int numberOfEntries;

    /**
     * Constructor that instantiates the fields 
     * above
     */
    public SimpleArrayBag() {
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[]) new Object[MAX];
        bag = tempbag;
        numberOfEntries = 0;
    }

    /**
     * Will add an object T to the array. If 
     * array is full or object T is null return false.
     */
    @Override
    public boolean add(T anEntry) {
        if (anEntry == null) {
            return false;
        }
        if (numberOfEntries > 24) {
            return false;
        }
        bag[numberOfEntries] = anEntry;
        numberOfEntries++;
        return true;
    }

    /**
     * Will return number of objects in array
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**
     * Will return true or false if array
     * is empty.
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Will return a random Object from array bag. 
     * If bag is empty return null;
     */
    @Override
    public T pick() {     
        if (isEmpty()) {
            return null;
        }
        TestableRandom generator = new TestableRandom(); 
        int index = generator.nextInt(numberOfEntries);

        return bag[index];
    }

    /**
     * Will remove specified object from array. If object
     * is null return false and if it isn't found in the
     * array return false;
     */
    @Override
    public boolean remove(T anEntry) {
        if (anEntry == null) {
            return false;
        }
        if (this.getIndexOf(anEntry) == -1) {
            return false;
        }
        bag[this.getIndexOf(anEntry)] = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;

        return true;
    }

    /**
     * Returns the index of anEntry inside
     * the array bag.
     * @param anEntry T Object to be found in array
     * @return the int index of where the object
     * is in the array.
     */
    private int getIndexOf(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return i;
            }
        }
        return -1;
    }

}
