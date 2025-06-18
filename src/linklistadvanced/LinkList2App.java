package linklistadvanced;

class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int id, double dd) {
        iData = id;
        dData = dd;
        next = null;
    }
    public void displayLink() {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}
class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public void insertFirst(int id, double dd) {
        Link el = new Link(id, dd);
        el.next = first;
        first = el;
    }

    public Link find(int key) {
        Link current = first;
        while (current != null && current.iData != key)
            current = current.next;
        if (current == null) //haven't found
            return null;
        else return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link prev = first;
        while (current.iData != key) {
            if (current.next == null) //haven't found
                return null;
            prev = current;
            current = current.next;
        }
        if (current == first) {
            first = first.next;
        } else {
            prev.next = current.next;
        }
        return current;
    }
    public boolean isEmpty() {
        return first == null;
    }

    public void displayList() {
        System.out.print("List (first --> last): ");
        Link curent = first;
        while(curent != null) {
            curent.displayLink();
            curent = curent.next;
        }
        System.out.println();
    }

}

public class LinkList2App {
    public static void main(String[] args) {
        LinkList theList = new LinkList();
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();

        Link f = theList.find(44);
        if (f != null) {
            System.out.println("Found link with key: " + f.iData);
        } else {
            System.out.println("Can't find link");
        }
        Link d = theList.delete(66);
        if (d != null) {
            System.out.println("Deleted link with key: " + d.iData);
        } else {
            System.out.println("Can't delete link");
        }
        d = theList.delete(88);
        if (d != null) {
            System.out.println("Deleted link with key: " + d.iData);
        } else {
            System.out.println("Can't delete link");
        }
        theList.displayList();
    }
}
