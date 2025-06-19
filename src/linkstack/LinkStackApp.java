package linkstack;
class Link {
    public double dData;
    public Link next;

    public Link(double dd) {
        dData = dd;
        next = null;
    }
    public void displayLink() {
        System.out.print(dData + " ");
    }
}
class LinkList {
    public Link first;

    public LinkList() {
        first = null;
    }
    public void insertFirst(double dd) {
        Link newLink = new Link(dd);
        newLink.next = first;
        first = newLink;
    }
    public double deleteFirst() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        Link temp = first;
        first = temp.next;
        return temp.dData;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void displayList() {
        Link cur = first;
        while (cur != null) {
            cur.displayLink();
            cur = cur.next;
        }
        System.out.println();
    }
}
class LinkStack {
    LinkList theStack;
    int nItems;
    public LinkStack() {
        theStack = new LinkList();
        nItems = 0;
    }

    public void push(double dd) {
        theStack.insertFirst(dd);
        nItems++;
    }
    public double pop() {
        if (nItems == 0) throw new IllegalStateException("Stack is empty");
        nItems--;
        return theStack.deleteFirst();
    }
    public double peek() {
        double temp = theStack.deleteFirst();
        theStack.insertFirst(temp);
        return temp;
    }
    public boolean isEmpty() {
        return theStack.isEmpty();
    }
    public void displayStack() {
        theStack.displayList();
    }
    public int size() {
        return nItems;
    }

}
public class LinkStackApp {
    public static void main(String[] args) {
        LinkStack theStack = new LinkStack();

        theStack.push(20);
        theStack.push(40);
        theStack.displayStack();

        theStack.push(60);
        theStack.push(80);
        theStack.displayStack();

        theStack.pop();
        theStack.pop();
        theStack.displayStack();
        System.out.println("Stack size is: " + theStack.size());

    }
}
