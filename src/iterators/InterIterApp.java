package iterators;

class Link {
    public long dData;
    public Link next;

    public Link(long dd) {
        dData = dd;
        next = null;
    }
    public void displayLink() {
        System.out.print(dData + " ");
    }
}
class LinkList {
    private Link first;
    public LinkList() {
        first = null;
    }
    public Link getFirst() {
        return first;
    }
    public void setFirst(Link f) {
        first = f;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public ListIterator getIterator() {
        return new ListIterator(this);
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
class ListIterator {
    private Link current;
    private Link previous;
    private LinkList ourList;

    public ListIterator(LinkList list) {
        ourList = list;
        reset();
    }
    public void reset() { // start at 'first'
        current = ourList.getFirst();
        previous = null;
    }

}
public class InterIterApp {
    public static void main(String[] args) {

    }
}
