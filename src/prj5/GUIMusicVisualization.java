// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * GUIVisualization window.
 * 
 * @author Ahmed Altonobey (ahmedalt)
 * @version 2018.04.26
 */
public class GUIMusicVisualization {
    private Window window;
    private RepresentationEnum represent;
    private TextShape notSorted;
    private TextShape[] shapeArray;
    private int width;
    private int height;
    private Button previous;
    private Button next;
    private Button title;
    private Button artist;
    private Button genre;
    private Button year;
    private Button hobby;
    private Button major;
    private Button state;
    private Button quit;

    private GUIGlyph gui;


    /**
     * builds the window
     *
     * @param glyphs
     *            glyphs to be built
     */
    public GUIMusicVisualization(DoublyLinkedList<Glyph> glyphs) {
        gui = new GUIGlyph(glyphs);

        window = new Window("Music Visualization");

        updateWindowSize();

        represent = RepresentationEnum.HOBBY;
        notSorted = new TextShape(width / 2, height / 2,
            "Please select how to represent songs");
        previous = new Button("<< Previous");
        next = new Button("Next >>");
        title = new Button("Sort By Song Title");
        artist = new Button("Sort By Artist Name");
        genre = new Button("Sort By Genre");
        year = new Button("Sort By Release Year");
        hobby = new Button("Represent Hobby");
        state = new Button("Represent Region");
        major = new Button("Represent Major");
        quit = new Button("Quit");
        shapeArray = new TextShape[12];

        previous.onClick(this, "clickedPrevious");
        next.onClick(this, "clickedNext");
        title.onClick(this, "clickedTitle");
        artist.onClick(this, "clickedArtist");
        genre.onClick(this, "clickedGenre");
        year.onClick(this, "clickedYear");
        hobby.onClick(this, "clickedHobby");
        state.onClick(this, "clickedState");
        major.onClick(this, "clickedMajor");
        quit.onClick(this, "clickedQuit");

        window.addButton(previous, WindowSide.NORTH);
        window.addButton(artist, WindowSide.NORTH);
        window.addButton(title, WindowSide.NORTH);
        window.addButton(year, WindowSide.NORTH);
        window.addButton(genre, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);
        window.addButton(hobby, WindowSide.SOUTH);
        window.addButton(major, WindowSide.SOUTH);
        window.addButton(state, WindowSide.SOUTH);
        window.addButton(quit, WindowSide.SOUTH);
        if (!GUIGlyph.hasNext()) {
            next.disable();
        }
        previous.disable();

        notSorted.setBackgroundColor(Color.RED);

        buildShapeArray();
        gui.display(window);
        buildLegend(RepresentationEnum.HOBBY);
    }


    /**
     * builds the legend
     *
     * @param sortBy
     *            What the songs will be sorted by
     */
    public void buildLegend(RepresentationEnum sortBy) {

        updateWindowSize();

        // build box around legend and general info
        window.addShape(new Shape(width - 120, height - 200, 120, 5,
            Color.BLACK));
        window.addShape(new Shape(width - 5, height - 200, 5, 200,
            Color.BLACK));
        window.addShape(new Shape(width - 120, height - 5, 120, 5,
            Color.BLACK));
        window.addShape(new Shape(width - 120, height - 200, 5, 200,
            Color.BLACK));

        // build lower portion of legend
        TextShape tempTextShape = new TextShape(width - 115, height - 195,
            getLegendType(sortBy) + " Legend");
        tempTextShape.setBackgroundColor(Color.WHITE);
        Shape tempSeperator = new Shape(width - 55, height - 35, 5, 30,
            Color.BLACK);
        window.addShape(tempTextShape);
        tempTextShape = new TextShape(width - 105, height - 30, "Heard");
        tempTextShape.setBackgroundColor(Color.WHITE);
        window.addShape(tempTextShape);
        window.addShape(tempSeperator);
        tempTextShape = new TextShape(width - 45, height - 30, "Likes");
        tempTextShape.setBackgroundColor(Color.WHITE);
        window.addShape(tempTextShape);
        tempTextShape = new TextShape(width - 90, height - 50, "Song Title");
        tempTextShape.setBackgroundColor(Color.WHITE);
        window.addShape(tempTextShape);

        switch (represent) {
            case HOBBY:
                for (int i = 0; i < 4; i++) {
                    window.addShape(shapeArray[i]);
                }
                break;
            case MAJOR:
                for (int i = 4; i < 8; i++) {
                    window.addShape(shapeArray[i]);
                }
                break;
            case STATE:
                for (int i = 8; i < 12; i++) {
                    window.addShape(shapeArray[i]);
                }
                break;
            default:
                window.addShape(new TextShape(1, 1, "something random"));
        }

        if (GUIGlyph.hasNext()) {
            next.enable();
        }
        if (GUIGlyph.hasPrevious()) {
            previous.enable();
        }
    }


    /**
     * clicked the previous button
     * 
     * @param button
     *            The button
     */
    public void clickedPrevious(Button button) {
        updateWindowSize();
        buildShapeArray();
        if (!GUIGlyph.hasPrevious()) {
            previous.disable();
        }
        next.enable();
        gui.previousPage(window);
        gui.display(window);
        buildLegend(represent);
        if (!GUIGlyph.hasPrevious()) {
            previous.disable();
        }
    }


    /**
     * clicked the next button
     * 
     * @param button
     *            The button
     */
    public void clickedNext(Button button) {
        updateWindowSize();
        buildShapeArray();
        if (!GUIGlyph.hasNext()) {
            next.disable();
        }
        previous.enable();
        gui.nextPage(window);
        gui.display(window);
        buildLegend(represent);
        if (!GUIGlyph.hasNext()) {
            next.disable();
        }
    }


