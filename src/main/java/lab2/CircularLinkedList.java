package lab2;

import java.util.Collection;
import java.util.LinkedList;

public class CircularLinkedList {
    private LinkedList<Character> list;

    public CircularLinkedList() {
        list = new LinkedList<Character>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int length() {
        return list.size();
    }

    public void append(char element) {
        list.add(element);
    }

    public void insert(char element, int index) throws Exception {
        if (index < 0) throw new Exception("Error. Invalid index.");
        if (index > list.size()) throw new Exception("Error. Index is out of range.");
        list.add(index, element);
    }

    public char delete(int index) throws Exception {
        if (index < 0) throw new Exception("Error. Invalid index.");
        if (list.isEmpty()) throw new Exception("Error. List is empty.");
        if (index >= list.size()) throw new Exception("Error. Index is out of range.");
        return list.remove(index);
    }

    public void deleteAll(char element) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == element) list.remove(i);
        }
    }

    public char get(int index) throws Exception {
        if (index < 0) throw new Exception("Error. Invalid index.");
        if (list.isEmpty()) throw new Exception("Error. List is empty.");
        if (index >= list.size()) throw new Exception("Error. Index is out of range.");
        return list.get(index);
    }

    public CircularLinkedList clone() {
        CircularLinkedList linkedList = new CircularLinkedList();
        if (list.isEmpty()) return linkedList;
        for (char element : list) {
            linkedList.append(element);
        }
        return linkedList;
    }

    public void reverse() {
        if(list.isEmpty()) return;
        LinkedList<Character> reversedList = new LinkedList<Character>();
        while(!list.isEmpty()) {
            reversedList.addFirst(list.removeFirst());
        }
        list = reversedList;
    }

    public int findFirst(char element) {
        return list.indexOf(element);
    }

    public int findLast(char element) {
        return list.lastIndexOf(element);
    }

    public void clear() {
        list.clear();
    }

    public void extend(CircularLinkedList elements) {
        if(elements.isEmpty()) return;
        for(Character element : elements.list) {
            list.addLast(element);
        }
    }
}