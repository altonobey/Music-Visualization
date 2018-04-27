// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

/**
 * Test class for the method of the glyph class.
 * 
 * @author Ahmed Altonobey (ahmedalt)
 * @version 2018.04.26
 */
public class GlyphTest extends student.TestCase {
    private Glyph g;
    private Song song;


    /**
     * Test setup.
     */
    public void setUp() {
        song = new Song("a", "a", 2018, "a");
        g = new Glyph(song);
        song.increment(0, 0, 0);
        song.increment(0, 0, 1);
        song.increment(0, 0, 2);
        song.increment(0, 0, 3);
        song.increment(0, 2, 0);
        song.increment(0, 2, 1);
        song.increment(0, 2, 2);
        song.increment(0, 2, 3);
    }


    /**
     * Test the percents method.
     */
    public void testPercents() {
        g.percents(RepresentationEnum.HOBBY);
        assertEquals(4, song.getHobbyMultArray().length);
        g.percents(RepresentationEnum.MAJOR);
        assertEquals(4, song.getMajorMultArray().length);
        g.percents(RepresentationEnum.STATE);
        assertEquals(4, song.getLocationMultArray().length);
    }


    /**
     * Test the getSong method.
     */
    public void testGetSong() {
        assertEquals("[a, a, 2018, a]", g.getSong().toString());
    }
}
