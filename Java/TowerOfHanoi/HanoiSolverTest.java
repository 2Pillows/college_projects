/**
 * 
 */
package towerofhanoi;

/**
 * Test class for the HanoiSolver class
 * 
 */
public class HanoiSolverTest extends student.TestCase {

    /**
     * Fields that will be used in the test class.
     * A field for each tower and testing HanoiSolver
     */
    private HanoiSolver testSolv;
    private Tower left;
    private Tower middle;
    private Tower right;

    /**
     * Instantiates the HanoiSolver and adds disks to the
     * right tower. Also sets each tower to the local
     * towers.
     */
    public void setUp() {
        testSolv = new HanoiSolver(5);
        testSolv.getTower(Position.RIGHT).push(new Disk(10));
        testSolv.getTower(Position.RIGHT).push(new Disk(5));
        testSolv.getTower(Position.RIGHT).push(new Disk(2));

        left = testSolv.getTower(Position.LEFT);
        right = testSolv.getTower(Position.RIGHT);
        middle = testSolv.getTower(Position.MIDDLE);

    }

    /**
     * Test method for disk. Returns the number of disks
     */
    public void testDisks() {
        assertEquals(5, testSolv.disks());
    }

    /**
     * Test method for getTower. Returns the Tower of given
     * position.
     */
    public void testGetTower() {
        assertEquals(left, testSolv.getTower(Position.LEFT));
        assertEquals(right, testSolv.getTower(Position.RIGHT));
        assertEquals(middle, testSolv.getTower(Position.MIDDLE));
        assertEquals(middle, testSolv.getTower(Position.DEFAULT));

    }

    /**
     * Test method for toString. Returns the String of
     * disk widths for each tower.
     */
    public void testToString() {
        assertEquals("[][][2, 5, 10]", testSolv.toString());

        testSolv.getTower(Position.MIDDLE).push(new Disk(1));
        testSolv.getTower(Position.LEFT).push(new Disk(1));
        assertEquals("[1][1][2, 5, 10]", testSolv.toString());
    }

    /**
     * Test method for solve. The disks should end up
     * all at the left tower from smallest to largest
     * widths.
     */
    public void testSolve() {
        testSolv.solve();
        assertEquals("[2, 5, 10][][]", testSolv.toString());
    }
}
