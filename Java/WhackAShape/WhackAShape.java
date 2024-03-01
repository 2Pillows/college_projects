/**
 * 
 */
package game;

import java.awt.Color;
import bag.SimpleBagInterface;
import cs2.Button;
import cs2.CircleShape;
import cs2.Shape;
import cs2.SquareShape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import student.TestableRandom;

/**
 * WhackAShape class that will create the window and shapes
 * for the project.
 * 
 * The WhackAShape class used a library from VT in its Build Path which is why it won't compile.
 * 
 * @author henrysmith
 * @version Oct 4, 2020
 */
public class WhackAShape {

    /**
     * Creates the fields bag, the window, and a 
     * random number generator.
     */
    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;

    /**
     * Constructor for WhackAShape. Instantiates the 
     * fields above, adds a quit button to the window,
     * and will add one of each shape to the bag.
     */
    public WhackAShape() {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        randomGenerator = new TestableRandom();

        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.SOUTH);

        bag.add(buildShape("red circle"));
        bag.add(buildShape("red square"));
        bag.add(buildShape("blue circle"));
        bag.add(buildShape("blue square"));


        window.addShape(bag.pick());
    }

    /**
     * Constructor that will add specified objects into the
     * bag. Adds a quit button and instantiates fields
     * similarly to default constructor.
     * @param str
     */
    public WhackAShape(String[] str) {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        randomGenerator = new TestableRandom();

        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.SOUTH);

        try {
            for (int i = 0; i < str.length; i++) {
                bag.add(buildShape(str[i]));
            }
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        window.addShape(bag.pick());
    }

    /**
     * Returns the bag.
     * @return bag of Shape objects
     */
    public SimpleBagInterface<Shape> getBag() {
        return bag;
    }

    /**
     * Returns the window.
     * @return window with shapes and quit button
     */
    public Window getWindow() {
        return window;
    }

    /**
     * Will exit the window when button is clicked.
     * @param source the button clicked
     */
    public void clickedQuit(Button source) {
        System.exit(0);
    }

    /**
     * When a shape is clicked, remove the shape and 
     * add another. If the bag is empty then
     * the game is over.
     * @param shape The shape that was clicked and
     * will be remvoed.
     */
    public void clickedShape(Shape shape) {
        window.removeShape(shape);
        bag.remove(shape);

        Shape nextShape = bag.pick();

        if (nextShape == null) {
            int width = window.getGraphPanelWidth() / 2;
            int height = window.getGraphPanelHeight() / 2;

            TextShape endText = new TextShape(0, 0, "You Win!");
            endText.setX(width - (endText.getWidth() / 2));
            endText.setY(height - (endText.getHeight() / 2));

            window.addShape(endText);
        }
        else {
            window.addShape(nextShape);
        }

    }

    /**
     * Creates a shape using a String input. Can be 
     * a circle or shape of red or blue color. If not 
     * one of those options then throws an error.
     * @param input String that describes shape to be made.
     * @return A Shape of the specified color and shape
     */
    private Shape buildShape(String input) {
        int size = randomGenerator.nextInt(101) + 100;

        int indexX = randomGenerator.nextInt(window.getGraphPanelWidth() - size);
        int indexY = randomGenerator.nextInt(window.getGraphPanelHeight() - size);

        Shape currentShape = null;
        boolean colorIsRed;
        boolean shapeIsCircle;

        if (input.contains("red")) {
            colorIsRed = true;
        }
        else if (input.contains("blue")) {
            colorIsRed = false;
        }
        else {
            throw new IllegalArgumentException("No Color in String");
        }

        if (input.contains("circle")) {
            shapeIsCircle = true;
        }
        else if (input.contains("square")) {
            shapeIsCircle = false;
        }
        else {
            throw new IllegalArgumentException("No Color in String");
        }

        if (colorIsRed && shapeIsCircle) {
            currentShape = new CircleShape(indexX, indexY, size, Color.RED);
        }
        else if (!(colorIsRed) && shapeIsCircle) {
            currentShape = new CircleShape(indexX, indexY, size, Color.BLUE);
        }
        else if (colorIsRed && !(shapeIsCircle)) {
            currentShape = new SquareShape(indexX, indexY, size, Color.RED);
        }
        else if (!(colorIsRed) && !(shapeIsCircle)) {
            currentShape = new SquareShape(indexX, indexY, size, Color.BLUE);
        }

        currentShape.onClick(this, "clickedShape");
        return currentShape;
    }
}
