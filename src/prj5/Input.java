// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Program driver; the Input class receives the CSV files containing the song
 * data and the student response data. The data is sorted into individual Glyphs
 * to be used by the front-end.
 * 
 * @author Ahmed Altonobey (ahmedalt)
 * @version 2018.04.26
 */
public class Input {
    private static DoublyLinkedList<Song> songsList =
        new DoublyLinkedList<Song>();
    private static DoublyLinkedList<Glyph> glyphsList =
        new DoublyLinkedList<Glyph>();

    private static Scanner scan;
    private static String[] songDetails;
    private static String[] studentDetails;
    private static int heardIndex;
    private static int likedIndex;

    private static final int HEARD = 0;
    private static final int NOTHEARD = 1;
    private static final int LIKED = 2;
    private static final int NOTLIKED = 3;

    private static final int CS = 0;
    private static final int OTHERENG = 1;
    private static final int MATH = 2;
    private static final int OTHERMAJOR = 3;

    private static final int NORTHEAST = 0;
    private static final int SOUTHEAST = 1;
    private static final int OUTSIDEUS = 2;
    private static final int OTHERUS = 3;

    private static final int READ = 0;
    private static final int ARTS = 1;
    private static final int SPORTS = 2;
    private static final int MUSIC = 3;

    private static HobbyEnum hobby = null;
    private static StateEnum location = null;
    private static MajorEnum major = null;


    /**
     * The main method for the program. If two arguments are passed, try to read
     * in the two arguments as new files. If no arguments are given, use default
     * text file strings.
     * 
     * @param songFileName
     *            The name of the song file
     * @param surveyFileName
     *            The name of the survey file
     */
    public Input(String songFileName, String surveyFileName) {
        readIn(songFileName, surveyFileName);
    }


    /**
     * Read in the given files containing song data and student response data.
     * 
     * @param songs
     *            - a text file containing the song data
     * @param students
     *            - a text file containing the student data
     */
    public static void readIn(String songs, String students) {
        readInStudents(students, readInSongs(songs));
    }


