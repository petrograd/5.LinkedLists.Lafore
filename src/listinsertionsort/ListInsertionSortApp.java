package listinsertionsort;

class Link {
    public long dData;
    public Link next;

    public Link(long dd) {
        dData = dd;
        next = null;
    }
}
class SortedList {
    private Link first;

    public SortedList() { // constructor no args
        first = null;
    }
    public SortedList(Link[] linkArr) {  // constructor (array as argument)
        first = null;
        for (int i = 0; i < linkArr.length; i++) {
            insert(linkArr[i]);
        }
    }

    private void insert(Link k) {
        Link previous = null;
        Link current = first;

        while (current != null && k.dData > current.dData) {
            previous = current;
            current = current.next;
        }
        if (previous == null)   // at beginning of list
            first = k;
        else
            previous.next = k;
        k.next = current;
    }
    public Link remove() {
        Link temp = first;
        first = first.next;
        return temp;
    }

}
public class ListInsertionSortApp {
    public static void main(String[] args) {
        int size = 100;

        Link[] linkArray = new Link[size];
        for (int i = 0; i < size; i++) {
            int n = (int) (Math.random() * 99);
            Link newLink = new Link(n);
            linkArray[i] = newLink;
        }
        System.out.println("Unsorted array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(linkArray[i].dData + " ");
        }
        System.out.println();

        SortedList theSortedList = new SortedList(linkArray);
        for (int i = 0; i < size; i++) {
            linkArray[i] = theSortedList.remove();
        }

        System.out.println("Sorted array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(linkArray[i].dData + " ");
        }
        System.out.println();

    }

}
