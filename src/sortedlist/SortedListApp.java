package sortedlist;

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
class SortedList {
    public Link first;

    public SortedList() {
        first = null;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public Link remove() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first --> last): ");
        Link current = first;
        while (current != null) {
            System.out.print("{" + current.dData + "} ");
            current = current.next;
        }
        System.out.println();
    }
    public void insert(long key) {
        Link newLink = new Link(key);
        Link previous = null;
        Link current = first;
        while (current != null && key > current.dData) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {  //insert front
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current;

    }
}
public class SortedListApp {
    public static void main(String[] args) {
        SortedList theList = new SortedList();
        theList.insert(20);
        theList.insert(40);
        theList.displayList();

        theList.insert(10);
        theList.insert(30);
        theList.insert(50);

        theList.displayList();
        theList.remove();
        theList.displayList();

        while (!theList.isEmpty())
            theList.remove();
        theList.displayList();


    }
}
