/**
 * 
 */
package towerofhanoi;

import java.util.Observable;

/**
 * Solves the Tower of Hanoi in
 * the stack of the Disks.
 * 
 */
public class HanoiSolver extends Observable {

    /**
     * The three towers that store stacks of disks
     * and the total number of disks in the three
     * towers
     */
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    /**
     * Constructor that passes the number of disks
     * into local variable and instantiates the
     * towers to their given positions.
     * 
     * @param disks the number of disks
     */
    public HanoiSolver(int disks) {
        numDisks = disks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
    }

    /**
     * Getter for the number of disks
     * 
     * @return The total number of disks
     */
    public int disks() {
        return numDisks;
    }

    /**
     * Getter for Towers depending on position
     * 
     * @param position Where the tower is located
     * @return The Tower object
     */
    public Tower getTower(Position position) {
        // Since we are used an enum use switch to
        // return the correct Tower
        switch (position) {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case MIDDLE:
                return middle;
            default:
                return middle;
        }
    }

    /**
     * Returns a String of the widths of each disk in each Tower
     * 
     * @return The widths of each disk in each tower from smallest to largest
     */
    public String toString() {
        return left.toString() + middle.toString() + right.toString();
    }

    /**
     * Moves a disk from one tower to another
     * 
     * @param source      Current position of the disk
     * @param destination Where the disk will be moved to
     */
    private void move(Tower source, Tower destination) {
        // If the source tower is empty then a Exception
        // will be thrown.
        try {
            destination.push(source.pop());
        } catch (Exception exception) {
            /**
             * Cannot add when the source is empty.
             * This will be called in the recursion
             * sometimes so much catch error or the code
             * will stop.
             */
        }
        // Updates the Observer that a disk moved and gives
        // the position of the new tower
        setChanged();
        notifyObservers(destination.position());
    }

    /**
     * Recursive method to solve the Tower of Hanoi.
     * 
     * @param currentDisks The current disk
     * @param startPole    Where the disk is currently
     * @param tempPole     Where the disk will move to temporarily
     * @param endPole      Where the disk will end
     */
    private void solveTowers(
            int currentDisks, Tower startPole, Tower tempPole, Tower endPole) {
        // Base case when there are no more disks
        if (currentDisks == 0) {
            return;
        }
        // Get all of the disks above the bottom disk to the tempPole
        solveTowers(currentDisks - 1, startPole, endPole, tempPole);

        // Move the last disk to the endPole
        move(startPole, endPole);

        // Move the smaller disks to the endPole
        solveTowers(currentDisks - 1, tempPole, startPole, endPole);
    }

    /**
     * Method that will be used in other classes to solve the Tower of Hanoi
     */
    public void solve() {
        // The number of given in the HanoiSolver constructor and moving
        // disks from right pole to left pole.
        solveTowers(numDisks, right, middle, left);
    }
}
