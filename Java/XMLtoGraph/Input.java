package xmltograph;

import java.io.FileNotFoundException;

/**
 * Runner for project: if no argument is given then use default file,
 * otherwise use file name given in the call to the static main method.
 * Makes a call to reader with File and prints the data found in File.
 *  
 * @author Henry Smith
 * @version Nov 13, 2020
 */
public class Input {

    //~ Instance/static variables .............................................

    private static SinglyLinkedList<State> state;
    private static Calculator calc;

    //~ Constructors ..........................................................

    public Input() {
        state = null;
        calc = null;
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Static main method that calls Reader class with fileName containing
     * COVID data.
     * @param args String argument from Run Configuration
     * @throws FileNotFoundException Error if file of given String isn't found
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            Reader rdr = new Reader(
                "Cases_and_Deaths_CRDT_NEW.csv");
            state = rdr.getState();
            calc = new Calculator(state);
        }
        else {
            Reader rdr = new Reader(args[0]);
            state = rdr.getState();
            calc = new Calculator(state);
        }

        for (int i = 0; i < state.size(); i++) {
            System.out.println(state.get(i).getName());
            
            calc.sortRacesAlpha();
            printOutput(i);

            calc.sortRacesCFR();
            printOutput(i);
        }
    }

    // ----------------------------------------------------------
    /**
     * The data stored in a SinglyLinkedList of State objects
     * will be displayed to the Console in the format:
     * (State name)
     * (Race): (Case number) cases, (Deaths / Case Percent)% CFR
     * .....
     * .....
     * The Race array will first be displayed  in alphabetical order and
     * then in order by CFR highest to lowest
     * @param state A SinglyLinkedList of State Object created from fileName
     * in the static 
     */
    private static void printOutput(int i) {
        for (int a = 0; a < state.get(i).getRaces().size(); a++) {
            Race r = state.get(i).getRaces().get(a);
            
            System.out.println(toString(r));
        }
        
        System.out.println("====");
    }

    // ----------------------------------------------------------
    /**
     * Helper method for printing the data found inside File with
     * COVID data.
     * @param r The Race whose data will be printed
     * @return String representation of data in Race
     */
    private static String toString(Race r) {
        String ratio = "" + r.getRatio();
        
        if (ratio.endsWith(".0")) {
            return (r.getName() 
                + ": " + r.getCases() + " cases, " 
                + (int)r.getRatio() + "% CFR");
        }
        else {
            return(r.getName() 
                + ": " + r.getCases() + " cases, "
                + r.getRatio() + "% CFR");
        }
    }
}
