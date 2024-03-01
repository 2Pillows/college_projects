/**
 * 
 */
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * Class responsible for creating the window
 * and adding the graphical representation of the towers
 * and disks to the said window.
 * 
 * 
 */
public class PuzzleWindow implements Observer {

    /**
     * Creates the fields of the game, towers, tower stands,
     * and window.
     */
    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Shape leftStand;
    private Shape rightStand;
    private Shape middleStand;
    private Window window;
    public static final int WIDTH_FACTOR = 1;
    public static final int DISK_GAP = 5;
    public static final int DISK_HEIGHT = 10;

    /**
     * The interval between the moves of the disk
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
    }

    /**
     * Moves the disk from one tower to another
     * 
     * @param position The current tower's position
     */
    private void moveDisk(Position position) {
        // Gets the current disk and current tower
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole = null;

        // Instantiates the tower based on position
        if (position == Position.LEFT)
            currentPole = left;
        if (position == Position.RIGHT)
            currentPole = right;
        if (position == Position.MIDDLE)
            currentPole = middle;
        if (position == Position.DEFAULT)
            currentPole = middle;
        currentDisk.moveTo(currentPole.getX() - ((currentDisk.getWidth() - currentPole.getWidth()) / 2),
                currentPole.getY() + (currentPole.getHeight() - (currentDisk.getHeight() *
                        game.getTower(position).size())));
    }

    /**
     * Constructor that instantiates the game, disks, window, towers, and
     * tower stands. Adds all of the said objects into the window as well.
     * 
     * @param item
     */
    public PuzzleWindow(HanoiSolver item) {
        // Instantiating the HanoiSolver game and adding observer
        game = item;
        game.addObserver(this);

        // Window with the towers and disks
        window = new Window();
        window.setTitle("Tower of Hanoi");

        int width = window.getGraphPanelWidth();
        int height = window.getGraphPanelHeight() / 2;

        // Instantiating all of the towers with shape and color
        left = new Shape(100, height - 75, 10, 150);
        right = new Shape(width - 150, height - 75, 10, 150);
        middle = new Shape(width / 2 - 25, height - 75, 10, 150);
        left.setBackgroundColor(Color.PINK);
        right.setBackgroundColor(Color.PINK);
        middle.setBackgroundColor(Color.PINK);
        left.setForegroundColor(Color.BLACK);
        right.setForegroundColor(Color.BLACK);
        middle.setForegroundColor(Color.BLACK);

        // Instantiating all of the tower stands with shape and color
        leftStand = new Shape(100 - 45, height + 75, 100, 10);
        rightStand = new Shape(width - 195, height + 75, 100, 10);
        middleStand = new Shape(width / 2 - 70, height + 75, 100, 10);
        leftStand.setBackgroundColor(Color.PINK);
        rightStand.setBackgroundColor(Color.PINK);
        middleStand.setBackgroundColor(Color.PINK);
        leftStand.setForegroundColor(Color.BLACK);
        rightStand.setForegroundColor(Color.BLACK);
        middleStand.setForegroundColor(Color.BLACK);

        // Creating and adding each disk to the window
        for (int i = game.disks(); i > 0; i--) {
            Disk newDisk = new Disk(i * 15);
            window.addShape(newDisk);
            game.getTower(Position.RIGHT).push(newDisk);
            moveDisk(Position.RIGHT);
        }

        window.addShape(leftStand);
        window.addShape(rightStand);
        window.addShape(middleStand);

        window.addShape(left);
        window.addShape(right);
        window.addShape(middle);

        // Creating solve button to complete the Tower of Hanoi
        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.SOUTH);
        solve.onClick(this, "clickedSolve");
    }

    /**
     * Updates the position of the disks based
     * on the observer that was added to the
     * HanoiSolver game.
     */
    public void update(Observable o, Object arg) {
        Position position = null;
        if (arg.getClass() == Position.class) {
            position = (Position) arg;
        }
        // When update in the HanoiSolver move disk to new position
        moveDisk(position);
        // Interval between next move of disk
        sleep();
    }

    /**
     * When the Button is clicked then the HanoiSolver
     * will be called and the recursive method will
     * begin to solve the towers.
     * 
     * @param button
     */
    public void clickedSolve(Button button) {
        // Once pressed must wait till the tower is solved
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }
}
