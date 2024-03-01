/**
 * 
 */
package game;

/**
 * Test method for SimpleLinkedBag
 * 
 * The SimpleLinkedBagTest class used a library from VT in its Build Path which
 * is why it won't compile.
 * 
 */
public class SimpleLinkedBagTest extends student.TestCase {

    /**
     * Creates the fields to test SimpleLinkedBag
     */
    private SimpleLinkedBag<String> bag = new SimpleLinkedBag<String>();
    private SimpleLinkedBag<String> emptyBag = new SimpleLinkedBag<String>();

    /**
     * Instantiates bag with three objects.
     */
    public void setUp() {
        bag.add("Animal");
        bag.add("Bat");
        bag.add("Cat");
    }

    /**
     * Test method for add. Returns false if
     * object to be added is null.
     */
    public void testAdd() {
        assertTrue(bag.add("Animal"));
        assertFalse(bag.add(null));
    }

    /**
     * Test method for getCurrentSize.
     */
    public void testGetCurrentSize() {
        assertEquals(3, bag.getCurrentSize());
        assertEquals(0, emptyBag.getCurrentSize());
    }

    /**
     * Test method for isEmpty.
     */
    public void testIsEmpty() {
        assertTrue(emptyBag.isEmpty());
        assertFalse(bag.isEmpty());
    }

    /**
     * Test method for pick. Gets a random object from bag.
     * Returns null if bag is empty.
     */
    public void testPick() {
        assertNull(emptyBag.pick());
        for (int i = 0; i < bag.getCurrentSize(); i++) {
            String rndmString = bag.pick();
            assertTrue(rndmString.equals("Animal")
                    || rndmString.equals("Bat")
                    || rndmString.equals("Cat"));
            bag.remove(rndmString);
        }
    }

    /**
     * Test method for remove. Returns false if object to
     * be removed is null or not in bag.
     */
    public void testRemove() {
        assertTrue(bag.remove("Cat"));
        assertTrue(bag.remove("Animal"));
        assertFalse(bag.remove(null));
        assertFalse(bag.remove("Dog"));
        assertEquals("Bat", bag.pick());
    }
}
