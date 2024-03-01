package towerofhanoi;
import java.awt.Color;
import acm.util.RandomGenerator;
import cs2.Shape;

/**
 * Creates the Disk of certain width
 * 
 * The Disk class used a library from VT in its Build Path which is why it won't compile.
 * 
 * @author henrysmith
 * @version Oct 18, 2020
 */
public class Disk extends Shape {

    /**
     * Creates shape of given width and random color
     * @param width The width of the shape
     */
    public Disk(int width) {
        //Calls Shape constructor to make shape
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);

        //Random color for shape
        RandomGenerator gen = new RandomGenerator();
        setBackgroundColor(
            new Color(
                gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)));
    }

    /**
     * Checks if otherDisk is equal, smaller, or
     * larger than this disk
     * @param otherDisk Disk compared to
     * @return int depending on size difference
     */
    public int compareTo(Disk otherDisk) {
        //Cannot compare to null
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        //The disk is smaller than the otherDisk
        if (this.getWidth() < otherDisk.getWidth()) {
            return -1;
        }
        //The disk is larger than other disk
        if (this.getWidth() > otherDisk.getWidth()) {
            return 1;
        }
        //The disks are the same width
        return 0;
    }

    /**
     * Returns string of the Disk width
     * @return String representation of width
     */
    public String toString() {
        return "" + this.getWidth();
    }

    /**
     * Determines if two disks are equal 
     * in width
     * @param item The item to be compared to
     * @return True or false if two disks
     * have equal width
     */
    public boolean equals(Object item) {
        if (item == null) {
            return false;
        }
        if (this == item) {
            return true;
        }
        //If same class than cast as Disk and compare widths
        if (this.getClass() == item.getClass()) {
            Disk newDisk = (Disk) item;
            if (this.compareTo(newDisk) == 0) {
                return true;
            }
        }
        //Not the same class so returns false
        return false;
    }
}
