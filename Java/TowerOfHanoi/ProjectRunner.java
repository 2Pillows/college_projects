/**
 * 
 */
package towerofhanoi;

/**
 * Runner class for the Tower of Hanoi project 
 * 
 * @author henrysmith
 * @version Oct 18, 2020
 */
public class ProjectRunner {

    /**
     * Main method that creates the PuzzleWindow and the number
     * of disks
     * @param args The augments for the method
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        int disks = 5;
        if (args.length == 1)
            disks = Integer.parseInt(args[0]);
        
        //Creates the PuzzleWindow and starts the project
        PuzzleWindow puzzle = new PuzzleWindow(new HanoiSolver(disks));

    }
}
