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

    }
    public void insertLast(long dd) {

    }
    public void insertAfter(long dd){

    }
    public void displayForward() {

    }
    public void displayBackward() {

    }

}
public class DoublyLinkedListApp {
    public static void main(String[] args) {

    }
}
