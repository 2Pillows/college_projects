/**
 * 
 */
package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * The stack of Towers will be made and managed in this class.
 * 
 * The LinkedStack class used a library from VT in its Build Path which is why
 * it won't compile.
 * 
 * @param <T> Any object to be used in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {

    /**
     * Creates fields of the first Node in the stack
     * and the number of items in the stack.
     */
    private Node<T> topNode;
    private int size;

    /**
     * Constructor that instantiates the first node to
     * be null.
     */
    public LinkedStack() {
        topNode = null;
    }

    /**
     * Getter for the number of items
     * 
     * @return The number of items
     */
    public int size() {
        return size;
    }

    /**
     * Returns whether or not the stack is empty
     * 
     * @return True or False if the stack is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Looks into the array and gives first item without removing
     * 
     * @return The item at the top of the stack
     */
    public T peek() {
        // Cannot return an item if the stack is empty
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }

    /**
     * Adds an item to the top of the stack and increments size
     * 
     * @param newEntry The entry to be added to the stack
     */
    public void push(T newEntry) {
        // Cannot add a null item
        if (newEntry == null) {
            return;
        }

        // Creates node with newEntry in front and
        // previous nodes after
        Node<T> newNode = new Node<T>(newEntry, topNode);
        topNode = newNode;
        size++;
    }

    /**
     * Removes and returns the item at the top of stack and
     * decreases size.
     * 
     * @return item at the top of the stack
     */
    public T pop() {
        // If the stack is empty cannot return or remove an item
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // Stores data of node in T and moves head
        // to the next node, removing the current node
        T data = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return data;
    }

    /**
     * Takes the stack and turns into an String array
     * 
     * @return The string representation of items in the stack
     */
    public String toString() {
        // String array to store widths
        StringBuilder nodeStr = new StringBuilder();
        nodeStr.append("[");
        Node<T> temp = topNode;

        // While the node isn't empty
        while (temp != null) {
            // After first input put commas between widths
            if (nodeStr.length() > 1) {
                nodeStr.append(", ");
            }
            // Add the widths and increment temp to next
            nodeStr.append(temp.getData());
            temp = temp.getNextNode();
        }
        // Ending array with bracket
        nodeStr.append("]");
        return nodeStr.toString();
    }

    /**
     * Removes all items from the stack
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void clear() {
        // Creates new empty node
        Node<T> empty = new Node(null);
        // Increments to next so the node is empty
        topNode = empty.getNextNode();
        size = 0;
    }
}

/**
 * Creates single linked nodes
 * 
 * @author henrysmith
 * @version Oct 19, 2020
 * @param <T> Any object to be used in the nodes
 */
class Node<T> {

    /**
     * Creating fields to track nodes
     * and create the single linked chain
     */
    private T data;
    private Node<T> next;

    /**
     * If constructor is called with one
     * data value then set node to said data
     * 
     * @param dataPortion Value in current Node
     */
    public Node(T dataPortion) {
        this(dataPortion, null);
    }

    /**
     * If constructor is called with two objets
     * then set the data and next to said objects
     * 
     * @param dataPortion Value in current Node
     * @param nextNode    the next Node in chain
     */
    public Node(T dataPortion, Node<T> nextNode) {
        data = dataPortion;
        next = nextNode;
    }

    /**
     * Getter for next
     * 
     * @return return next Node
     */
    public Node<T> getNextNode() {
        return next;
    }

    /**
     * Setter for next Node;
     * 
     * @param nextNode The next Node in the chain
     */
    public void setNextNode(Node<T> nextNode) {
        next = nextNode;
    }

    /**
     * Getter for data
     * 
     * @return The value in current Node
     */
    public T getData() {
        return data;
    }
}