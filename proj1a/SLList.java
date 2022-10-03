/** This is a fill in the blanks version of the SLList class
 *  in case you want to try to figure out how to write it yourself.
 */
public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }


    private IntNode sentinel;//
    private int size;//caching

    /** Creates an empty SLList. */
    public SLList() {
        sentinel = new IntNode(63,null);//empty list, the value of sentinel does not count
        size = 0;
    }

    /** Create a new SLList*/
    public SLList(int x){
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        /* Your Code Here! */
        IntNode p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }
    /** Returns the size of the list. */
    public int size() {
        return size;
    }
}