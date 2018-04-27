// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Ahmed Altonobey (ahmedalt)

package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * Test class for the methods of the DoublyLinkedList class.
 * 
 * @author Ahmed Altonobey
 * @version 2018.04.26
 *
 */
public class DoublyLinkedListTest extends TestCase {
    /**
     * the list we will use
     */
    private DoublyLinkedList<String> list;
    private Iterator<String> iter;


    /**
     * run before every test case
     */
    @Override
    public void setUp() {
        list = new DoublyLinkedList<String>();
        iter = list.iterator();
    }


    /**
     * Tests that an IndexOutOfBounds exception is thrown when the index is
     * greater than or equal to size and less than zero
     */
    public void testRemoveException() {
        list.add("A");
        Exception e = null;
        try {
            list.remove(2);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.remove(-1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests that objects can be removed at the beginning and end and that the
     * size is changed
     */
    public void testRemoveIndex() {
        list.add("A");
        list.add("B");
        assertTrue(list.remove(1));
        assertEquals(1, list.size());
        list.add("B");
        assertTrue(list.remove(0));
        assertEquals(1, list.size());
    }


    /**
     * Tests the add method. Ensures that it adds the object is added at the end
     * and the size is increased
     */
    public void testAdd() {
        assertEquals(0, list.size());
        list.add("A");
        assertEquals(1, list.size());
        list.add("B");
        assertEquals(2, list.size());
        assertEquals("B", list.get(1));

    }


    /**
     * Tests that objects can be added at the beginning and end and that they
     * are placed correctly
     */
    public void testAddIndex() {
        list.add("B");
        list.add(0, "A");
        assertEquals("A", list.get(0));
        assertEquals(2, list.size());
        list.add(2, "D");
        assertEquals("D", list.get(2));
        list.add(2, "C");
        assertEquals("C", list.get(2));
    }


    /**
     * This tests that the add method throws a null pointer exception when
     * adding null data to the list
     */
    public void testAddNullException() {
        Exception e = null;
        try {
            list.add(null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests that the add method throws a Invalid argument when adding null
     * data to the list
     */
    public void testAddIndexNullException() {
        Exception e = null;
        try {
            list.add(0, null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests when the add method is called and the index is greater than
     * size or less than zero
     */
    public void testAddException() {
        list.add("A");
        Exception e = null;
        try {
            list.add(2, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.add(-1, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests removing a object changes the size appropiately and that you can
     * remove the first and last elements
     */
    public void testRemoveObj() {
        assertFalse(list.remove(null));
        list.add("A");
        list.add("B");
        assertTrue(list.remove("A"));
        assertEquals("B", list.get(0));
        assertEquals(1, list.size());
        list.add("C");
        assertTrue(list.remove("C"));
        assertEquals("B", list.get(0));
    }


    /**
     * Tests get when the index is greater than or equal to size and when the
     * index is less than zero
     */
    public void testGetException() {
        Exception exception = null;
        try {
            list.get(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        list.add("A");
        try {
            list.get(1);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test contains when it does and does not contain the object
     */
    public void testContains() {
        assertFalse(list.contains("A"));
        list.add("A");
        assertTrue(list.contains("A"));
        assertFalse(list.contains("B"));
        list.add("B");
        assertTrue(list.contains("B"));
    }


    /**
     * Test lastIndexOf when the list is empty, when the object is not in the
     * list, and when it is at the beginning or end
     */
    public void testLastIndexOf() {
        assertEquals(-1, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(0, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(1, list.lastIndexOf("A"));
        list.add("B");
        assertEquals(1, list.lastIndexOf("A"));
        assertEquals(2, list.lastIndexOf("B"));
        list.add("A");
        assertEquals(3, list.lastIndexOf("A"));
    }


    /**
     * Tests isEmpty when empty and full
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }


    /**
     * Ensures that all of the objects are cleared and the size is changed
     */
    public void testClear() {
        list.add("A");
        list.clear();
        assertEquals(0, list.size());
        assertFalse(list.contains("A"));
    }


    /**
     * Tests the toString when there are 0, 1, and 2 objects in the list
     */
    public void testToString() {
        assertEquals("{}", list.toString());
        list.add("A");
        assertEquals("{A}", list.toString());
        list.add("B");
        assertEquals("{A, B}", list.toString());
    }


    /**
     * Tests removing from an empty list
     */
    public void testRemoveFromEmpty() {
        list.add("dance");
        list.add(0, "safety");
        list.clear();
        assertFalse(list.remove("safety"));
        Exception exception;
        exception = null;
        try {
            list.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        DoublyLinkedList<String> emptyList = new DoublyLinkedList<String>();
        exception = null;
        try {
            emptyList.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test the sort method.
     */
    public void testSort() {
        DoublyLinkedList<Song> songlist = new DoublyLinkedList<Song>();
        Song song1 = new Song("a", "a", 2018, "a");
        Song song2 = new Song("b", "b", 2018, "b");
        Song song3 = new Song("c", "c", 2018, "c");
        Song song4 = new Song("d", "d", 2018, "d");
        songlist.add(song3);
        songlist.add(song1);
        songlist.add(song4);
        songlist.add(song2);
        songlist.sort(new TitleComparator());
        assertEquals("{[a, a, 2018, a], [b, b, 2018, b], "
            + "[c, c, 2018, c], [d, d, 2018, d]}", songlist.toString());

        songlist.clear();
        Song song5 = new Song("a", "a", 2018, "z");
        Song song6 = new Song("b", "b", 2018, "y");
        Song song7 = new Song("c", "c", 2018, "a");
        Song song8 = new Song("d", "d", 2018, "b");
        songlist.add(song7);
        songlist.add(song5);
        songlist.add(song8);
        songlist.add(song6);
        songlist.sort(new GenreComparator());
        assertEquals("{[c, c, 2018, a], [d, d, 2018, b], "
            + "[b, b, 2018, y], [a, a, 2018, z]}", songlist.toString());

        songlist.clear();
        Song song9 = new Song("a", "a", 2018, "a");
        songlist.add(song9);
        songlist.sort(new GenreComparator());
        assertEquals("{[a, a, 2018, a]}", songlist.toString());
    }


    /**
     * Test the iterator method.
     */
    public void testIterator() {
        list.add("A");
        list.add("B");
        assertTrue(iter.hasNext());
    }


    /**
     * Test the hasNext method if it has next.
     */
    public void testHasNext1() {
        list.add("A");
        list.add("B");
        assertTrue(iter.hasNext());
    }


    /**
     * Test the hasNext method if the list is empty.
     */
    public void testHasNext2() {
        assertFalse(iter.hasNext());
    }


    /**
     * Test the next method if there are elements in the list.
     */
    public void testNext1() {
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("A", iter.next());
        assertEquals(3, list.size());
    }


    /**
     * Test the next method if there are no elements left in the list.
     */
    public void testNext2() {
        Exception exception = null;
        try {
            // call your method here that will throw the exception
            iter.next();
            fail("next() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("next() is throwing the wrong type of exceptions",
            exception instanceof NoSuchElementException);
    }


    /**
     * Test the remove method if the list is not empty.
     */
    /*
     * public void testRemove1() {
     * list.add("A");
     * list.add("B");
     * list.add("C");
     * assertEquals(3, list.size());
     * iter.remove();
     * assertEquals(2, list.size());
     * }
     */

    /**
     * Test the next method if the list is empty.
     */
    public void testRemove() {
        Exception exception = null;
        try {
            // call your method here that will throw the exception
            iter.remove();
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IllegalStateException);
        list.add("A");
        assertTrue(iter.hasNext());
        iter.next();
        iter.remove();
        assertEquals(0, list.size());
        try {
            // call your method here that will throw the exception
            iter.remove();
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
    }
}
