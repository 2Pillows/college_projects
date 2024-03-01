package xmltograph;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * Creates window for graph of Races. Includes buttons for sorting
 * and quitting as well as cycling though States.
 * 
 * The GUIWindow class used a library from VT in its Build Path which is why it
 * won't compile.
 * 
 */
public class GUIWindow {

    // ~ Instance/static variables .............................................

    private Window window;
    private SinglyLinkedList<State> states;
    private Calculator calc;
    public static final int NUM_STATES = 6;
    public static final int NUM_RACES = 5;
    private State currentState;

    // ~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Instantiates a window with a button for each state as well as
     * quit, sortAlpha, and sortCFR buttons.
     * 
     * @param stateList SinglyLinkedList of State objects
     */
    public GUIWindow(SinglyLinkedList<State> stateList) {
        states = stateList;
        calc = new Calculator(states);

        window = new Window();
        window.setTitle("COVID Visualization");

        Button sortAlpha = new Button("Sort by Alpha");
        sortAlpha.onClick(this, "clickedSort");
        window.addButton(sortAlpha, WindowSide.NORTH);

        Button quit = new Button("QUIT");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.NORTH);

        Button sortCFR = new Button("Sort by CFR");
        sortCFR.onClick(this, "clickedSort");
        window.addButton(sortCFR, WindowSide.NORTH);

        for (int i = 0; i < NUM_STATES; i++) {
            Button tempState = new Button(states.get(i).getName());
            tempState.onClick(this, "clickedState");
            window.addButton(tempState, WindowSide.SOUTH);
        }
    }

    // ~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * When a state button is pressed this method will be called and
     * the bar graph of races will be updated.
     * 
     * @param button The button that was clicked.
     */
    public void clickedState(Button button) {
        Calculator calc = new Calculator(states);
        State state = calc.stateByName(button.getTitle());
        currentState = state;
        updateRaces();
    }

    // ----------------------------------------------------------
    /**
     * When a sort button is pressed this method will be called and
     * the bar graph will re-arrange in order of alpha or CFR.
     * 
     * @param button The button that was clicked.
     */
    public void clickedSort(Button button) {
        if (button.getTitle().equals("Sort by Alpha")) {
            for (int i = 0; i < NUM_STATES; i++) {
                calc.sortRacesAlpha();
            }
        }
        if (button.getTitle().equals("Sort by CFR")) {
            for (int i = 0; i < NUM_STATES; i++) {
                calc.sortRacesCFR();
            }
        }
        updateRaces();
    }

    // ----------------------------------------------------------
    /**
     * When the quit button is pressed this method will run and
     * the window will close and the program will stop.
     * 
     * @param button The button that was clicked.
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

    // ----------------------------------------------------------
    /**
     * The bar graph that represents the races will be updated
     * when a state or sort button is pressed.
     */
    public void updateRaces() {
        window.removeAllShapes();

        // Adds bars, race name, state ratio, and state name for each Race
        for (int i = 0; i < NUM_RACES; i++) {
            int xGap = (window.getGraphPanelWidth() - 100) / NUM_RACES;
            int xPos = 100 + xGap * i;
            int yPos = window.getGraphPanelHeight() / 2;

            int barHeight = (int) (currentState.getRaces().get(i).getRatio() * 6) + 2;

            Shape tempBar = new Shape(0, 0, 10, barHeight * 2, Color.BLUE);
            tempBar.setX(xPos - tempBar.getWidth() / 2);
            tempBar.setY(yPos - tempBar.getHeight() + 40);
            window.addShape(tempBar);

            TextShape raceName = new TextShape(
                    xPos, yPos + 60, currentState.getRaces().get(i).getName());
            raceName.setX(xPos - raceName.getWidth() / 2);
            window.addShape(raceName);

            TextShape stateRatio = new TextShape(
                    xPos, yPos + 80,
                    currentState.getRaces().get(i).getRatio() + "%");
            stateRatio.setX(xPos - stateRatio.getWidth() / 2);
            stateRatio.setForegroundColor(Color.ORANGE);
            window.addShape(stateRatio);

            TextShape stateName = new TextShape(
                    xPos, 20, currentState.getName(), Color.RED, 20);
            stateName.setX(
                    window.getGraphPanelWidth() / 2 - stateName.getWidth() / 2);
            window.addShape(stateName);
        }
    }
}