    /**
     * clicked the artist button
     * 
     * @param button
     *            The button
     */
    public void clickedArtist(Button button) {
        updateWindowSize();
        buildShapeArray();
        gui.sortGlyphs(LegendEnum.ARTIST);
        gui.display(window);
        buildLegend(represent);
    }


    /**
     * clicked the title button
     * 
     * @param button
     *            The button
     */
    public void clickedTitle(Button button) {
        updateWindowSize();
        buildShapeArray();
        gui.sortGlyphs(LegendEnum.TITLE);
        gui.display(window);
        buildLegend(represent);
    }


    /**
     * clicked the year button
     * 
     * @param button
     *            The button
     */
    public void clickedYear(Button button) {
        updateWindowSize();
        buildShapeArray();
        gui.sortGlyphs(LegendEnum.YEAR);
        gui.display(window);
        buildLegend(represent);
    }


    /**
     * clicked the genre button
     * 
     * @param button
     *            The button
     */
    public void clickedGenre(Button button) {
        updateWindowSize();
        buildShapeArray();
        gui.sortGlyphs(LegendEnum.YEAR);
        gui.display(window);
        buildLegend(represent);
    }


    /**
     * clicked the hobby button
     * 
     * @param button
     *            The button
     */
    public void clickedHobby(Button button) {
        GUIGlyph.sortStat(RepresentationEnum.HOBBY);
        updateWindowSize();
        buildShapeArray();
        gui.display(window);
        buildLegend(RepresentationEnum.HOBBY);
    }


    /**
     * clicked the major button
     * 
     * @param button
     *            The button
     */
    public void clickedMajor(Button button) {
        GUIGlyph.sortStat(RepresentationEnum.MAJOR);
        updateWindowSize();
        buildShapeArray();
        gui.display(window);
        buildLegend(RepresentationEnum.MAJOR);
    }


    /**
     * clicked the region button
     * 
     * @param button
     *            The button
     */
    public void clickedState(Button button) {
        GUIGlyph.sortStat(RepresentationEnum.STATE);
        updateWindowSize();
        buildShapeArray();
        gui.display(window);
        buildLegend(RepresentationEnum.STATE);
    }


    /**
     * tests the quit button
     * 
     * @param button
     *            The button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Get the legend type.
     *
     * @param sortBy
     *            The order to sort the songs by
     *
     * @return String the legend type
     */
    private String getLegendType(RepresentationEnum sortBy) {
        String RepType = "";
        switch (sortBy) {
            case HOBBY:
                RepType = "Hobby";
                break;
            case MAJOR:
                RepType = "Major";
                break;
            case STATE:
                RepType = "STATE";
                break;
            default:
                RepType = "Unsorted";
                break;
        }
        return RepType;
    }


    /**
     * builds the shapeArray, 0-3 hobby, 4-7 major, 8-11 region.
     */
    private void buildShapeArray() {
        updateWindowSize();
        // 0 through 3 hobby
        TextShape text = null;
        text = new TextShape(width - 115, height - 170, "Read");
        text.setBackgroundColor(Color.WHITE);
        text.setForegroundColor(Color.MAGENTA);
        shapeArray[0] = text;
        text = new TextShape(width - 115, height - 140, "Art");
        text.setBackgroundColor(Color.WHITE);
        text.setForegroundColor(Color.BLUE);
        shapeArray[1] = text;
        text = new TextShape(width - 115, height - 110, "Sports");
        text.setBackgroundColor(Color.WHITE);
        text.setForegroundColor(Color.YELLOW);
        shapeArray[2] = text;
        text = new TextShape(width - 115, height - 80, "Music");
        text.setBackgroundColor(Color.WHITE);
        text.setForegroundColor(Color.GREEN);
        shapeArray[3] = text;

        // 4 through 7 major
        text = new TextShape(width - 115, height - 170, "Comp Sci");
        text.setBackgroundColor(Color.WHITE);
        text.setForegroundColor(Color.MAGENTA);
        shapeArray[4] = text;
        text = new TextShape(width - 115, height - 140, "Math/CDMA");
        text.setBackgroundColor(Color.WHITE);
        text.setForegroundColor(Color.BLUE);
        shapeArray[5] = text;
        text = new TextShape(width - 115, height - 110, "Other Eng");
        text.setBackgroundColor(Color.WHITE);
        text.setForegroundColor(Color.YELLOW);
        shapeArray[6] = text;
        text = new TextShape(width - 115, height - 80, "Other");
        text.setBackgroundColor(Color.WHITE);
        text.setForegroundColor(Color.GREEN);
        shapeArray[7] = text;

        // 8 through 11 region
        text = new TextShape(width - 115, height - 170, "Southeast");
        text.setBackgroundColor(Color.WHITE);
        text.setForegroundColor(Color.MAGENTA);
        shapeArray[8] = text;
        text = new TextShape(width - 115, height - 140, "Northeast");
        text.setBackgroundColor(Color.WHITE);
        text.setForegroundColor(Color.BLUE);
        shapeArray[9] = text;
        text = new TextShape(width - 115, height - 110, "US(Other)");
        text.setBackgroundColor(Color.WHITE);
        text.setForegroundColor(Color.YELLOW);
        shapeArray[10] = text;
        text = new TextShape(width - 115, height - 80, "non-US");
        text.setBackgroundColor(Color.WHITE);
        text.setForegroundColor(Color.GREEN);
        shapeArray[11] = text;
    }


    /**
     * Update the window.
     */
    private void updateWindowSize() {
        height = window.getGraphPanelHeight();
        width = window.getGraphPanelWidth();
    }
}
