package nl.hva.miw.ads.linkedlists;

/**
 * Sorted linked list.
 *
 * @author michel; Vincent Velthuizen
 */
public class SortedLinkedList<T extends Comparable<? super T>> {

    private static class Node<T> {
        T value;
        Node<T> next = null;      // Link to next node

        public Node(T value) {
            this.value = value;
        }
    }

    private int size = 0;           // Length of list
    private Node<T> head = null;      // Link to first node

    public SortedLinkedList() {
    }

    public int getSize() {
        return size;
    }

    public Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public T get( int index ) {
        return getNode(index).value;
    }

    public void add( T value ) {
        // Implement, create a new Node for this entry, but keep the list sorted!.
        Node<T> n = new Node<>(value);

        // Implement the rest

        if (head == null || head.value.compareTo(value) > 0) {
            n.next = head;
            head = n;
            size++;
            return;
        }
        Node<T> previous = head;
        while (previous.next != null && previous.next.value.compareTo(value) < 0) {
            previous = previous.next;
        }

        if (previous.next == null) {
            // adding new final element
            previous.next = n;
            size++;
        } else if (previous.next.value.compareTo(value) > 0) {
            // next value is bigger
            n.next = previous.next;
            previous.next = n;
            size++;
        }
        // if value is the same the new node is discarded and the list is not changed
    }

    public void remove( T value ) {
        // Implement, remove the corresponding node from the linked list.

        if (head.value.compareTo(value) == 0) {
            // remove head
            head = head.next;
        }

        Node<T> previous = head;
        while (previous.next != null && previous.next.value.compareTo(value) < 0) {
            previous = previous.next;
        }

        if (previous.next != null && previous.next.value.compareTo(value) == 0) {
            previous.next = previous.next.next;
            size--;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("SortedLinkedList{size=").append(size).append("}");

        Node<T> current = this.head;
        while ( current != null ) {
            sb.append(" ");
            sb.append( current.value );
            current = current.next;
        }

        return sb.toString();
    }
}
