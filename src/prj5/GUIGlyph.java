// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

/**
 * This class represents a glyph for display in the GUI.
 * 
 * @author Ahmed Altonobey (ahmedalt)
 * @version 2018.04.26
 */
public class GUIGlyph {
    private static final int MAX_BAR_SIZE = 100;
    private static final int PADDING_X = 5;
    private static final int PADDING_Y = 5;
    private static final int SEP_WIDTH = 5;
    private static final int GLYPH_WIDTH = MAX_BAR_SIZE * 2 + SEP_WIDTH;
    private static final int GLYPH_HEIGHT = 90;

    private static int songDataSelector;
    private static final int SEP_HEIGHT = 40;

    private static DoublyLinkedList<Glyph> glyphsList =
        new DoublyLinkedList<Glyph>();
    private static int page = 1;

    /**
     * Draw the glyphs by hobby first.
     */
    private static RepresentationEnum representation = RepresentationEnum.HOBBY;


    /**
     * The constructor for the GUI object.
     * 
     * @param glyphs
     *            The glyphsList that this GUI object will get its
     *            statistics from.
     */
    public GUIGlyph(DoublyLinkedList<Glyph> glyphs) {
        glyphsList = glyphs;
        glyphsList = Input.sort(LegendEnum.ARTIST);
    }


    /**
     * Sort the list of GUIGlyphs by the comparator passed in.
     * 
     * @param type
     *            The tpye to sort by.
     */
    public void sortGlyphs(LegendEnum type) {
        glyphsList = Input.sort(type);
    }


    /**
     * This method recalculates the data in the Glyph object that the
     * GlyphGUI is using for stats with the given sort method. This method
     * then calls a private helper method within this class that will
     * update the bar shapes for the new sort method.
     * 
     * @param type
     *            The sort method to sort the students by
     */
    public static void sortStat(RepresentationEnum type) {
        representation = type;
    }


    /**
     * This method displays the glyphs on the current page on the given window.
     * 
     * @param window
     *            The window to display the glyphs in.
     */
    public void display(Window window) {
        window.removeAllShapes();

        DoublyLinkedList<Glyph> display = new DoublyLinkedList<Glyph>();
        for (int index = (page - 1) * 9; index < page * 9 && index < glyphsList
            .size(); index++) {
            display.add(glyphsList.get(index));
        }

        int i = 1;
        for (Glyph g : display) {
            draw(i, window, representation, g);
            i++;
        }
    }


    /**
     * Goes to the next page and automatically displays the next page
     * if there is a page available.
     * 
     * @param window
     *            The window to display the glyph in.
     */
    public void nextPage(Window window) {
        if (hasNext()) {
            page++;
            display(window);
        }
    }


    /**
     * Goes to the previous page and automatically displays the previous page
     * if there is a page available.
     * 
     * @param window
     *            The window to display the glyph in.
     */
    public void previousPage(Window window) {
        if (hasPrevious()) {
            page--;
            display(window);
        }
    }


    /**
     * Gets the X,Y coordinates of the location specified for displaying
     * the glyph.
     * 
     * @param location
     *            An integer representation of the location of the
     *            glyph in the window starting from the top left and going right
     *            until the end of the 3x3 window.
     * @return Returns an array with the X and Y coordinates in integer format.
     */
    public static int[] getCoordinates(int location) {
        int[] coordinates = new int[2];
        int xGrid = (location % 3);
        int yGrid = ((location - 1) / 3);
        coordinates[0] = (PADDING_X * xGrid) + (GLYPH_WIDTH * xGrid);
        coordinates[1] = (PADDING_Y * yGrid) + (GLYPH_HEIGHT * yGrid);
        return coordinates;
    }


    /**
     * Checks to see if another page can be made with the glyphs in the list.
     * 
     * @return True if there is another page.
     */
    public static boolean hasNext() {
        return page < glyphsList.size() / 9;
    }


    /**
     * Checks to see if another page can be made with the glyphs in the list.
     * 
     * @return True if there can be another page.
     */
    public static boolean hasPrevious() {
        return page > 1;
    }


