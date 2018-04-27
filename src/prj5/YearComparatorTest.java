// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

/**
 * Test the YearComparator class.
 * 
 * @author Ahmed Altonobey (ahmedalt)
 * @version 2018.04.26
 */
public class YearComparatorTest extends student.TestCase {
    private YearComparator year;


    /**
     * sets up for testing
     */
    public void setUp() {
        year = new YearComparator();
    }


    /**
     * tests the year comparator method
     */
    public void testYearComparator() {
        assertEquals(year.compare(new Song("All of Me", "John Legend", 2013,
            "R&B"), new Song("All of Me", "John Legend", 2013, "R&B")), 0);
        assertTrue(year.compare(new Song("Title1", "Artist1", 2019, "Genre1"),
            new Song("Title1", "Artist1", 2018, "Genre1")) > 0);
        assertTrue(year.compare(new Song("Title1", "Artist1", 2018, "Genre1"),
            new Song("Title1", "Artist1", 2019, "Genre1")) < 0);
    }
}
