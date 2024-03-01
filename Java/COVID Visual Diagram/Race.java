/**
 * Race objects hold the name of the race and their number
 * of cases and deaths.
 */
public class Race {

    // ~ Instance/static variables .............................................

    private String name;
    private int cases;
    private int deaths;

    // ~ Constructors ..........................................................

    /**
     * Creates a Race object with given name, number of cases, and number of
     * deaths.
     * 
     * @param raceName The name of the race
     * @param caseNum  Number of cases of specified race
     * @param deathNum Number of deaths of specified race
     */
    public Race(String raceName, int caseNum, int deathNum) {
        name = raceName;
        cases = caseNum;
        deaths = deathNum;
    }

    // ~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Getter for name of Race.
     * 
     * @return Name of Race or null if name is null.
     */
    public String getName() {
        return name;
    }

    // ----------------------------------------------------------
    /**
     * Getter for cases of Race.
     * 
     * @return Number of races for Race.
     */
    public int getCases() {
        return cases;
    }

    // ----------------------------------------------------------
    /**
     * Getter for deaths of Race.
     * 
     * @return Number of deaths for Race.
     */
    public int getDeaths() {
        return deaths;
    }

    // ----------------------------------------------------------
    /**
     * Getter for ratio of deaths / cases for Race.
     * 
     * @return Ratio for Race.
     */
    public double getRatio() {
        if (deaths == -1 || cases == -1) {
            return -1;
        }
        double ratio = (double) deaths / (double) cases * 100;
        return (Double.parseDouble(String.format("%.1f", ratio)));
    }

    // ----------------------------------------------------------
    /**
     * String of name, cases, and deaths of Race.
     * 
     * @return String of data in Race object in the form.
     * 
     *         "(Race: (num), Cases: (num), Deaths: (num))"
     */
    public String toString() {
        return ("(Race: " + name + ", Cases: " + cases
                + ", Deaths: " + deaths + ")");
    }

    // ----------------------------------------------------------
    /**
     * Determines if this Race and another Race object have the
     * same name, cases, and deaths.
     * 
     * @param obj Another Object to compare to this Race
     * @return True or false if this Race and Object obj are equal.
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
        Race other = (Race) obj;
        return (this.getName() == other.getName()
                && this.getCases() == other.getCases()
                && this.getDeaths() == other.getDeaths());
    }
}
