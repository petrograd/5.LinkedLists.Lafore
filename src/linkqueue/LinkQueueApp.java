package linkqueue;
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

class FirstLastList {
    public Link first;
    public Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void insertLast(long dd) {
        Link newLink = new Link(dd);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }
    public long deleteFirst() {
        Link temp = first;
        if (first == last) {
            last = null;
        }
        first = temp.next;
        return temp.dData;
    }
    public void displayList() {
        Link temp = first;
        while (temp != null) {
            temp.displayLink();
            temp = temp.next;
        }
        System.out.println();
    }
}
class LinkQueue {
    FirstLastList theQueue;

    public LinkQueue() {
        theQueue = new FirstLastList();
    }
    public void insert(long dd) {
        theQueue.insertLast(dd);
    }
    public long remove() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return theQueue.deleteFirst();
    }
    public boolean isEmpty() {
        return theQueue.isEmpty();
    }
    public void display() {
        System.out.print("Queue (head --> tail): ");
        theQueue.displayList();
    }
}
public class LinkQueueApp {
    public static void main(String[] args) {
        LinkQueue theQueue = new LinkQueue();

        theQueue.insert(20);
        theQueue.insert(40);
        theQueue.display();

        theQueue.insert(60);
        theQueue.insert(80);
        theQueue.remove();
        theQueue.display();

    }
}
