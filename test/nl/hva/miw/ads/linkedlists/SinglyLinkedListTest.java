package nl.hva.miw.ads.linkedlists;

import org.junit.Test;

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

        String expected = "SinglyLinkedList{size=0} 100 200 300 400 500";
        String actual = l.toString();
        assertEquals(expected, actual);
    }
}