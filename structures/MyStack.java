public class MyStack<T extends Comparable<T>> {
    // We use ArrayList because adding/removing at the end is very fast
    private MyArrayList<T> list = new MyArrayList<>();

    public void push(T item) { list.addLast(item); }
    public T pop() {
        T item = list.getLast();
        list.removeLast();
        return item;
    }
    public T peek() { return list.getLast(); }
    public int size() { return list.size(); }
    public boolean isEmpty() { return list.size() == 0; }
}