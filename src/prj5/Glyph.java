// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

/**
 * Each Glyph object contains the core data that is used in the program. Per
 * each Glyph, there is a Song object and various LinkedList objects containing
 * the Student objects relating to that given Song (i.e. for each student that
 * responded to the given song in the survey, add them to the appropriate list
 * based on whether or not they heard the song and whether or not they liked the
 * song). These values can be sorted depending on the desired category into
 * percentage values
 * 
 * @author Ahmed Altonobey (ahmedalt)
 * @version 2018.04.26
 */
public class Glyph {
    private Song song;


    /**
     * Create a new Glyph object with the given Song parameter.
     * 
     * @param song
     *            create a new Glyph with the given Song parameter
     */
    public Glyph(Song song) {
        this.song = song;
    }


    /**
     * Calculate the percentages by Hobby category of the total Student data.
     * 
     * @param rep
     *            The representation to get the percentages for
     * 
     * @return a new array of double values containing the percentages by
     *         category
     */
    public double[] percents(RepresentationEnum rep) {
        double[] percentages = new double[8];

        int[][] array = null;

        if (rep == RepresentationEnum.HOBBY) {
            array = song.getHobbyMultArray();
        }

        if (rep == RepresentationEnum.MAJOR) {
            array = song.getMajorMultArray();
        }

        if (rep == RepresentationEnum.STATE) {
            array = song.getLocationMultArray();
        }

        // heard
        if (array[0][0] + array[1][0] == 0) {
            percentages[0] = 0;
        }
        else {
            percentages[0] = ((double)array[0][0] / (double)(array[0][0]
                + array[1][0]));
        }

        // heard
        if (array[0][1] + array[1][1] == 0) {
            percentages[1] = 0;
        }
        else {
            percentages[1] = ((double)array[0][1] / (double)(array[0][1]
                + array[1][1]));
        }

        // heard
        if (array[0][2] + array[1][2] == 0) {
            percentages[2] = 0;
        }
        else {
            percentages[2] = ((double)array[0][2] / (double)(array[0][2]
                + array[1][2]));
        }

        // heard
        if (array[0][3] + array[1][3] == 0) {
            percentages[3] = 0;
        }
        else {
            percentages[3] = ((double)array[0][3] / (double)(array[0][3]
                + array[1][3]));
        }

        // liked
        if (array[2][0] + array[3][0] == 0) {
            percentages[4] = 0;
        }
        else {
            percentages[4] = ((double)array[2][0] / (double)(array[2][0]
                + array[3][0]));
        }

        // liked
        if (array[2][1] + array[3][1] == 0) {
            percentages[5] = 0;
        }
        else {
            percentages[5] = ((double)array[2][1] / (double)(array[2][1]
                + array[3][1]));
        }

        // liked
        if (array[2][2] + array[3][2] == 0) {
            percentages[6] = 0;
        }
        else {
            percentages[6] = ((double)array[2][2] / (double)(array[2][2]
                + array[3][2]));
        }

        // liked
        if (array[2][3] + array[3][3] == 0) {
            percentages[7] = 0;
        }
        else {
            percentages[7] = ((double)array[2][3] / (double)(array[2][3]
                + array[3][3]));
        }
        return percentages;
    }


    /**
     * Get the Song object being used by the current Glyph.
     * 
     * @return the Song object being used by the current Glyph
     */
    public Song getSong() {
        return this.song;
    }
}
