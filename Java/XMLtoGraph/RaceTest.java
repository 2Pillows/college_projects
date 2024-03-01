package xmltograph;

/**
 * Test class for Race
 * 
 */
public class RaceTest extends student.TestCase {

    // ~ Instance/static variables .............................................

    private Race white;
    private Race black;
    private Race latin;
    private Race other;
    private Race empty;

    // ~ Constructors ..........................................................

    /**
     * Instantiates variables before each test method
     */
    public void setUp() {
        white = new Race("White", 10, 5);
        black = new Race("Black", 20, 5);
        latin = new Race("Latin", 20, -1);
        other = new Race("Other", -1, 10);
        empty = new Race(null, 10, 5);
    }

    // ~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Test method for name getter
     */
    public void testGetName() {
        assertEquals("White", white.getName());
        assertNull(empty.getName());
    }

    // ----------------------------------------------------------
    /**
     * Test method for case getter
     */
    public void testGetCases() {
        assertEquals(10, white.getCases());

        white = new Race("White", 23, 2);
        assertEquals(8.6, white.getRatio(), 0.1);
    }

    // ----------------------------------------------------------
    /**
     * Test method for death getter
     */
    public void testGetDeaths() {
        assertEquals(5, white.getDeaths());
    }

    // ----------------------------------------------------------
    /**
     * Test method for ratio calculator
     */
    public void testGetRatio() {
        assertEquals(50, white.getRatio(), 0.1);
        assertEquals(25, black.getRatio(), 0.1);
        assertEquals(-1, latin.getRatio(), 0.1);
        assertEquals(-1, other.getRatio(), 0.1);
    }

    // ----------------------------------------------------------
    /**
     * Test method for toString
     */
    public void testToString() {
        assertEquals("(Race: White, Cases: 10, Deaths: 5)", white.toString());
    }

    // ----------------------------------------------------------
    /**
     * Test method for equals method
     */
    public void testEquals() {
        @SuppressWarnings("unused")
        Race nullTest = null;
        assertFalse(white.equals(nullTest));
        assertTrue(white.equals(white));
        assertFalse(white.equals(black));

        Race same = new Race("White", 10, 5);

        assertTrue(white.equals(same));

        assertFalse(white.equals("Hello"));
        assertFalse(white.equals(new Race("White", 20, 5)));
        assertFalse(white.equals(new Race("White", 10, 15)));
    }
}
