public class ArrayDeque<Item> {
    /**
     * circular sentinel
     */
    private Item[] items;
    private int size;
    private int front;
    private int last;
    private int length;

    /**
     * Creates an empty array deque.
     */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        front = 4;
        last = 4;
        length = 8;
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return index-1
     */
    public int minusOne(int index) {
        if (index == 0) {
            return length - 1;
        }
        return index - 1;
    }

    /**
     * return index+1
     */
    public int plusOne(int index, int module) {
        index %= module;
        if (index == module - 1) {
            return 0;
        }
        return index + 1;
    }

    /**
     * expand the items[]
     */
    private void grow() {
        Item[] newItems = (Item[]) new Object[length * 2];
        int ptr1 = front;
        int ptr2 = length;
        while (ptr1 != last) {
            newItems[ptr2] = items[ptr1];
            ptr1 = plusOne(ptr1, length);
            ptr2 = plusOne(ptr2, length * 2);
        }
        front = length;
        last = ptr2;
        items = newItems;
        length *= 2;
    }

    /**
     * shrink the items[]
     */
    private void shrink() {
        Item[] newItems = (Item[]) new Object[length / 2];
        int ptr1 = front;
        int ptr2 = length / 4;
        while (ptr1 != last) {
            newItems[ptr2] = items[ptr1];
            ptr1 = plusOne(ptr1, length);
            ptr2 = plusOne(ptr2, length / 2);
        }
        front = length / 4;
        last = ptr2;
        items = newItems;
        length /= 2;
    }

    /**
     * Adds an item of type T to the front of the deque.
     *
     * @param item
     */
    public void addFirst(Item item) {
        if (size == length - 1) {
            grow();
        }
        front = minusOne(last);
        items[front] = item;
        size++;
    }

    /**
     * Adds an item of type T to the back of the deque.
     *
     * @param item
     */
    public void addLast(Item item) {
        if (size == length - 1) {
            grow();
        }
        items[last] = item;
        last = plusOne(last, length);
        size++;
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     *
     * @return
     */
    public Item removeFirst() {
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        if (size == 0) {
            return null;
        }
        Item ret = items[front];
        front = plusOne(front, length);
        size--;
        return ret;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     *
     * @return
     */
    public Item removeLast() {
        if (length >= 16 && length / size >= 4) {
            shrink();
        }
        if (size == 0) {
            return null;
        }
        last = minusOne(last);
        size--;
        return items[last];
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     */
    public Item get(int index) {
        if (index >= size) {
            return null;
        }
        int ptr = front;
        for (int i = 0; i < index; i++) {
            ptr = plusOne(ptr, length);
        }
        return items[ptr];
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
        int ptr = front;
        while (ptr != last) {
            System.out.print(items[ptr] + " ");
            ptr = plusOne(ptr, length);
        }
    }
}
