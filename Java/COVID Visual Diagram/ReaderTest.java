import java.io.FileNotFoundException;

/**
 * Not needed for the project but used to test if the Reader was
 * properly gathering data from File.
 */
public class ReaderTest extends student.TestCase {

    // ~ Instance/static variables .............................................

    private SinglyLinkedList<State> states;

    // ~ Constructors ..........................................................

    /**
     * Instantiates each variable for when each method runs.
     * 
     * @throws FileNotFoundException In-case File isn't found with fileName
     */
    public void setUp() throws FileNotFoundException {
        Reader rdr = new Reader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");

        states = rdr.getState();
    }

    // ~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Test method to ensure File is properly being read and stored in
     * State and Race objects.
     */
    public void testGetState() {
        Race[] temp = new Race[5];
        temp[0] = new Race("White", 70678, 1924);
        temp[1] = new Race("Black", 179563, 13365);
        temp[2] = new Race("LatinX", 97118, 2269);
        temp[3] = new Race("Asian", 5407, 254);
        temp[4] = new Race("Other", 108784, 170);

        assertEquals("(State: DC [(Race: White, Cases: 70678, Deaths: 1924)"
                + "(Race: Black, Cases: 179563, Deaths: 13365)"
                + "(Race: LatinX, Cases: 97118, Deaths: 2269)"
                + "(Race: Asian, Cases: 5407, Deaths: 254)"
                + "(Race: Other, Cases: 108784, Deaths: 170)])",
                states.get(0).toString());
    }
}
