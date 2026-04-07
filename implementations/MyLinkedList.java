import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    // Internal class representing one "link" in the chain
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;
        MyNode(T data) { this.data = data; }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public void add(T item) { addLast(item); }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index == 0) addFirst(item);
        else if (index == size) addLast(item);
        else {
            MyNode current = getNode(index);
            MyNode newNode = new MyNode(item);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
    }

    @Override public T get(int index) { return getNode(index).data; }
    @Override public T getFirst() { return (head != null) ? head.data : null; }
    @Override public T getLast() { return (tail != null) ? tail.data : null; }

    @Override
    public void remove(int index) {
        MyNode node = getNode(index);
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;
        size--;
    }

    @Override public void removeFirst() { remove(0); }
    @Override public void removeLast() { remove(size - 1); }

    @Override
    public void sort() {
        if (size < 2) return;
        for (int i = 0; i < size; i++) {
            MyNode curr = head;
            while (curr != null && curr.next != null) {
                if (curr.data.compareTo(curr.next.data) > 0) {
                    T temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
                curr = curr.next;
            }
        }
    }

    @Override
    public int indexOf(Object o) {
        MyNode curr = head;
        for (int i = 0; i < size; i++) {
            if (curr.data.equals(o)) return i;
            curr = curr.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        MyNode curr = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (curr.data.equals(o)) return i;
            curr = curr.prev;
        }
        return -1;
    }

    @Override public boolean exists(Object o) { return indexOf(o) != -1; }
    @Override public int size() { return size; }
    @Override public void clear() { head = tail = null; size = 0; }
    @Override public void set(int index, T item) { getNode(index).data = item; }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode curr = head;
        for (int i = 0; i < size; i++) {
            arr[i] = curr.data;
            curr = curr.next;
        }
        return arr;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;
            public boolean hasNext() { return current != null; }
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}