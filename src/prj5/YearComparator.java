// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

import java.util.Comparator;

/**
 * Comparator to compare the years of two songs.
 * 
 * @author Ahmed Altonobey (ahmedalt)
 * @version 2018.04.26
 */
public class YearComparator implements Comparator<Song> {

    /**
     * This method compares the song's artist.l
     * 
     * @param year1
     *            The first song release year for comparison
     * @param year2
     *            The second song release year for comparison
     * @return int An integer result based on the comparison
     */
    @Override
    public int compare(Song year1, Song year2) {
        return year1.getYear() - year2.getYear();
    }
}
