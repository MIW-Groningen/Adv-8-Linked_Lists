package nl.hva.miw.ads.linkedlists;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleEndedLinkedListTest {

    @Test
    public void add() {
        DoubleEndedLinkedList l = new DoubleEndedLinkedList();

        l.add(0, 400);
        l.add(0, 100);
        l.add(1, 200);
        l.add(2, 300);
        l.add(4, 500);

        String expected = "DoubleEndedLinkedList{size=5} 100 200 300 400 500";
        String actual = l.toString();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("removeElement")
    void removeElement() {
        DoubleEndedLinkedList l = new DoubleEndedLinkedList();

        l.add(0, 400);
        l.add(0, 100);
        l.add(1, 200);
        l.add(2, 300);
        l.add(4, 500);

        assertEquals(300, l.remove(2));
    }
}