package linkedlist;

class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int id, double dd) {
        this.dData = dd;
        this.iData = id;
    }
    public void displayLink() {
        System.out.print("{"  + iData + ", " + dData + "} ");
    }
}

class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }
    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }
    public void displayList() {
        System.out.print("List (first --> last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();

    }
}
public class LinkListApp {
    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);
        theList.displayList();

        while (!theList.isEmpty()) {
            Link delLink = theList.deleteFirst();
            System.out.print("Deleted: ");
            delLink.displayLink();
            System.out.println();
        }
        theList.displayList();
    }
}
