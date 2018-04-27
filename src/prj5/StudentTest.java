// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

/**
 * Test the methods of the student class.
 * 
 * @author Ahmed Altonobey (ahmedalt)
 * @version 2018.04.26
 */
public class StudentTest extends student.TestCase {
    private Student student1;
    private Student student2;
    private Student student3;


    /**
     * Set up the testing environment.
     */
    public void setUp() {
        student1 = new Student(MajorEnum.CS, StateEnum.NORTHEAST,
            HobbyEnum.ARTS);
        student2 = new Student(MajorEnum.OTHERENG, StateEnum.OUTSIDEUS,
            HobbyEnum.MUSIC);
        student3 = new Student(MajorEnum.MATH, StateEnum.SOUTHEAST,
            HobbyEnum.READ);
    }


    // Begin testing here
    /**
     * Test the constructor.
     */
    public void testConstructor() {
        assertNotNull(student1);
        assertNotNull(student2);
        assertNotNull(student3);

        assertNotNull(student1.getMajor());
        assertNotNull(student2.getMajor());
        assertNotNull(student3.getMajor());

        assertNotNull(student1.getLocation());
        assertNotNull(student2.getLocation());
        assertNotNull(student3.getLocation());

        assertNotNull(student1.getHobby());
        assertNotNull(student2.getHobby());
        assertNotNull(student3.getHobby());
    }


    /**
     * Test the method compareTo().
     */
    public void testCompareTo() {
        assertEquals(0, student1.compareTo(student2));
        assertEquals(0, student2.compareTo(student3));
        assertEquals(0, student3.compareTo(student1));
        assertEquals(0, student1.compareTo(student1));
        Student nullStudent = null;
        Exception exception = null;
        try {
            student1.compareTo(nullStudent);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);
        Student doppleStudent = student1;
        assertEquals(0, student1.compareTo(doppleStudent));
        Student similarStudent = new Student(MajorEnum.CS, StateEnum.NORTHEAST,
            HobbyEnum.ARTS);
        assertEquals(0, student1.compareTo(similarStudent));
        Object notAStudent = new Object();
        exception = null;
        try {
            student1.compareTo(notAStudent);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * Test the method equals().
     */
    public void testEquals() {
        // different student
        assertFalse(student1.equals(student2));
        // null student
        Student nullStudent = null;
        assertFalse(student1.equals(nullStudent));
        // itself
        assertTrue(student1.equals(student1));
        // different major
        Student s1 = new Student(MajorEnum.MATH, StateEnum.NORTHEAST,
            HobbyEnum.ARTS);
        assertFalse(student1.equals(s1));
        // different region
        Student s2 = new Student(MajorEnum.CS, StateEnum.SOUTHEAST,
            HobbyEnum.ARTS);
        assertFalse(student1.equals(s2));
        // different hobby
        Student s3 = new Student(MajorEnum.CS, StateEnum.NORTHEAST,
            HobbyEnum.SPORTS);
        assertFalse(student1.equals(s3));
        // same student
        Student s5 = new Student(MajorEnum.CS, StateEnum.NORTHEAST,
            HobbyEnum.ARTS);
        assertTrue(student1.equals(s5));
        // other student
        assertFalse(student1.equals(new Object()));
    }


    /**
     * Test the method toString().
     */
    public void testToString() {
        assertEquals("[CS, NORTHEAST, ARTS]", student1.toString());
        assertEquals("[OTHERENG, OUTSIDEUS, MUSIC]", student2.toString());
        assertEquals("[MATH, SOUTHEAST, READ]", student3.toString());
    }


    /**
     * Test the getter methods.
     */
    public void testGetters() {
        assertEquals(MajorEnum.CS, student1.getMajor());
        assertEquals(MajorEnum.OTHERENG, student2.getMajor());
        assertEquals(MajorEnum.MATH, student3.getMajor());

        assertEquals(StateEnum.NORTHEAST, student1.getLocation());
        assertEquals(StateEnum.OUTSIDEUS, student2.getLocation());
        assertEquals(StateEnum.SOUTHEAST, student3.getLocation());

        assertEquals(HobbyEnum.ARTS, student1.getHobby());
        assertEquals(HobbyEnum.MUSIC, student2.getHobby());
        assertEquals(HobbyEnum.READ, student3.getHobby());
    }
}
