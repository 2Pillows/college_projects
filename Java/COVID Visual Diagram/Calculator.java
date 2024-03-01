import java.util.Iterator;

/**
 * Handles the back-end for Linked Lists for
 * States and Races.
 */
public class Calculator {

    // ~ Instance/static variables .............................................

    private SinglyLinkedList<State> states;
    private SinglyLinkedList<Race> stateRaces;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Calculator used in order to manipulate the back end of the project
     * 
     * @param stateList SinglyLinkedList of State objects
     */
    public Calculator(SinglyLinkedList<State> stateList) {
        states = stateList;

        // Linked List of Races specific to State
        stateRaces = null;
    }

    // ~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Finds the State object whose name is equal to parameter.
     * 
     * @param name The name of the State object.
     * @return The State object equal to name in parameter.
     */
    public State stateByName(String name) {
        Iterator<State> iter = states.iterator();
        State foundState = null;

        while (iter.hasNext()) {
            State tempState = (State) iter.next();
            if (name.equals(tempState.getName())) {
                foundState = tempState;
            }
        }
        return foundState;
    }

    // ----------------------------------------------------------
    /**
     * Sorts Linked Lists of Race objects in alphabetical order
     * for all states.
     */
    public void sortRacesAlpha() {
        // Loop for each State
        for (int a = 0; a < states.size(); a++) {
            stateRaces = states.get(a).getRaces();

            // Continue checking order until no swap is made
            boolean swap = true;
            while (swap) {
                swap = false;

                // Loop though Races in State
                for (int i = 0; i < stateRaces.size() - 1; i++) {
                    swap = swap || sortAlphaIndex(i);
                }
            }
        }
    }

    // ----------------------------------------------------------
    /**
     * Sorts Linked List of Race objects at index i.
     * 
     * @param i Index in SinglyLinkedList of Races.
     * @return True or false if the sort was successful.
     */
    private boolean sortAlphaIndex(int i) {
        boolean swap = false;

        Race firstRace = stateRaces.get(i);
        Race secondRace = stateRaces.get(i + 1);

        String firstLtr = firstRace.getName().substring(0, 1);
        String secondLtr = secondRace.getName().substring(0, 1);

        if (firstLtr.compareTo(secondLtr) > 0) {
            swapRaces(i);
            swap = true;
        }
        if (firstLtr.compareTo(secondLtr) == 0) {
            firstLtr = firstRace.getName().substring(1, 2);
            secondLtr = secondRace.getName().substring(1, 2);

            if (firstLtr.compareTo(secondLtr) > 0) {
                swapRaces(i);
                swap = true;
            }
        }
        return swap;
    }

    // ----------------------------------------------------------
    /**
     * Sorts SinglyLinkedList of Race objects for all states
     * in order by Case Fatality Ratio. If two Races have the
     * same CFR then they are sorted by if their cases were
     * given or N/A and then alphabetically.
     */
    public void sortRacesCFR() {
        // Loop though States
        for (int a = 0; a < states.size(); a++) {
            stateRaces = states.get(a).getRaces();

            // Continue checking order until no swap is made
            boolean swap = true;
            while (swap) {
                swap = false;

                // Loop though Races in State
                for (int i = 0; i < stateRaces.size() - 1; i++) {
                    Race firstRace = stateRaces.get(i);
                    Race secondRace = stateRaces.get(i + 1);

                    if (firstRace.getRatio() < secondRace.getRatio()) {
                        swapRaces(i);
                        swap = true;
                    }

                    // If ratios are equal then sort by if cases are -1
                    // and then alphabetically
                    if (firstRace.getRatio() == secondRace.getRatio()) {
                        if (firstRace.getCases() == -1.0
                                && secondRace.getCases() != -1) {
                            swapRaces(i);
                            swap = true;
                        } else if (firstRace.getRatio() != -1.0) {
                            swap = swap || sortAlphaIndex(i);
                        }
                    }
                }
            }
        }
    }

    // ----------------------------------------------------------
    /**
     * Swaps the Race after index with race on index
     * 
     * @param i Index in SinglyLinkedList of Race objects
     */
    private void swapRaces(int i) {
        Race replaceRace = stateRaces.get(i + 1);
        stateRaces.remove(i + 1);
        stateRaces.add(i, replaceRace);
    }
}
