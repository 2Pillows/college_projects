package xmltograph;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Creates SinglyLinkedList of any Object.
 * 
 * @param <T> Any object stored inside the a singly linked list
 */
public class SinglyLinkedList<T> {

    // ~ Instance/static variables .............................................

    private Node<T> head;
    private int size;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Initializes head of SinglyLinkedList and sets size to 0.
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    // ~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Getter for number of objects in list.
     * 
     * @return the number of elements
     */
    public int size() {
        return size;
    }

    // ----------------------------------------------------------
    /**
     * Adds the object to the end of the list.
     * 
     * @precondition obj cannot be null
     * @param obj the object to add
     * @throws IllegalArgumentException if obj is null
     */
    public void add(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<T> current = head;

        if (isEmpty()) {
            head = new Node<T>(obj);
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<T>(obj));
        }
        size++;
    }

    // ----------------------------------------------------------
    /**
     * Adds the object at specified index.
     * 
     * @precondition obj cannot be null
     * @param index Where the obj will be added
     * @param obj   The item to be added
     */
    public void add(int index, T obj) {
        Node<T> current = head;

        if (index == 0) {
            Node<T> newNode = new Node<T>(obj);
            newNode.setNext(head);
            head = newNode;
        } else {
            int currentIndex = 0;
            while (current != null) {
                if ((currentIndex + 1) == index) {
                    Node<T> nextNext = current.next;
                    Node<T> newNode = new Node<T>(obj);
                    current.setNext(newNode);
                    newNode.setNext(nextNext);
                }
                current = current.next();
                currentIndex++;
            }
        }
        size++;
    }

    // ----------------------------------------------------------
    /**
     * Removes item at specified index.
     * 
     * @param index The index to be removed
     * @return True or false if item was removed
     */
    public boolean remove(int index) {
        Node<T> current = head;
        int currentIndex = 0;

        while (current.next != null) {
            if ((currentIndex + 1) == index) {
                Node<T> newNext = current.next.next;
                current.setNext(newNext);
                size--;
                return true;
            }
            current = current.next;
            currentIndex++;
        }
        return false;
    }

    // ----------------------------------------------------------
    /**
     * Checks if the array is empty
     * 
     * @return True if the array is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    // ----------------------------------------------------------
    /**
     * Gets the object at the given position
     * 
     * @param index where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException if no node at the given index
     */
    public T get(int index) {
        Node<T> current = head;
        int currentIndex = 0;
        T data = null;

        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        if (data == null) {
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }

    // ----------------------------------------------------------
    /**
     * Returns a string representation of the list if a list contains A, B, and
     * C, the following should be returned "{A, B, C}"
     * 
     * @return a string representing the list
     */
    public String toString() {
        String result = "{";

        Node<T> current = head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }

    // ----------------------------------------------------------
    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     * 
     * @param obj Object that is compared against this
     * @return a boolean of whether two lists have the same contents,
     *         item per item and in the same order
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            SinglyLinkedList<T> other = ((SinglyLinkedList<T>) obj);
            if (other.size() == this.size()) {
                Node<T> current = head;
                Node<T> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }

    /**
     * Creates an iterator for SinglyLinkedList.
     *
     * @return new Iterator for Linked List
     */
    public Iterator<T> iterator() {
        return new ListIterator<T>();
    }

    // ~ Inner Class ..........................................................

    /**
     * Inner Iterator class that traverses SinglyLinkedLists.
     * 
     * @param <E> The type of list that will be iterated.
     */
    private class ListIterator<E> implements Iterator<T> {

        // ~ Instance/static variables .......................................

        private int index;
        private T removeData;

        // ~ Constructors ....................................................

        /**
         * Sets index to 0 and removeData to null.
         */
        public ListIterator() {
            index = 0;
            removeData = null;
        }

        // ~ Public Methods .....................................................

        // ----------------------------------------------------------
        /**
         * Checks if there are more elements in the list.
         * 
         * @return True if list has a next item.
         */
        @Override
        public boolean hasNext() {
            return index < size();
        }

        // ----------------------------------------------------------
        /**
         * Increments iterator and returns last item.
         * 
         * @return Last value skipped by iterator
         * @throws NoSuchElementException
         *                                if there are no nodes left in the list.
         */
        @Override
        public T next() {
            if (!(hasNext())) {
                throw new NoSuchElementException("No nodes left in list");
            }
            removeData = get(index++);
            return removeData;
        }
    }

    // ~ Inner Class ..........................................................

    /**
     * Inner Node Class that stores data in Node and next Node
     * 
     * @param <D> Item stored inside Nodes
     */
    public static class Node<D> {

        // ~ Instance/static variables .......................................
        private D data;
        private Node<D> next;

        // ~ Constructors ....................................................

        // ----------------------------------------------------------
        /**
         * Instantiates data of Node with parameter.
         * 
         * @param d The data to put inside the node.
         */
        public Node(D d) {
            data = d;
        }

        // ~ Public Methods .....................................................

        // ----------------------------------------------------------
        /**
         * Sets the node after current Node.
         * 
         * @param n The node after this current Node.
         */
        public void setNext(Node<D> n) {
            next = n;
        }

        // ----------------------------------------------------------
        /**
         * Getter for next Node.
         * 
         * @return The next Node.
         */
        public Node<D> next() {
            return next;
        }

        // ----------------------------------------------------------
        /**
         * Getter for data in current Node.
         * 
         * @return The data in the node.
         */
        public D getData() {
            return data;
        }
    }
}
