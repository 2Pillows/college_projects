/**
 * 
 */
package game;

import bag.SimpleBagInterface;
import bag.Node;
import student.TestableRandom;

/**
 * Class that creates an single linked array. Includes
 * methods for adding, removing, getting size, testing
 * if empty, and returning a random object from bag.
 * 
 * The SimpleLinkedBag class used a library from VT in its Build Path which is
 * why it won't compile.
 * 
 * @param <T> Any object that will be added to the bag
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {

    /**
     * Creates two fields: a Node<T> and
     * int to track number of entries.
     */
    private Node<T> firstNode;
    private int numberOfEntries;

    /**
     * Instantiates fields created above.
     */
    public SimpleLinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * Will add anEntry to bag. If anEntry is null
     * will return false, else adds object to bag.
     */
    @Override
    public boolean add(T newEntry) {
        if (newEntry == null) {
            return false;
        }
        Node<T> newNode = new Node<T>(newEntry, firstNode);
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    /**
     * Returns size of bag
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**
     * Returns if the bag is empty or not.
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Returns a random object from the bag.
     * If the bag is empty returns false.
     */
    @Override
    public T pick() {
        if (isEmpty()) {
            return null;
        }
        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);
        Node<T> currentNode = firstNode;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getData();
    }

    /**
     * Removes a specified object from the bag.
     * If the object to be removed is null or not
     * in the bag returns false;
     */
    @Override
    public boolean remove(T anEntry) {
        if (anEntry == null) {
            return false;
        }

        boolean result = false;
        Node<T> nodeN = getReferenceTo(anEntry);

        if (nodeN != null) {
            nodeN.setData(firstNode.getData());

            firstNode = firstNode.getNext();
            numberOfEntries--;
            result = true;
        }

        return result;
    }

    /**
     * Returns the Node that has a specified object.
     * 
     * @param anEntry Object that will be removed
     * @return Node that includes the object to be removed
     */
    private Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNext();
            }
        }

        return currentNode;
    }

}
