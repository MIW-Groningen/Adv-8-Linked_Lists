package nl.hva.miw.ads.linkedlists;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortedLinkedListTest {

    @Test
    public void add() {
        SortedLinkedList l = new SortedLinkedList();

        l.add(400);
        l.add(100);
        l.add(200);
        l.add(500);
        l.add(300);

        String expected = "SortedLinkedList{size=5} 100 200 300 400 500";
        String actual = l.toString();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("remove")
    void remove() {
        SortedLinkedList l = new SortedLinkedList();

        l.add(400);
        l.add(100);
        l.add(200);
        l.add(500);
        l.add(300);

        l.remove(300);

        String expected = "SortedLinkedList{size=4} 100 200 400 500";
        String actual = l.toString();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("remove final")
    void removeFinal() {
        SortedLinkedList l = new SortedLinkedList();

        l.add(400);
        l.add(100);
        l.add(200);
        l.add(500);
        l.add(300);

        l.remove(500);

        String expected = "SortedLinkedList{size=4} 100 200 300 400";
        String actual = l.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void removeNonExistent() {
        SortedLinkedList l = new SortedLinkedList();

        l.add(400);
        l.add(100);
        l.add(200);
        l.add(500);
        l.add(300);

        l.remove(600);

        String expected = "SortedLinkedList{size=5} 100 200 300 400 500";
        String actual = l.toString();
        assertEquals(expected, actual);
    }
}