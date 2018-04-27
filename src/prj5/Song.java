// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

/**
 * Each Song object contains the data given by a text file of songs separated
 * into individual songs by title. The title, artist, genre, and year are stored
 * to be used later when sorting student responses into their respective lists.
 * 
 * @author Ahmed Altonobey (ahmedalt)
 * @version 2018.04.26
 */
public class Song {
    private String artist;
    private String title;
    private int year;
    private String genre;
    private int[][] major;
    private int[][] hobby;
    private int[][] location;


    /**
     * Create a new Song object with the given title, artist, genre, and year
     * parameters.
     * 
     * @param title
     *            The song's title
     * @param artist
     *            The song's artist
     * @param genre
     *            The genre of the song
     * @param year
     *            The release year of the song
     * @throws IllegalArgumentException
     *             if an invalid input is given
     */
    public Song(String title, String artist, int year, String genre) {
        if (title.equals("") || artist.equals("") || year < 0 || genre.equals(
            "")) {
            throw new IllegalArgumentException(
                "One of the input strings is empty or"
                    + "the input year is negative.");
        }
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
        // songs = new DoublyLinkedList<Song>();
        major = new int[4][4];
        hobby = new int[4][4];
        location = new int[4][4];
    }


    /**
     * Return the song's title.
     * 
     * @return String the song's title
     */
    public String getTitle() {
        return title;
    }


    /**
     * Return the song's artist.
     * 
     * @return String the song's artist
     */
    public String getArtist() {
        return artist;
    }


    /**
     * Return the song's release year.
     * 
     * @return int the song's release year
     */
    public int getYear() {
        return year;
    }


    /**
     * Return the song's genre.
     * 
     * @return String the song's genre
     */
    public String getGenre() {
        return genre;
    }


    /**
     * Convert the fields into a string.
     * 
     * @return String The string form of the song
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(title);
        builder.append(", ");
        builder.append(artist);
        builder.append(", ");
        builder.append(year);
        builder.append(", ");
        builder.append(genre);
        builder.append("]");
        return builder.toString();
    }


    /**
     * Compare the given object parameter to the calling object.
     * 
     * @param obj
     *            The object to compare
     * @return int value of the comparison
     * @throws IllegalArgumentException
     *             if the object null or not a song
     */
    public int compareTo(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (obj.getClass() != this.getClass()) {
            throw new IllegalArgumentException();
        }
        Song song = (Song)obj;
        int value = new TitleComparator().compare(this, song);
        if (value == 0) {
            value = new ArtistComparator().compare(this, song);
        }
        if (value == 0) {
            value = new YearComparator().compare(this, song);
        }
        if (value == 0) {
            value = new GenreComparator().compare(this, song);
        }
        return value;
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
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Song song = (Song)obj;
            return (song.title == this.title && song.artist == this.artist
                && song.year == this.year && song.genre == this.genre);
        }
        return false;
    }


    /**
     * Increment the selected array location based on the inputs.
     * 
     * @param category
     *            The array to increment
     * @param type1
     *            The row location of the array to increment
     * @param type2
     *            The column location of the array to increment
     */
    public void increment(int category, int type1, int type2) {
        int[][] array = null;
        switch (category) {
            case 0:
                array = this.major;
                break;
            case 1:
                array = this.hobby;
                break;
            case 2:
                array = this.location;
                break;
            default:
                array = null;
                break;
        }

        if (array != null) {
            array[type1][type2]++;
        }
    }


    /**
     * Getter method of the major array
     * 
     * @return int[][] The major array
     */
    public int[][] getMajorMultArray() {
        return major;
    }


    /**
     * Getter method of the hobby array
     * 
     * @return int[][] The hobby array
     */
    public int[][] getHobbyMultArray() {
        return hobby;
    }


    /**
     * Getter method of the location array
     * 
     * @return int[][] The location array
     */
    public int[][] getLocationMultArray() {
        return location;
    }
}
