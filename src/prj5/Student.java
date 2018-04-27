// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

/**
 * Each Student object contains the data given by a text file containing student
 * responses. The responses regarding major, region, and hobby are stored by
 * each object in the form of an enumeration to be used later while sorting.
 * 
 * @author Ahmed Altonobey (ahmedalt)
 * @version 2018.04.26
 */
public class Student {
    /**
     * Static list of Student objects to be updated while sorting.
     */
    private MajorEnum major;
    private StateEnum location;
    private HobbyEnum hobby;


    /**
     * Create a new Student object with the given MAJOR, REGION, and HOBBY
     * enumerators.
     * 
     * @param major
     *            A student's major
     * @param location
     *            A student's location
     * @param hobby
     *            A student's hobby
     */
    public Student(MajorEnum major, StateEnum location, HobbyEnum hobby) {
        this.major = major;
        this.location = location;
        this.hobby = hobby;
    }


    /**
     * Return the student's major.
     * 
     * @return the student's major
     */
    public MajorEnum getMajor() {
        return major;
    }


    /**
     * Return the student's region.
     * 
     * @return the student's region
     */
    public StateEnum getLocation() {
        return location;
    }


    /**
     * Return the student's hobby
     * 
     * @return the student's hobby
     */
    public HobbyEnum getHobby() {
        return hobby;
    }


    /**
     * Convert the Student object to a string of values within a set of
     * brackets.
     * 
     * @return the calling Student object in the form of a string
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(major);
        builder.append(", ");
        builder.append(location);
        builder.append(", ");
        builder.append(hobby);
        builder.append("]");
        return builder.toString();
    }


    /**
     * Compare the given object parameter to the calling object.
     * 
     * @param obj
     *            the object to compare with the calling object
     * @return the comparison result
     */
    public int compareTo(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (obj.getClass() != this.getClass()) {
            throw new IllegalArgumentException();
        }
        return 0;
    }


    /**
     * Check if the given object parameter is equal to the calling object.
     * 
     * @param obj
     *            - the object to compare with the calling object
     * @return true if the two objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() == this.getClass()) {
            Student student = (Student)obj;
            return (student.major == this.major
                && student.location == this.location
                && student.hobby == this.hobby);
        }
        return false;
    }
}
