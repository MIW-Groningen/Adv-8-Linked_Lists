package nl.hva.miw.ads.linkedlists;

/**
 * DoubleEnded Doubly linked list.
 *
 * @author michel; Vincent Velthuizen
 */
public class DoubleEndedLinkedList {

    private class Node {
        int value;

        Node next=null;      // Link to next node
        Node prev=null;      // Link to previous node

        public Node(int value) {
            this.value = value;
        }
    }

    private int size;           // Length of list
    private Node head;      // Link to first node
    private Node tail;      // Link to last node

    public DoubleEndedLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public int getSize() {
        return size;
    }

    private Node getNode(int index) {
        checkIndexBounds(index);

        Node current;
        if (index > size / 2) {
            // approach from front
            current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            // approach from back
            current = tail;

            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current;
    }

    private void checkIndexBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index: %d is out of bounds for List of size: %d",
                    index, size));
        }
    }

    public int get( int index ) {
        return getNode(index).value;
    }

    public void add( int index, int value ) {
        // Implement, create a new Node for this entry.

        Node n = new Node( value );

        // set forward links correctly
        if (index == 0) {
            n.next = head;
            head = n;
        } else {
            Node previous = getNode(index - 1);
            n.next = previous.next;
            previous.next = n;
        }

        // set backward links correctly
        if (index == size) {
            n.prev = tail;
            tail = n;
        } else {
            //
            Node nextNode = n.next; // this was set correctly in the code before
            n.prev = nextNode.prev;
            nextNode.prev = n;
        }

        size++;
    }

    public int remove( int index ) {
        // Implement, remove the corresponding node from the linked list.
        Node toBeRemoved = getNode(index);

        // Deal with forward links
        if (index == 0) {
            head = head.next;
        } else {
            toBeRemoved.prev.next = toBeRemoved.next;
        }

        // Deal with backward links
        if (index == size - 1) {
            tail = tail.prev;
        } else {
            toBeRemoved.next.prev = toBeRemoved.prev;
        }

        size--;
        return toBeRemoved.value;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("DoubleEndedLinkedList{size=").append(size).append("}");

        Node current = this.head;
        while ( current != null ) {
            sb.append(" ");
            sb.append( current.value );
            current = current.next;
        }

        return sb.toString();
    }
}
