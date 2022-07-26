package nl.hva.miw.ads.linkedlists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortedLinkedListTest {

    @Test
    public void add() {
        SortedLinkedList l = new SortedLinkedList();
        System.out.println(l);

        l.add(400);
        l.add(100);
        l.add(200);
        l.add(500);
        l.add(300);

        String expected = "SortedLinkedList{size=5} 100 200 300 400 500";
        String actual = l.toString();
        assertEquals(expected, actual);
    }
}