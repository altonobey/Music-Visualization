// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

import java.util.Comparator;

/**
 * Comparator to compare the genre of two songs.
 * 
 * @author Ahmed Altonobey (ahmedalt)
 * @version 2018.04.26
 */
public class GenreComparator implements Comparator<Song> {

    /**
     * This method compares the song's genre.
     * 
     * @param genre1
     *            The first song genre for comparison
     * @param genre2
     *            The second song genre for comparison
     * @return int An integer result based on the comparison
     */
    @Override
    public int compare(Song genre1, Song genre2) {
        return genre1.getGenre().compareTo(genre2.getGenre());
    }
}
