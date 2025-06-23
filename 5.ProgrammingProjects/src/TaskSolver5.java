class Link {
    public long dData;
    public Link next;

    public Link(long dd) {
        dData = dd;
        next = null;
    }
    public void display() {
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
            current.display();
            current = current.next;
        }
        System.out.println();
    }
}

public class TaskSolver5 {

    private void solver1() {
        List thePQ = new List();

        thePQ.insert(20);
        thePQ.insert(40);

        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);

        thePQ.displayList();

        while (!thePQ.isEmpty()) {
            Link temp = thePQ.remove();
            temp.display();
        }
        System.out.println();
        thePQ.displayList();

    }
    public static void main(String[] args) {
        new TaskSolver5().solver1();
    }
}
