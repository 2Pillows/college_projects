/**
 * 
 */
package game;

/**
 * Test method for SimpleArrayBag
 * 
 */
public class SimpleArrayBagTest extends student.TestCase {

    /**
     * Creates fields to be tested.
     */
    private SimpleArrayBag<String> array = new SimpleArrayBag<String>();
    private SimpleArrayBag<String> fullArray = new SimpleArrayBag<String>();

    /**
     * Instantiates fullArray and leaves array empty.
     */
    public void setUp() {
        for (int i = 0; i < 25; i++) {
            fullArray.add("Puppy");
        }
    }

    /**
     * Test method for add. Will add an object to array.
     * If an array is full then returns false;
     */
    public void testAdd() {
        assertTrue(array.isEmpty());
        array.add("Puppy");
        assertFalse(array.isEmpty());
        assertFalse(array.add(null));
        assertFalse(fullArray.add("Puppy"));
    }

    /**
     * Test method for getCurrentSize. Returns
     * the size of an array.
     */
    public void testGetCurrentSize() {
        assertEquals(0, array.getCurrentSize());
        array.add("Puppy");
        assertEquals(1, array.getCurrentSize());
    }

    /**
     * Test method for isEmpty. Returns whether or not
     * an array is empty.
     */
    public void testIsEmpty() {
        assertTrue(array.isEmpty());
        array.add("Puppy");
        assertFalse(array.isEmpty());
    }

    /**
     * Test method for pick. Will return null is
     * array is empty, else gets random object from bag;
     */
    public void testPick() {
        assertNull(array.pick());
        array.add("Puppy");
        assertEquals("Puppy", array.pick());
        array.add("Doggo");
        array.add("Cat");

        for (int i = 0; i < array.getCurrentSize(); i++) {
            String rndmString = array.pick();
            assertTrue(rndmString.equals("Puppy")
                    || rndmString.equals("Doggo")
                    || rndmString.equals("Cat"));
            array.remove(rndmString);
        }

    }

    /**
     * Test method for remove. Returns false if object
     * is null and if object isn't in bag.
     */
    public void testRemove() {
        assertFalse(array.remove(null));
        array.add("Puppy");
        assertTrue(array.remove("Puppy"));
        assertEquals(0, array.getCurrentSize());
        assertFalse(array.remove("Doggo"));

        array.add("A");
        array.add("B");
        array.add("C");
        array.add("D");
        assertTrue(array.remove("D"));
        assertTrue(array.remove("C"));
        assertTrue(array.remove("A"));
        assertTrue(array.remove("B"));
    }

}