    /**
     * When a valid text file containing song data is passed in, create a new
     * glyph to be added to the LinkedList of glyphs containing the various
     * songs.
     * 
     * @param songs
     *            a text file containing the song data
     * @return DoublyLinkedList<Song> a LinkedList of Glyph objects
     * @throws FileNotFoundException
     *             if no file is received
     */
    private static DoublyLinkedList<Song> readInSongs(String songs) {
        File fileName = new File(songs);
        try {
            scan = new Scanner(fileName);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line != null && !line.equals("") && !line.startsWith("Song")) {
                songDetails = line.split(",");
                String title = songDetails[0];
                String artist = songDetails[1];
                int year = Integer.parseInt(songDetails[2]);
                String genre = songDetails[3];
                songsList.add(new Song(title, artist, year, genre));
            }
        }
        scan.close();
        return songsList;
    }


    /**
     * Sort method that sorts the songs based on the user selection.
     * 
     * @param type
     *            The order in which to order the songs by
     * @return DoublyLinkedList<Glyph> The sorted songs in glyphs
     */
    public static DoublyLinkedList<Glyph> sort(LegendEnum type) {
        DoublyLinkedList<Glyph> gList = new DoublyLinkedList<Glyph>();
        if (type == LegendEnum.GENRE) {
            songsList.sort(new GenreComparator());
            for (Song s : songsList) {
                gList.add(new Glyph(s));
            }
        }
        else if (type == LegendEnum.TITLE) {
            songsList.sort(new TitleComparator());
            for (Song s : songsList) {
                gList.add(new Glyph(s));
            }
        }
        else if (type == LegendEnum.ARTIST) {
            songsList.sort(new ArtistComparator());
            for (Song s : songsList) {
                gList.add(new Glyph(s));
            }
        }
        else if (type == LegendEnum.YEAR) {
            songsList.sort(new YearComparator());
            for (Song s : songsList) {
                gList.add(new Glyph(s));
            }
        }
        return gList;
    }


    /**
     * When a valid text file containing student response data is passed in,
     * separate the given data into their respective glyphs based on the
     * corresponding songs.
     * 
     * @param students
     *            a text file containing the song data
     * @param songs
     *            the LinkedList of glyphs to separate the response data
     *            into
     * @throws FileNotFoundException
     *             if no file is received
     */
    private static void readInStudents(
        String students,
        DoublyLinkedList<Song> sList) {
        File fileName = new File(students);
        try {
            scan = new Scanner(fileName);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line != null && !line.equals("") && line.split(
                ",").length > 4) {

                studentDetails = line.split(",", -1);

                switch (studentDetails[2]) {
                    case "Math or CMDA":
                        major = MajorEnum.MATH;
                        break;
                    case "Computer Science":
                        major = MajorEnum.CS;
                        break;
                    case "Other Engineering":
                        major = MajorEnum.OTHERENG;
                        break;
                    case "Other":
                        major = MajorEnum.OTHERMAJOR;
                        break;
                    default:
                        break;
                }

                switch (studentDetails[3]) {
                    case "Southeast":
                        location = StateEnum.SOUTHEAST;
                        break;
                    case "Northeast":
                        location = StateEnum.NORTHEAST;
                        break;
                    case "United States (other than Southeast or Northwest)":
                        location = StateEnum.OTHERUS;
                        break;
                    case "Outside of United States":
                        location = StateEnum.OUTSIDEUS;
                        break;
                    default:
                        break;
                }

                switch (studentDetails[4]) {
                    case "sports":
                        hobby = HobbyEnum.SPORTS;
                        break;
                    case "music":
                        hobby = HobbyEnum.MUSIC;
                        break;
                    case "reading":
                        hobby = HobbyEnum.READ;
                        break;
                    case "art":
                        hobby = HobbyEnum.ARTS;
                        break;
                    default:
                        break;
                }
                determineWhichArrayToAdd(sList);
            }
        }
        scan.close();
    }


    private static void determineWhichArrayToAdd(DoublyLinkedList<Song> sList) {
        heardIndex = 5;
        likedIndex = 6;

        for (Song song : sList) {
            int type1 = -1;
            int type2 = -1;

            // Major
            if (major == MajorEnum.MATH) {
                type1 = 0;
                type2 = MATH;
            }
            else if (major == MajorEnum.CS) {
                type1 = 0;
                type2 = CS;
            }
            else if (major == MajorEnum.OTHERENG) {
                type1 = 0;
                type2 = OTHERENG;
            }
            else if (major == MajorEnum.OTHERMAJOR) {
                type1 = 0;
                type2 = OTHERMAJOR;
            }

            if (type1 != -1 && type2 != -1) {
                addToMultArray(song, type1, type2);
            }

            // Hobby
            if (hobby == HobbyEnum.READ) {
                type1 = 1;
                type2 = READ;
            }
            else if (hobby == HobbyEnum.ARTS) {
                type1 = 1;
                type2 = ARTS;
            }
            else if (hobby == HobbyEnum.SPORTS) {
                type1 = 1;
                type2 = SPORTS;
            }
            else if (hobby == HobbyEnum.MUSIC) {
                type1 = 1;
                type2 = MUSIC;
            }

            if (type1 != -1 && type2 != -1) {
                addToMultArray(song, type1, type2);
            }

            // Location
            if (location == StateEnum.NORTHEAST) {
                type1 = 2;
                type2 = NORTHEAST;
            }
            else if (location == StateEnum.SOUTHEAST) {
                type1 = 2;
                type2 = SOUTHEAST;
            }
            else if (location == StateEnum.OUTSIDEUS) {
                type1 = 2;
                type2 = OUTSIDEUS;
            }
            else if (location == StateEnum.OTHERUS) {
                type1 = 2;
                type2 = OTHERUS;
            }

            if (type1 != -1 && type2 != -1) {
                addToMultArray(song, type1, type2);
            }

            heardIndex = heardIndex + 2;
            likedIndex = likedIndex + 2;
        }
    }


    /**
     * This method determines whether to increment heard/not heard and liked/not
     * part in the 2D and then calls the helper method increment in the Song
     * class to increment the respective location in the 2D array.
     * 
     * @param song
     *            The song
     * @param category
     *            The type of Enum
     * @param type2
     *            The Enum
     */
    private static void addToMultArray(Song song, int category, int type2) {
        Song currentSong = song;

        String studentHeard = "";
        String studentLiked = "";

        if (likedIndex < studentDetails.length) {
            studentHeard = studentDetails[heardIndex];
            studentLiked = studentDetails[likedIndex];
        }

        // Heard or not heard
        if (studentHeard.equals("Yes")) {
            currentSong.increment(category, HEARD, type2);
        }
        else if (studentHeard.equals("No")) {
            currentSong.increment(category, NOTHEARD, type2);
        }

        // Liked or not liked
        if (studentLiked.equals("Yes")) {
            currentSong.increment(category, LIKED, type2);
        }
        else if (studentLiked.equals("No")) {
            currentSong.increment(category, NOTLIKED, type2);
        }
    }


    public DoublyLinkedList<Glyph> getGlyphsList() {
        return glyphsList;
    }
}
