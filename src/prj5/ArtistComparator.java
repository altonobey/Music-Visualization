// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

import java.util.Comparator;

/**
 * Comparator to compare the artists of two songs.
 * 
 * @author Ahmed Altonobey (ahmedalt)
 * @version 2018.04.26
 */
public class ArtistComparator implements Comparator<Song> {

    /**
     * Compare the given songs' artists and return a numerical result.
     * 
     * @param song1
     *            The first song for comparison
     * @param song2
     *            The second song for comparison
     * @return int An integer result based on the comparison
     */
    @Override
    public int compare(Song song1, Song song2) {
        return song1.getArtist().compareTo(song2.getArtist());
    }
}
