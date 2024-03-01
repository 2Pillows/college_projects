/**
 * 
 */
package towerofhanoi;

/**
 * Test class for the Tower class
 * 
 */
public class TowerTest extends student.TestCase {

    /**
     * Tower object that will be used in the test class.
     */
    private Tower left;

    /**
     * Setup method that instantiates the left tower.
     */
    public void setUp() {
        left = new Tower(Position.LEFT);
    }

    /**
     * Tests if the correct position for left tower
     * is returned.
     */
    public void testPosition() {
        assertEquals(Position.LEFT, left.position());
    }

    /**
     * Tests if a disk can be added to the left
     * tower.
     */
    public void testPush() {
        left.push(new Disk(10));
        assertEquals("[10]", left.toString());
        left.push(new Disk(8));
        assertEquals("[8, 10]", left.toString());

        // If adding a larger disk then catches an error.
        Exception illegal = null;
        try {
            left.push(new Disk(15));
        } catch (Exception exception) {
            illegal = exception;
        }
        assertTrue(illegal instanceof IllegalStateException);

        // If adding a null disks catches an error.
        try {
            left.push(null);
        } catch (Exception exception) {
            illegal = exception;
        }
        assertTrue(illegal instanceof IllegalArgumentException);
    }
}
