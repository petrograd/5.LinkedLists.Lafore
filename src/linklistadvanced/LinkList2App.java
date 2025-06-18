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
    public void displayList() {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}
class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

}

public class LinkList2App {
    public static void main(String[] args) {

    }
}
