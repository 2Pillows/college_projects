/**
 * Test class for State
 */
public class StateTest extends student.TestCase {

    // ~ Instance/static variables .............................................

    private State virginia;
    private State same;
    private State diffName;
    private State diffRace;
    private SinglyLinkedList<Race> races2;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Instantiates each variable for each method
     */
    public void setUp() {
        SinglyLinkedList<Race> races = new SinglyLinkedList<Race>();
        Race white = new Race("White", 10, 5);
        Race black = new Race("Black", 20, 5);
        races.add(white);
        races.add(black);

        virginia = new State("Virginia", races);

        races2 = new SinglyLinkedList<Race>();
        races2.add(white);
        races2.add(black);

        same = new State("Virginia", races);

        diffName = new State("Florida", races);

        SinglyLinkedList<Race> otherRace = new SinglyLinkedList<Race>();
        otherRace.add(black);
        otherRace.add(white);
        diffRace = new State("Virginia", otherRace);
    }

    // ~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Test method for getName().
     */
    public void testGetName() {
        assertEquals("Virginia", virginia.getName());
    }

    // ----------------------------------------------------------
    /**
     * Test method for getRace().
     */
    public void testGetRaces() {
        assertEquals(races2.get(0), virginia.getRaces().get(0));
        assertEquals(races2.get(1), virginia.getRaces().get(1));
    }

    // ----------------------------------------------------------
    /**
     * Test method for toString().
     */
    public void testToString() {
        assertEquals("(State: Virginia [(Race: White, Cases: 10, Deaths: 5)"
                + "(Race: Black, Cases: 20, Deaths: 5)])", virginia.toString());
    }

    // ----------------------------------------------------------
    /**
     * Test method for equals().
     */
    public void testEquals() {
        State nullState = null;
        assertFalse(virginia.equals(nullState));

        assertTrue(virginia.equals(virginia));

        assertTrue(virginia.equals(same));

        assertFalse(virginia.equals(diffRace));
        diffRace.getRaces().add(new Race("Latin", 10, 1));
        assertFalse(virginia.equals(diffRace));

        assertFalse(virginia.equals(diffName));

        assertFalse(virginia.equals("Hello"));
    }
}
