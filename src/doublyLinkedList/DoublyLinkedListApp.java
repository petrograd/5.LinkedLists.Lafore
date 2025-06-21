package doublyLinkedList;
class Link {
    public long dData;
    public Link next;
    public Link prev;

    public Link(long dd) {
        dData = dd;
        next = null;
        prev = null;
    }
    public void displayLink() {
        System.out.print(dData + " ");
    }
}
class DoublyLinkedList {
    private Link first;
    private Link last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void insertFirst(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            last = newLink;
        } else {
            first.prev = newLink;
        }
        newLink.prev = null;
        newLink.next = first;
        first = newLink;
    }
    public void insertLast(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        newLink.next = null;
        newLink.prev = last;
        last = newLink;
    }
    public boolean insertAfter(long key, long dd) {
        if (isEmpty())
            return false;
        Link current = first;
        Link newLink = new Link(dd);
        while (current.dData != key) {
            current = current.next;
            if (current == null)
                return false;
        }
        newLink.prev = current;
        newLink.next = current.next;
        if (current == last) {
            last = newLink;
        } else {
            current.next.prev = newLink;
        }
        current.next = newLink;
        return true;

    }
    public Link deleteKey(long key) {
        if (isEmpty()) return null;
        Link current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null) // end of list
                return null;
        }
        if (current == first) {
          first = current.next;
        } else {
            current.prev.next = current.next;
        }
        if (current == last) {
            last = current.prev;
        } else {
            current.next.prev = current.prev;
        }
        return current;

    }
    public Link deleteFirst() {
        Link temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.prev = null;
        }
        first = first.next;
        return temp;
    }
    public Link deleteLast() {
        Link temp = last;
        if (last.prev == null) {
            first = null;
        } else {
            last.prev.next = null;
        }
        last = last.prev;
        return temp;
    }
    public void displayForward() {
        System.out.print("List (first --> last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
    public void displayBackward() {
        System.out.print("List (last --> first): ");
        Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.prev;
        }
        System.out.println("");
    }

}
public class DoublyLinkedListApp {
    public static void main(String[] args) {
        DoublyLinkedList theList = new DoublyLinkedList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayForward();
        theList.displayBackward();

        theList.deleteFirst();
        theList.deleteLast();
        theList.deleteKey(11);

        theList.displayForward();

        theList.insertAfter(22, 77);
        theList.insertAfter(33, 88);

        theList.displayForward();
    }
}
