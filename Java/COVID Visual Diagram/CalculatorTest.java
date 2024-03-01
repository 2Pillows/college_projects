import java.io.FileNotFoundException;

/**
 * Testing class for Calculator class
 */
public class CalculatorTest extends student.TestCase {

    // ~ Instance/static variables .............................................

    private Calculator calc;
    private Calculator calc2;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Instantiates the variables for test class when each method runs
     */
    public void setUp() throws FileNotFoundException {
        Reader rdr = new Reader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        calc = new Calculator(rdr.getState());

        Reader rdr2 = new Reader("TestFile2.csv");
        calc2 = new Calculator(rdr2.getState());
    }

    // ~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Tests if the correct State is returned from StateByName
     */
    public void testStateByName() {
        assertEquals("(State: DC [(Race: White, Cases: 70678, Deaths: 1924)"
                + "(Race: Black, Cases: 179563, Deaths: 13365)"
                + "(Race: LatinX, Cases: 97118, Deaths: 2269)"
                + "(Race: Asian, Cases: 5407, Deaths: 254)"
                + "(Race: Other, Cases: 108784, Deaths: 170)])",
                calc.stateByName("DC").toString());
    }

    // ----------------------------------------------------------
    /**
     * Tests if Linked List of Races is properly sorted by Alpha
     */
    public void testSortRacesAlpha() {
        calc.sortRacesAlpha();
        assertEquals("(State: VA [(Race: Asian, Cases: -1, Deaths: -1)"
                + "(Race: Black, Cases: 426362, Deaths: 14702)"
                + "(Race: LatinX, Cases: 738177, Deaths: -1)"
                + "(Race: Other, Cases: 777332, Deaths: 5745)"
                + "(Race: White, Cases: 616402, Deaths: 34311)])",
                calc.stateByName("VA").toString());

        calc2.sortRacesAlpha();
        assertEquals("(State: AB [(Race: Asian, Cases: 55816, Deaths: 7512)"
                + "(Race: Black, Cases: 30341, Deaths: 2906)"
                + "(Race: Brown, Cases: 56845, Deaths: 2053)"
                + "(Race: LatinX, Cases: 11740, Deaths: 9600)"
                + "(Race: Other, Cases: 56230, Deaths: 8509)])",
                calc2.stateByName("AB").toString());
    }

    // ----------------------------------------------------------
    /**
     * Tests if Linked List of Races is properly sorted by CFR
     */
    public void testSortRacesCFR() {
        calc.sortRacesCFR();
        assertEquals("(State: DC [(Race: Black, Cases: 179563, Deaths: 13365)"
                + "(Race: Asian, Cases: 5407, Deaths: 254)"
                + "(Race: White, Cases: 70678, Deaths: 1924)"
                + "(Race: LatinX, Cases: 97118, Deaths: 2269)"
                + "(Race: Other, Cases: 108784, Deaths: 170)])",
                calc.stateByName("DC").toString());

        calc2.sortRacesCFR();
        assertEquals("(State: AC [(Race: Other, Cases: 16290, Deaths: 6281)"
                + "(Race: Black, Cases: 24422, Deaths: 7426)"
                + "(Race: Brown, Cases: 92158, Deaths: 463)"
                + "(Race: Asian, Cases: 62800, Deaths: -1)"
                + "(Race: LatinX, Cases: -1, Deaths: -1)])",
                calc2.stateByName("AC").toString());
    }
}
