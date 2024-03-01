/**
 * Creates State object that holds state name and SinglyLinkedList of
 * Race objects.
 */
public class State {

    // ~ Instance/static variables .............................................

    private String name;
    private SinglyLinkedList<Race> races;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a State object with given state name and array of Race objects
     * 
     * @param stateName Name of the state
     * @param raceList  Race objects under the specified State name
     */
    public State(String stateName, SinglyLinkedList<Race> raceList) {
        name = stateName;
        races = raceList;
    }

    // ~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Getter for name of State.
     * 
     * @return The name of State.
     */
    public String getName() {
        return name;
    }

    // ----------------------------------------------------------
    /**
     * Getter for Race array for State.
     * 
     * @return Race array of State
     */
    public SinglyLinkedList<Race> getRaces() {
        return races;
    }

    // ----------------------------------------------------------
    /**
     * Gives String of the data inside the State.
     * 
     * @return String representation of State in format:
     *         "(State: (name) [(toString of Race)])"
     */
    public String toString() {
        StringBuilder state = new StringBuilder();

        state.append("(State: " + name + " [");

        for (int i = 0; i < races.size(); i++) {
            state.append(races.get(i));
        }
        state.append("])");
        return state.toString();
    }

    // ----------------------------------------------------------
    /**
     * If two States have the same name and Race array they are considered
     * equal.
     * 
     * @param obj Another Object compared to this State.
     * @return True or false if this State equals Object obj.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        State other = (State) obj;
        if (!this.getName().equals(other.getName())) {
            return false;
        }
        if (races.size() != other.races.size()) {
            return false;
        }
        for (int i = 0; i < races.size(); i++) {
            if (!races.get(i).equals(other.races.get(i))) {
                return false;
            }
        }
        return true;
    }
}
