package lab2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircularLinkedListTest {
    public CircularLinkedList linkedList;

    @Before
    public void setUp(){
    linkedList = new CircularLinkedList();

    }

    @Test
    public void lengthEmpty() {
        assertEquals(0, linkedList.length());
    }

    @Test
    public void lengthNonEmpty() {
        linkedList.append('H');
        linkedList.append('I');
        linkedList.append('!');
        assertEquals(3, linkedList.length());

    }

    @Test
    public void append() {
        linkedList.append('q');
        linkedList.append('w');
        assertFalse("must be non-empty after append", linkedList.isEmpty());
    }

    @Test
    public void insertFirstEmpty() throws Exception{
        linkedList.insert('f', 0);
        assertEquals(1, linkedList.length());
        assertEquals('f',linkedList.get(0));
    }

    @Test
    public void insertFirstNonEmpty() throws Exception{
        linkedList.append('t');
        linkedList.append('a');
        linkedList.insert('f', 0);
        assertEquals(3, linkedList.length());
        assertEquals('f', linkedList.get(0));
    }

    @Test
    public void insertLast() throws Exception {
        linkedList.append('m');
        linkedList.append('t');
        linkedList.append('s');
        linkedList.append('d');
        linkedList.insert('2', 4);
        assertEquals(5, linkedList.length());
        assertEquals('2', linkedList.get(4));
    }

    @Test
    public void insertMiddle() throws Exception {
        linkedList.append('m');
        linkedList.append('t');
        linkedList.append('s');
        linkedList.append('d');
        linkedList.insert('2', 2);
        assertEquals(5, linkedList.length());
        assertEquals('2', linkedList.get(2));
        assertEquals('d', linkedList.get(4));
    }

    @Test (expected = Exception.class)
    public void insertNegativeIndex() throws Exception {
        try {
            linkedList.insert('a', -3);
        } catch (Exception e) {
            assertEquals("Error. Invalid index.", e.getMessage());
            throw e;
        }
    }

    @Test (expected = Exception.class)
    public void insertIndexOutOfRange() throws Exception {
        linkedList.append('l');
        try {
            linkedList.insert('a', 4);
        } catch (Exception e) {
            assertEquals("Error. Index is out of range.", e.getMessage());
            throw e;
        }
    }

    private void fill(CircularLinkedList list) {
        list.append('m');
        list.append('t');
        list.append('s');
        list.append('d');
        list.append('l');
        list.append('a');
        list.append('b');
        list.append('2');
    }

    @Test (expected = Exception.class)
    public void deleteEmpty() throws Exception {
        try {
            linkedList.delete(0);
        } catch (Exception e) {
            assertEquals("Error. List is empty.", e.getMessage());
            throw e;
        }
    }

    @Test
    public void deleteSingle() throws Exception{
        linkedList.append('a');
        assertEquals('a',linkedList.delete(0));
        assertEquals(0, linkedList.length());
    }

    @Test
    public void deleteFirst() throws Exception{
        fill(linkedList);
        assertEquals('m',linkedList.delete(0));
        assertEquals(7, linkedList.length());
        assertEquals('t', linkedList.get(0));
    }

    @Test
    public void deleteLast() throws Exception {
        fill(linkedList);
        assertEquals('2',linkedList.delete(7));
        assertEquals(7, linkedList.length());
        assertEquals('b', linkedList.get(6));
    }

    @Test
    public void deleteMiddle() throws Exception {
        fill(linkedList);
        assertEquals('s',linkedList.delete(2));
        assertEquals('d',linkedList.delete(2));
        assertEquals('l',linkedList.delete(2));
        assertEquals(5, linkedList.length());
        assertEquals('a', linkedList.get(2));
        assertEquals('b', linkedList.get(3));
        assertEquals('2', linkedList.get(4));
    }

    @Test (expected = Exception.class)
    public void deleteNegativeIndex() throws Exception {
        fill(linkedList);
        try {
            linkedList.delete(-3);
        } catch (Exception e) {
            assertEquals("Error. Invalid index.", e.getMessage());
            throw e;
        }
    }

    @Test (expected = Exception.class)
    public void deleteIndexOutOfRange() throws Exception {
        fill(linkedList);
        try {
            linkedList.delete(8);
        } catch (Exception e) {
            assertEquals("Error. Index is out of range.", e.getMessage());
            throw e;
        }
    }

    @Test
    public void deleteAllEmpty() {
        linkedList.deleteAll('a');
        assertEquals(0, linkedList.length());
    }

    @Test
    public void deleteAllSingle() {
        linkedList.append('a');
        linkedList.deleteAll('a');
        assertEquals(0, linkedList.length());
    }

    @Test
    public void deleteAll() throws Exception {
        linkedList.append('A');
        linkedList.append('B');
        linkedList.append('A');
        linkedList.append('B');
        linkedList.append('A');
        linkedList.deleteAll('A');
        assertEquals(2, linkedList.length());
        assertEquals('B', linkedList.get(0));
        assertEquals('B', linkedList.get(1));
    }

    @Test
    public void deleteAllNothingChange() throws Exception {
        linkedList.append('A');
        linkedList.append('B');
        linkedList.deleteAll('C');
        assertEquals(2, linkedList.length());
        assertEquals('A', linkedList.get(0));
        assertEquals('B', linkedList.get(1));
    }

    @Test
    public void get() throws Exception {
        fill(linkedList);
        assertEquals('s', linkedList.get(2));
        assertEquals('m', linkedList.get(0));
        assertEquals('2', linkedList.get(7));
        assertEquals('a', linkedList.get(5));
    }

    @Test (expected = Exception.class)
    public void getEmpty() throws Exception {
        try {
            linkedList.get(2);
        } catch (Exception e) {
            assertEquals("Error. List is empty.", e.getMessage());
            throw e;
        }
    }

    @Test (expected = Exception.class)
    public void getNegativeIndex() throws Exception{
        fill(linkedList);
        try {
            assertEquals('s', linkedList.get(-2));
        } catch (Exception e) {
            assertEquals("Error. Invalid index.", e.getMessage());
            throw e;
        }
    }

    @Test (expected = Exception.class)
    public void getIndexOutOfRange() throws Exception {
        fill(linkedList);
        try {
            assertEquals('s', linkedList.get(9));
        } catch (Exception e) {
            assertEquals("Error. Index is out of range.", e.getMessage());
            throw e;
        }
    }

    @Test
    public void testClone() throws Exception{
        fill(linkedList);
        CircularLinkedList newList = linkedList.clone();
        linkedList.delete(0);
        assertEquals('m', newList.get(0));
        assertEquals(8, newList.length());
        assertEquals('t', linkedList.get(0));
        assertEquals(7, linkedList.length());

    }

    @Test
    public void testCloneEmpty() {
        CircularLinkedList newList = linkedList.clone();
        linkedList.append('1');
        assertEquals(0, newList.length());
        assertEquals(1,linkedList.length());
    }

    @Test
    public void reverse() throws Exception {
        fill(linkedList);
        linkedList.reverse();
        assertEquals('2', linkedList.get(0));
        assertEquals('b', linkedList.get(1));
        assertEquals('m', linkedList.get(7));
    }

    @Test
    public void reverseEmpty() {
        linkedList.reverse();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void reverseSingle() throws Exception{
        linkedList.append('q');
        linkedList.reverse();
        assertEquals(1,linkedList.length());
        assertEquals('q',linkedList.get(0));
    }

    @Test
    public void findFirst() {
        fill(linkedList);
        linkedList.append('t');
        assertEquals(1,linkedList.findFirst('t'));
    }

    @Test
    public void findFirstNotFound() {
        fill(linkedList);
        linkedList.append('t');
        assertEquals(-1,linkedList.findFirst('c'));
    }

    @Test
    public void findFirstEmpty() {
        assertEquals(-1,linkedList.findFirst('m'));
    }

    @Test
    public void findLast() {
        fill(linkedList);
        linkedList.append('t');
        assertEquals(8,linkedList.findLast('t'));

    }

    @Test
    public void findLastNotFound() {
        fill(linkedList);
        linkedList.append('t');
        assertEquals(-1,linkedList.findFirst('c'));
    }

    @Test
    public void findLastEmpty() {
        assertEquals(-1,linkedList.findFirst('m'));
    }

    @Test
    public void clear() {
        fill(linkedList);
        linkedList.clear();
        assertEquals(0, linkedList.length());
    }

    @Test
    public void extend()throws Exception {
        fill(linkedList);
        CircularLinkedList newList = new CircularLinkedList();
        newList.append('A');
        newList.append('B');
        newList.append('A');
        newList.append('B');
        linkedList.extend(newList);
        linkedList.append('W');
        assertEquals(13, linkedList.length());
        assertEquals('A', linkedList.get(8));
        assertEquals('B', linkedList.get(11));
        assertEquals('W', linkedList.get(12));
        assertEquals(4,newList.length());
    }
}