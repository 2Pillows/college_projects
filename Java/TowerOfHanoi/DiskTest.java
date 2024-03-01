package towerofhanoi;

/**
 * Testing class for the Disk class
 * 
 * The DiskTest class used a library from VT in its Build Path which is why it
 * won't compile.
 */
public class DiskTest extends student.TestCase {

    /**
     * Creates fields to be used in test class.
     * The main Disk is disk and the others are
     * to be used in the compare test and equal test.
     */
    private Disk disk;
    private Disk same;
    private Disk smallerThan;
    private Disk largerThan;
    private Disk empty;
    private String difClass = "Hello";

    /**
     * Instantiates the fields above
     */
    public void setUp() {
        disk = new Disk(10);
        same = new Disk(10);
        smallerThan = new Disk(5);
        largerThan = new Disk(15);
        empty = null;
    }

    /**
     * Tests the compareTo method in Disk.
     * Includes test for comparing to itself,
     * to a same disk, and a smaller and larger
     * than disk.
     */
    public void testCompareTo() {
        assertEquals(0, disk.compareTo(disk));
        assertEquals(0, disk.compareTo(same));
        assertEquals(-1, disk.compareTo(largerThan));
        assertEquals(1, disk.compareTo(smallerThan));

        Exception emptyException = null;
        try {
            disk.compareTo(null);
        } catch (Exception exception) {
            emptyException = exception;
        }
        assertNotNull(emptyException);
        assertTrue(emptyException instanceof IllegalArgumentException);
    }

    /**
     * Tests the toString method in Disk.
     */
    public void testToString() {
        assertEquals("10", disk.toString());
    }

    /**
     * Tests the equals method with null,
     * comparing to itself, and to a same disk
     * larger disk and a Object from another class.
     */
    public void testEquals() {
        assertFalse(disk.equals(empty));
        assertTrue(disk.equals(disk));
        assertTrue(disk.equals(same));
        assertFalse(disk.equals(smallerThan));
        assertFalse(disk.equals(difClass));
    }
}
