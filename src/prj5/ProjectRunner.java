// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

/**
 * Project runner class that includes the main methodtht runs the project.
 * 
 * @author Ahmed Altonobey
 * @version 2016.04.26
 */

public class ProjectRunner {
    /**
     * This method makes a new GameWindow, and passes it a new HanoiSolver,
     * which the number of discs is passed to be used.
     *
     * @param args
     *            The shape to create.
     */
    public static void main(String[] args) {
        Input input = new Input(args[1], args[0]);
        new GUIMusicVisualization(input.getGlyphsList());
    }
}
