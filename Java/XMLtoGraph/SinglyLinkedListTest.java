
package xmltograph;

import java.util.Iterator;
import java.util.NoSuchElementException;

import xmltograph.SinglyLinkedList.Node;

/**
 * Test class for SinglyLinkedList
 * 
 */
public class SinglyLinkedListTest extends student.TestCase {

    // ~ Instance/static variables .............................................

    private SinglyLinkedList<String> list;
    private SinglyLinkedList<String> same;
    private SinglyLinkedList<String> difItems;
    private SinglyLinkedList<String> difSize;
    private SinglyLinkedList<String> empty;
    private String difClass;
    private Node<String> node;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Instantiates the fields above
     */
    public void setUp() {
        list = new SinglyLinkedList<String>();
        list.add("Animal");
        list.add("Bear");
        list.add("Cat");

        same = new SinglyLinkedList<String>();
        same.add("Animal");
        same.add("Bear");
        same.add("Cat");

        difItems = new SinglyLinkedList<String>();
        difItems.add("Adam");
        difItems.add("Ben");
        difItems.add("Cath");

        difSize = new SinglyLinkedList<String>();
        difSize.add("Animal");
        difSize.add("Bear");
        difSize.add("Cat");
        difSize.add("Dog");

        empty = new SinglyLinkedList<String>();

        difClass = "Hello";

        node = new Node<String>("Hello");
    }

    // ~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Testing the setNext method
     */
    public void testSetNext() {
        node.setNext(new Node<String>("Goodbye"));
        node = node.next();
        assertEquals("Goodbye", node.getData());
    }

    // ----------------------------------------------------------
    /**
     * Testing the next method
     */
    public void testNext() {
        node.setNext(new Node<String>("Goodbye"));
        node = node.next();
        assertEquals("Goodbye", node.getData());
    }

    // ----------------------------------------------------------
    /**
     * Testing the getData method
     */
    public void testGetData() {
        assertEquals("Hello", node.getData());
    }

    // ----------------------------------------------------------
    /**
     * Testing the getter for size
     */
    public void testSize() {
        assertEquals(3, list.size());
    }

    // ----------------------------------------------------------
    /**
     * Testing the add method
     */
    public void testAdd() {
        // Testing if the adding null object
        Exception errorInAdd = null;
        try {
            list.add(null);
        } catch (Exception exception) {
            errorInAdd = exception;
        }
        assertTrue(errorInAdd instanceof IllegalArgumentException);

        empty.add("Animal");
        assertEquals("{Animal}", empty.toString());

        list.add("Hello");
        assertEquals("{Animal, Bear, Cat, Hello}", list.toString());
    }

    // ----------------------------------------------------------
    /**
     * Testing the add method with only one parameter.
     */
    public void testAddEnd() {
        // Testing if the adding null object
        Exception errorInAdd = null;
        try {
            list.add(null);
        } catch (Exception exception) {
            errorInAdd = exception;
        }
        assertTrue(errorInAdd instanceof IllegalArgumentException);

        empty.add("Hello");
        assertEquals("{Hello}", empty.toString());

        list.add("Dog");
        assertEquals("{Animal, Bear, Cat, Dog}", list.toString());
    }

    // ----------------------------------------------------------
    /**
     * Testing the remove method
     */
    public void testRemove() {
        assertTrue(list.remove(2));
        assertFalse(list.remove(-1));
    }

    // ----------------------------------------------------------
    /**
     * Testing the isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(list.isEmpty());
    }

    // ----------------------------------------------------------
    /**
     * Testing the get method
     */
    public void testGet() {
        // Index too small
        Exception errorInAdd = null;
        try {
            list.get(-1);
        } catch (Exception exception) {
            errorInAdd = exception;
        }
        assertTrue(errorInAdd instanceof IndexOutOfBoundsException);

        // Index too large
        try {
            list.get(10);
        } catch (Exception exception) {
            errorInAdd = exception;
        }
        assertTrue(errorInAdd instanceof IndexOutOfBoundsException);

        // Empty list
        try {
            empty.get(0);
        } catch (Exception exception) {
            errorInAdd = exception;
        }
        assertTrue(errorInAdd instanceof IndexOutOfBoundsException);

        // Normal list get testing
        assertEquals("Animal", list.get(0));
        assertEquals("Bear", list.get(1));
        assertEquals("Cat", list.get(2));
    }

    // ----------------------------------------------------------
    /**
     * Testing the toString method
     */
    public void testToString() {
        assertEquals("{Animal, Bear, Cat}", list.toString());
        assertEquals("{}", empty.toString());
    }

    // ----------------------------------------------------------
    /**
     * Testing the Equals method
     */
    public void testEquals() {
        assertTrue(list.equals(list));
        assertFalse(list.equals(difClass));

        assertTrue(list.equals(same));
        assertFalse(list.equals(difItems));
        assertFalse(list.equals(difSize));
        assertFalse(list.equals(empty));

        empty = null;
        assertFalse(list.equals(empty));
    }

    // ----------------------------------------------------------
    /**
     * Testing the Equals method
     */
    public void testIterator() {
        Iterator<String> iter = empty.iterator();
        Exception e = null;
        try {
            iter.next();
        } catch (Exception ex) {
            e = ex;
        }
        assertTrue(e instanceof NoSuchElementException);
    }
}
