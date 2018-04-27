// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

import java.util.Comparator;

/**
 * Comparator to compare the titles of two songs.
 * 
 * @author Ahmed Altonobey (ahmedalt)
 * @version 2018.04.26
 */
public class TitleComparator implements Comparator<Song> {

    /**
     * This method compares the song's artist.l
     * 
     * @param title1
     *            The first song title for comparison
     * @param title2
     *            The second song title for comparison
     * @return int An integer result based on the comparison
     */
    @Override
    public int compare(Song title1, Song title2) {
        return title1.getTitle().compareTo(title2.getTitle());
    }
}
