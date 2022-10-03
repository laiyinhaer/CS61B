public class LinkedListDeque<T> {
    /**
     * inner class Node
     */
    public class Node{
        public T item;
        public Node prev;
        public Node next;
        public Node(T i, Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }

    /**
     * circular sentinel
     */
    private Node sentinel;
    private int size;

    /**
     * Creates an empty linked list deque.
     */
    public LinkedListDeque(){
        sentinel = new Node(null,null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size(){
        return size;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * @param item
     */
    public void addFirst(T item){
        Node temp = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = temp;
        sentinel.next = temp;
        size += 1;
    }

    /**
     * Adds an item of type T to the back of the deque.
     * @param item
     */
    public void addLast(T item){
        Node temp = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = temp;
        sentinel.prev = temp;
        size += 1;
    }

    /**
     *  Returns true if deque is empty, false otherwise.
     * @return
     */
    public boolean isEmpty(){
        if (sentinel.next == sentinel)
            return true;
        return false;
    }

    /**
     *  Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque(){
        Node p = sentinel.next;
        while(p != sentinel){
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeFirst(){
        if(isEmpty())
            return null;
        Node first = sentinel.next;
        first.next.prev = sentinel;
        sentinel.next = first.next;
        size -= 1;
        return first.item;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * @return
     */
    public T removeLast(){
        if(isEmpty())
            return null;
        Node last = sentinel.prev;
        last.prev.next = sentinel;
        sentinel.prev = last.prev;
        size -= 1;
        return last.item;

    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index){
        Node p = sentinel.next;
        while(index != 0){
            p = p.next;
            index -= 1;
        }
        return p.item;
    }


    /**
     * Same as get, but uses recursion.
     * */
    public T getRecursive(int index){
        return getRecursiveHelp(index, sentinel.next);
    }


    public T getRecursiveHelp(int index, Node start){
        if(index == 0)
            return start.item;
        return getRecursiveHelp(index-1, start.next);
    }

}
