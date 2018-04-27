// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

/**
 * Tests the song class.
 * 
 * @author Ahmed Altonobey
 * @version 2016.04.26
 */
public class SongTest extends student.TestCase {
    private Song song1;
    private Song song2;
    private Song song3;


    /**
     * Set up the testing environment.
     */
    public void setUp() {
        song1 = new Song("The Ocean", "Led Zeppelin", 1973, "rock");
        song2 = new Song("Gypsy Eyes", "The Jimi Hendrix Experience", 1968,
            "psychedelic rock");
        song3 = new Song("Warlocks", "Red Hot Chili Peppers", 2006,
            "funk rock");
    }


    // Begin testing here

    /**
     * Test the constructor.
     */
    public void testConstructor() {
        assertNotNull(song1);
        assertNotNull(song2);
        assertNotNull(song3);

        assertNotNull(song1.getTitle());
        assertNotNull(song2.getTitle());
        assertNotNull(song3.getTitle());

        assertNotNull(song1.getArtist());
        assertNotNull(song2.getArtist());
        assertNotNull(song3.getArtist());

        assertNotNull(song1.getGenre());
        assertNotNull(song2.getGenre());
        assertNotNull(song3.getGenre());

        assertNotNull(song1.getYear());
        assertNotNull(song2.getYear());
        assertNotNull(song3.getYear());

        Exception thrown = null;

        try {
            new Song("", "a", 0, "g");
        }
        catch (Exception e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        thrown = null;

        try {
            new Song("a", "", 0, "g");
        }
        catch (Exception e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        thrown = null;

        try {
            new Song("a", "a", 0, "");
        }
        catch (Exception e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        thrown = null;

        try {
            new Song("a", "a", -1, "g");
        }
        catch (Exception e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Test the method compareTo().
     */
    public void testCompareTo() {
        assertEquals(13, song1.compareTo(song2));
        assertEquals(-16, song2.compareTo(song3));
        assertEquals(0, song1.compareTo(song1));
        assertEquals(3, song3.compareTo(song1));

        Exception thrown = null;

        try {
            Song test = null;
            song1.compareTo(test);
        }
        catch (Exception e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        thrown = null;

        try {
            Object test = new Object();
            song1.compareTo(test);
        }
        catch (Exception e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * Test the method equals().
     */
    public void testEquals() {
        // different song
        assertFalse(song1.equals(song2));
        Song nullSong = null;
        // null song
        assertFalse(song1.equals(nullSong));
        // itself
        assertTrue(song1.equals(song1));
        // different song name
        Song s1 = new Song("a", "Led Zeppelin", 1973, "rock");
        assertFalse(song1.equals(s1));
        // different artist
        Song s2 = new Song("The Ocean", "a", 1973, "rock");
        assertFalse(song1.equals(s2));
        // different year
        Song s3 = new Song("The Ocean", "Led Zeppelin", 1, "rock");
        assertFalse(song1.equals(s3));
        // different genre
        Song s4 = new Song("The Ocean", "Led Zeppelin", 1973, "a");
        assertFalse(song1.equals(s4));
        // same song
        Song s5 = new Song("The Ocean", "Led Zeppelin", 1973, "rock");
        assertTrue(song1.equals(s5));
        // different object
        assertFalse(song1.equals(new Object()));
    }


    /**
     * Test the method toString().
     */
    public void testToString() {
        assertEquals("[The Ocean, Led Zeppelin, 1973, rock]", song1.toString());
        assertEquals(
            "[Gypsy Eyes, The Jimi Hendrix Experience, 1968, psychedelic rock]",
            song2.toString());
        assertEquals("[Warlocks, Red Hot Chili Peppers, 2006, funk rock]", song3
            .toString());
    }


    /**
     * Test the getter methods.
     */
    public void testGetters() {
        assertEquals("The Ocean", song1.getTitle());
        assertEquals("Gypsy Eyes", song2.getTitle());
        assertEquals("Warlocks", song3.getTitle());

        assertEquals("Led Zeppelin", song1.getArtist());
        assertEquals("The Jimi Hendrix Experience", song2.getArtist());
        assertEquals("Red Hot Chili Peppers", song3.getArtist());

        assertEquals("rock", song1.getGenre());
        assertEquals("psychedelic rock", song2.getGenre());
        assertEquals("funk rock", song3.getGenre());

        assertEquals(1973, song1.getYear());
        assertEquals(1968, song2.getYear());
        assertEquals(2006, song3.getYear());
    }


    /**
     * Test the increment and the getter methods.
     */
    public void testIncrement() {
        song1.increment(0, 0, 0);
        assertEquals(4, song1.getMajorMultArray().length);
        song1.increment(1, 0, 0);
        assertEquals(4, song1.getHobbyMultArray().length);
        song1.increment(2, 0, 0);
        assertEquals(4, song1.getLocationMultArray().length);
        song1.increment(3, 0, 0);
        assertEquals(4, song1.getMajorMultArray().length);
        assertEquals(4, song1.getHobbyMultArray().length);
        assertEquals(4, song1.getLocationMultArray().length);

    }
}