    /**
     * Draw each individual glyph.
     * 
     * @param location
     *            The location of where the glyph should be placed
     * @param window
     *            The window to place the glyph in
     * @param represent
     *            The order to place the glyphs when any of the three
     *            representation is clicked
     */
    public void draw(
        int location,
        Window window,
        RepresentationEnum represent,
        Glyph g) {
        TextShape[] songData;
        Shape[] dataBars;
        Shape separator;
        songData = new TextShape[4];
        songData[0] = new TextShape(0, 0, g.getSong().getTitle());
        songData[1] = new TextShape(0, 0, "by " + g.getSong().getArtist());
        songData[2] = new TextShape(0, 0, "Year Released: " + g.getSong()
            .getYear());
        songData[3] = new TextShape(0, 0, "genre: " + g.getSong().getGenre());
        songData[0].setBackgroundColor(Color.WHITE);
        songData[1].setBackgroundColor(Color.WHITE);
        songData[2].setBackgroundColor(Color.WHITE);
        songData[3].setBackgroundColor(Color.WHITE);
        dataBars = new Shape[8];
        songDataSelector = 1;

        int[] coor = GUIGlyph.getCoordinates(location);
        int yline = coor[1];
        // Do the title text shape.
        songData[0].setX(coor[0] + ((GLYPH_WIDTH / 2) - (songData[0].getWidth()
            / 2)));
        songData[0].setY(yline);
        yline += songData[0].getHeight();
        // Do the subtitle text shape.
        songData[songDataSelector].setX(coor[0] + ((GLYPH_WIDTH / 2)
            - (songData[songDataSelector].getWidth() / 2)));
        songData[songDataSelector].setY(yline);
        yline += songData[songDataSelector].getHeight();
        yline += 5;
        // Do the separator.
        separator = new Shape(coor[0] + MAX_BAR_SIZE, yline, SEP_WIDTH,
            SEP_HEIGHT);
        separator.setBackgroundColor(Color.BLACK);
        separator.setForegroundColor(Color.BLACK);
        // Do the bars
        double[] percents = determineRepresentData(g, represent);

        dataBars[0] = new Shape(coor[0] + MAX_BAR_SIZE - (int)(MAX_BAR_SIZE
            * percents[0]), yline, (int)(MAX_BAR_SIZE * percents[0]), 10);
        dataBars[0].setBackgroundColor(Color.MAGENTA);
        dataBars[0].setBackgroundColor(Color.MAGENTA);
        dataBars[1] = new Shape(coor[0] + MAX_BAR_SIZE + SEP_WIDTH, yline,
            (int)(MAX_BAR_SIZE * percents[4]), 10);
        dataBars[1].setBackgroundColor(Color.MAGENTA);
        dataBars[1].setBackgroundColor(Color.MAGENTA);
        yline += 10;

        dataBars[2] = new Shape(coor[0] + MAX_BAR_SIZE - (int)(MAX_BAR_SIZE
            * percents[1]), yline, (int)(MAX_BAR_SIZE * percents[1]), 10);
        dataBars[2].setBackgroundColor(Color.BLUE);
        dataBars[2].setBackgroundColor(Color.BLUE);
        dataBars[3] = new Shape(coor[0] + MAX_BAR_SIZE + SEP_WIDTH, yline,
            (int)(MAX_BAR_SIZE * percents[5]), 10);
        dataBars[3].setBackgroundColor(Color.BLUE);
        dataBars[3].setBackgroundColor(Color.BLUE);
        yline += 10;

        dataBars[4] = new Shape(coor[0] + MAX_BAR_SIZE - (int)(MAX_BAR_SIZE
            * percents[2]), yline, (int)(MAX_BAR_SIZE * percents[2]), 10);
        dataBars[4].setBackgroundColor(Color.YELLOW);
        dataBars[4].setBackgroundColor(Color.YELLOW);
        dataBars[5] = new Shape(coor[0] + MAX_BAR_SIZE + SEP_WIDTH, yline,
            (int)(MAX_BAR_SIZE * percents[6]), 10);
        dataBars[5].setBackgroundColor(Color.YELLOW);
        dataBars[5].setBackgroundColor(Color.YELLOW);
        yline += 10;

        dataBars[6] = new Shape(coor[0] + MAX_BAR_SIZE - (int)(MAX_BAR_SIZE
            * percents[3]), yline, (int)(MAX_BAR_SIZE * percents[3]), 10);
        dataBars[6].setBackgroundColor(Color.GREEN);
        dataBars[6].setBackgroundColor(Color.GREEN);
        dataBars[7] = new Shape(coor[0] + MAX_BAR_SIZE + SEP_WIDTH, yline,
            (int)(MAX_BAR_SIZE * percents[7]), 10);
        dataBars[7].setBackgroundColor(Color.GREEN);
        dataBars[7].setBackgroundColor(Color.GREEN);

        window.addShape(separator);
        for (Shape s : dataBars) {
            window.addShape(s);
        }
        window.addShape(songData[0]);
        window.addShape(songData[songDataSelector]);
    }


    /**
     * Represent the glyphs by hobby, major, or region.
     * 
     * @param type
     *            The type of represent
     * @return double[] The data updated according to type
     */
    public double[] determineRepresentData(Glyph g, RepresentationEnum type) {
        if (type == RepresentationEnum.HOBBY) {
            return g.percents(type);
        }
        else if (type == RepresentationEnum.MAJOR) {
            return g.percents(type);
        }
        else if (type == RepresentationEnum.STATE) {
            return g.percents(type);
        }
        return null;
    }
}
