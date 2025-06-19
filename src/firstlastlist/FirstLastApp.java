package firstlastlist;

class Link {
    public double dDouble;
    public Link next;

    public Link(double dd) {
        dDouble = dd;
        next = null;
    }
    public void displayLink() {
        System.out.print("{" + dDouble + "} ");
    }
}
class FirstLastList {
    public Link first;
    public Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }
    public void insertFirst(double dd) {
        Link newLink = new Link(dd);
        if (isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;
    }
    public void insertLast(double dd) { //insert at end of List
        Link newLink = new Link(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }
    public Link deleteFirst() {  //delete first link
        if (isEmpty()) return null;
        Link temp = first;
        if (first == last) //only one element is in list
            last = null;
        first = first.next;
        return temp;
    }
    public Link deleteLast() {
        if (isEmpty()) return null; // List is empty

        Link prev = first;
        Link cur = first;
        while (cur != last) {
            prev = cur;
            cur = cur.next;
        }
        if (first == last) {
            first = last = null;
            return cur;
        }
        last = prev;
        last.next = null;
        return cur;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void displayList() {
        System.out.print("List (first --> last): ");
        Link cur = first;
        while (cur != null) {
            cur.displayLink();
            cur = cur.next;
        }
        System.out.println();
    }
}

public class FirstLastApp {
    public static void main(String[] args) {
        FirstLastList theList = new FirstLastList();
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayList();


        System.out.println("Deleting first: " + theList.deleteFirst().dDouble);
        System.out.println("Deleting first: " + theList.deleteFirst().dDouble);
        System.out.println("Deleting last: " +  theList.deleteLast().dDouble);

        theList.displayList();

    }

}
