/**
 * 
 */
package towerofhanoi;

/**
 * Creates the towers that will be used and based on
 * their positions.
 * 
 * The Tower class used a library from VT in its Build Path which is why it
 * won't compile.
 * 
 */
public class Tower extends LinkedStack<Disk> {

    /**
     * Field for the position of the towers
     */
    private Position position;

    /**
     * Constructor that will make a stack for each tower
     * based on position
     * 
     * @param pos The location of the tower
     */
    public Tower(Position pos) {
        // Makes a list of widths under tower of position pos
        super();
        position = pos;
    }

    /**
     * Getter for the position
     * 
     * @return The position of the tower
     */
    public Position position() {
        return position;
    }

    /**
     * Adds a disk to the stack linked
     * to the Tower based on position.
     */
    @Override
    public void push(Disk disk) {
        // Throws error if the disk is null
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        // Must follow rule of only being able to add a smaller
        // disk onto a larger one.
        if (this.isEmpty() || super.peek().compareTo(disk) == 1) {
            super.push(disk);
        }
        // Throws error is trying to add a larger disk on top of a
        // smaller disk.
        else {
            throw new IllegalStateException();
        }
    }
}
