package nl.hva.miw.ads.linkedlists;

/**
 * Singly linked list.
 *
 * @author michel
 */
public class SinglyLinkedList {

    private static class Node {
        int value;
        Node next = null;      // Link to next node

        public Node(int value) {
            this.value = value;
        }
    }

    private int size;           // Length of list
    private Node head;      // Link to first node

    public SinglyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public int getSize() {
        return size;
    }

    private Node getNode(int index) {
        checkIndex(index);

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
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

    /**
     * Add an element to the list at position index.
     *
     * @param index
     * @param value
     */
    public void add( int index, int value ) {
        // Implement, create a new Node for this entry.
        Node newNode = new Node(value);

        // Implement the rest
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node previous = getNode(index - 1);
            newNode.next = previous.next;
            previous.next = newNode;
        }

        size++;
    }

    /**
     * Remove an element from the list at position index, if it exists.
     *
     * @param index
     */
    public void remove( int index ) {
        // Implement, remove the corresponding node from the linked list.
        checkIndex(index);

        if (index == 0) {
            head = head.next;
        } else {
            Node previous = getNode(index - 1);
            previous.next = previous.next.next;
        }
        size--;
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index: %d is out of bounds for List of size: %d",
                    index, size));
        }
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("SinglyLinkedList{size=").append(size).append("}");

        Node current = this.head;
        while ( current != null ) {
            sb.append(" ");
            sb.append( current.value );
            current = current.next;
        }

        return sb.toString();
    }



}
