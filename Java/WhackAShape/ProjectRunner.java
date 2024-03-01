/**
 * 
 */
package game;

import java.util.Scanner;

/**
 * 
 * ProjectRunner is the class that creates the 
 * WhackAShape and Scanner that will be
 * used to create shapes depending on the user input.
 * 
 * @author henrysmith
 * @version Oct 4, 2020
 */
public class ProjectRunner {

    /**
     * Constructor method for ProjectRunner
     * Intentionally left empty
     */
    public ProjectRunner() {

    }

    /**
     * Main method that creates a Scanner and WhackAShape.
     * Will ask user for input, if nothing entered than 
     * use default shapes, else use shapes entered by user.
     * If a non-shape string is included then an error
     * will be thrown.
     * @param args Creates a Scanner and Window
     */
    @SuppressWarnings({ "unused", "resource" })
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Shapes: ");
        String stringShapes = sc.nextLine();
        String[] arrayShapes = stringShapes.split(",");

        if (stringShapes.length() == 0) {
            WhackAShape whackAShape = new WhackAShape();
        }
        else {
            WhackAShape whackAShape = new WhackAShape(arrayShapes);
        }

    }
}
