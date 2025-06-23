class Link {
    public long dData;
    public Link next;
    public Link prev;
    public Link(long dd) {
        dData = dd;
        next = null;
    }
    public void displayLink() {
        System.out.print(dData + " ");
    }
}
class List {
    private Link first;
    private int nElmnts;

    public List() {
        first = null;
        nElmnts = 0;
    }
    public void insert(long dd) {
        Link current = first;
        Link previous = null;
        Link newLink = new Link(dd);

        while (current != null && dd > current.dData) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {  //
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current;
        nElmnts++;
    }
    public Link remove() {
        if (isEmpty())
            return null;
        Link temp = first;
        first = first.next;
        nElmnts--;
        return temp;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return nElmnts;
    }
    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
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
class Task1 {
    public void solve() {
        List thePQ = new List();

        thePQ.insert(20);
        thePQ.insert(40);

        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);

        thePQ.displayList();

        while (!thePQ.isEmpty()) {
            Link temp = thePQ.remove();
            temp.displayLink();
        }
        System.out.println();
        thePQ.displayList();
    }
}

class Deque {
    private DoublyLinkedList theList;

    public Deque() {
        theList = new DoublyLinkedList();
    }
    public void insertLeft(long dd) {
        theList.insertFirst(dd);
    }
    public void insertRight(long dd) {
        theList.insertLast(dd);
    }
    public long removeLeft() {
        long val = theList.deleteFirst().dData;
        return val;
    }
    public long removeRight() {
        long val = theList.deleteLast().dData;
        return val;
    }
    public void displayDeck() {
        theList.displayForward();
    }
    public boolean isEmpty() {
        return theList.isEmpty();
    }

}
//Implement a deque based on a doubly linked list
class Task2 {
    public void solve() {
        Deque theDeque = new Deque();
        theDeque.insertLeft(60);
        theDeque.insertLeft(40);
        theDeque.insertLeft(20);
        theDeque.insertRight(50);
        theDeque.insertRight(30);
        theDeque.insertRight(10);

        theDeque.displayDeck();

        theDeque.removeRight();
        theDeque.removeLeft();
        theDeque.displayDeck();

        while (!theDeque.isEmpty()) {
            theDeque.removeRight();
        }
        theDeque.displayDeck();

    }
}

public class Main {

    public static void main(String[] args) {
        new Task2().solve();
    }
}
