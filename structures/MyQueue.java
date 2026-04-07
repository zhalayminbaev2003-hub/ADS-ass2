public class MyQueue<T extends Comparable<T>> {
    // We use LinkedList because removing from the front is O(1) efficiency
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T item) { list.addLast(item); }
    public T dequeue() {
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }
    public T peek() { return list.getFirst(); }
    public int size() { return list.size(); }
    public boolean isEmpty() { return list.size() == 0; }
}