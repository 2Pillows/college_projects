/**
 * 
 */
package towerofhanoi;

import java.util.EmptyStackException;

/**
 * Test class for the LinkedStack class
 * 
 */
public class LinkedStackTest extends student.TestCase {

    /**
     * Field to be used in the testing methods
     */
    private LinkedStack<String> stack;
    private Node<String> node;

    /**
     * Instantiates the LinkedStack field.
     */
    public void setUp() {
        stack = new LinkedStack<String>();
        node = new Node<String>(null);
    }

    /**
     * Test method for the size getter
     */
    public void testSize() {
        assertEquals(0, stack.size());

        stack.push("Hello");
        assertEquals(1, stack.size());
    }

    /**
     * Test method for is Empty
     */
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push("Hello");
        assertFalse(stack.isEmpty());
    }

    /**
     * Test method for peek. If the sting is empty
     * cannot peek and gives Exception
     */
    public void testPeek() {
        Exception empty = null;
        try {
            stack.peek();
        } catch (Exception exception) {
            empty = exception;
        }
        assertTrue(empty instanceof EmptyStackException);
        stack.push("Hello");
        assertEquals("Hello", stack.peek());
        assertEquals(1, stack.size());
    }

    /**
     * Test method for Push. If the item to
     * be pushed is null catches Exception.
     */
    public void testPush() {
        stack.push(null);
        assertTrue(stack.isEmpty());

        stack.push("Hello");
        assertEquals("Hello", stack.peek());
        stack.push("Goodbye");
        assertEquals("Goodbye", stack.peek());
    }

    /**
     * Test method for Pop. If the stack
     * is empty catches Exception.
     */
    public void testPop() {
        Exception empty = null;
        try {
            stack.pop();
        } catch (Exception exception) {
            empty = exception;
        }
        assertTrue(empty instanceof EmptyStackException);
        stack.push("Hello");
        assertEquals("Hello", stack.pop());
        assertTrue(stack.isEmpty());

        stack.push("Hello");
        stack.push("Goodbye");
        assertEquals("Goodbye", stack.pop());
    }

    /**
     * Test method for toString. Gives string array of
     * items in the stack.
     */
    public void testToString() {
        assertEquals("[]", stack.toString());
        stack.push("Hello");
        stack.push("Goodbye");
        assertEquals("[Goodbye, Hello]", stack.toString());
    }

    /**
     * Test method for clear. Removes all items in the array.
     */
    public void testClear() {
        stack.push("Hello");
        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals("[]", stack.toString());

    }

    /**
     * Test method for the testSetNextNode method
     * in the Node class
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void testSetNextNode() {
        node.setNextNode(new Node("Hello"));
        node = node.getNextNode();
        assertEquals("Hello", node.getData());
    }
}
