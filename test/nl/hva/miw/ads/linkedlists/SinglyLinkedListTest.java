package nl.hva.miw.ads.linkedlists;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    @Test
    public void add() {
        SinglyLinkedList l = new SinglyLinkedList();
        System.out.println(l);

        l.add(0, 400);
        l.add(0, 100);
        l.add(1, 200);
        l.add(2, 300);
        l.add(4, 500);

        String expected = "SinglyLinkedList{size=5} 100 200 300 400 500";
        String actual = l.toString();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("removeFirstElement")
    public void removeFirstElement() {
        SinglyLinkedList l = new SinglyLinkedList();
        System.out.println(l);

        l.add(0, 400);
        l.add(0, 100);
        l.add(1, 200);
        l.add(2, 300);
        l.add(4, 500);

        l.remove(0);
        String expected = "SinglyLinkedList{size=4} 200 300 400 500";
        String actual = l.toString();
        assertEquals(expected, actual);

        assertEquals(4, l.getSize());
    }

    @Test
    @DisplayName("removeFinalElement")
    public void removeFinalElement() {
        SinglyLinkedList l = new SinglyLinkedList();
        System.out.println(l);

        l.add(0, 400);
        l.add(0, 100);
        l.add(1, 200);
        l.add(2, 300);
        l.add(4, 500);

        l.remove(4);
        String expected = "SinglyLinkedList{size=4} 100 200 300 400";
        String actual = l.toString();
        assertEquals(expected, actual);

        assertEquals(4, l.getSize());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("removing non existent index fails")
    void removingNonExistentIndexFails() {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.add(0, 5);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(1));
    }
}