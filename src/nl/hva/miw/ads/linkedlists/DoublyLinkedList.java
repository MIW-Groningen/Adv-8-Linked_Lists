package nl.hva.miw.ads.linkedlists;

/**
 * Doubly linked list.
 *
 * @author michel
 */
public class DoublyLinkedList {

    private class Node {
        int value;

        Node next=null;      // Link to next node
        Node prev=null;      // Link to previous node

        public Node(int value) {
            this.value = value;
        }
    }

    private int size = 0;           // Length of list
    private Node head = null;      // Link to first node

    public DoublyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    /**
     * Return the value in the list at position index.
     *
     * @param index
     * @return
     */
    public int get( int index ) {
        return getNode(index).value;
    }

    private Node getNode(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(String.format("index: %d is out of bounds for %s of size: %d",
                    index, getClass().getName(), size));
        }

        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Add an element to the list at position index.
     *
     * @param index
     * @param value
     */
    public void add( int index, int value ) {
        // Implement, create a new Node for this entry.
        Node n = new Node( value );

        // Implement the rest
        if (index == 0) {
            if (head != null) {
                n.next = head;
                head.prev = n;
            }
            head = n;
        } else {
            Node previous = getNode(index - 1);

            if (previous.next != null) {
                previous.next.prev = n;
                n.next = previous.next;
            }

            previous.next = n;
            n.prev = previous;
        }
        size++;
    }

    /**
     * Remove an elmeent from the list at position index, if it exists.
     *
     * @param index
     */
    public void remove( int index ) {
        // Implement, remove the corresponding node from the linked list.

        Node toRemove = getNode(index);

        if (head == toRemove) {
            head = toRemove.next;
        }

        if (toRemove.next != null) {
            toRemove.next.prev = toRemove.prev;
        }

        if (toRemove.prev != null) {
            toRemove.prev.next = toRemove.next;
        }
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("DoublyLinkedList{size=").append(size).append("}");

        Node current = this.head;
        while ( current != null ) {
            sb.append(" ");
            sb.append( current.value );
            current = current.next;
        }

        return sb.toString();
    }



}
