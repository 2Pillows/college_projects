package xmltograph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Uses a Scanner to create SinglyLinkedLists of
 * States and Races to hold data inside File given
 * as parameter.
 * 
 */
public class Reader {

    // ~ Instance/static variables .............................................

    private SinglyLinkedList<State> states;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Instantiates the states SinglyLinkedList from the file parameter and
     * makes a call to GUIWindow with the SinglyLinkedList
     * 
     * @param fileName
     * @throws FileNotFoundException
     */
    public Reader(String fileName) throws FileNotFoundException {
        states = readFile(fileName);

        @SuppressWarnings("unused")
        GUIWindow window = new GUIWindow(states);
    }

    // ~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates a SinglyLinkedList of State objects from the data in File
     * with fileName.
     * 
     * @param fileName The name of a File object inside Project.
     * @return SinglyLinkedList of State objects made from data in File.
     * @throws FileNotFoundException Error in-case File isn't found with fileName.
     */
    public SinglyLinkedList<State> readFile(String fileName) throws FileNotFoundException {
        SinglyLinkedList<State> stateList = new SinglyLinkedList<State>();

        Scanner scn = new Scanner(new File(fileName));

        String[] raceOrder = new String[GUIWindow.NUM_RACES];
        String[] firstLine = scn.nextLine().split(",");

        for (int i = 0; i < GUIWindow.NUM_RACES; i++) {
            raceOrder[i] = firstLine[i + 1].substring(6);
        }

        while (scn.hasNextLine()) {
            String[] data = scn.nextLine().split(",");

            for (int i = 0; i < data.length; i++) {
                if (data[i].equals("NA")) {
                    data[i] = "-1";
                }
            }

            String stateName = data[0];
            int caseOne = Integer.parseInt(data[1]);
            int caseTwo = Integer.parseInt(data[2]);
            int caseThree = Integer.parseInt(data[3]);
            int caseFour = Integer.parseInt(data[4]);
            int caseFive = Integer.parseInt(data[5]);

            int deathOne = Integer.parseInt(data[6]);
            int deathTwo = Integer.parseInt(data[7]);
            int deathThree = Integer.parseInt(data[8]);
            int deathFour = Integer.parseInt(data[9]);
            int deathFive = Integer.parseInt(data[10]);

            SinglyLinkedList<Race> raceList = new SinglyLinkedList<Race>();
            raceList.add(new Race(raceOrder[0], caseOne, deathOne));
            raceList.add(new Race(raceOrder[1], caseTwo, deathTwo));
            raceList.add(new Race(raceOrder[2], caseThree, deathThree));
            raceList.add(new Race(raceOrder[3], caseFour, deathFour));
            raceList.add(new Race(raceOrder[4], caseFive, deathFive));

            stateList.add(new State(stateName, raceList));
        }

        return stateList;
    }

    // ----------------------------------------------------------
    /**
     * Used in ReaderTest to ensure the File is properly being read and
     * stored in State and Race objects.
     * 
     * @return SinglyLinkedList of States from data in File.
     */
    public SinglyLinkedList<State> getState() {
        return states;
    }
}
