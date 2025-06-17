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

public class LinkListApp {
    public static void main(String[] args) {
        System.out.println();

    }
}
