import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] elements;
    private int size;

    public MyArrayList() {
        this.elements = new Object[10]; // Start with capacity for 10 items
        this.size = 0;
    }

    // This helper method doubles the array size when it is full
    private void growIfNeeded() {
        if (size == elements.length) {
            Object[] newArr = new Object[elements.length * 2];
            for (int i = 0; i < size; i++) {
                newArr[i] = elements[i];
            }
            elements = newArr;
        }
    }

    @Override
    public void add(T item) {
        growIfNeeded();
        elements[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        growIfNeeded();
        // Shift items to the right to make space
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        size++;
    }

    @Override public void addFirst(T item) { add(0, item); }
    @Override public void addLast(T item) { add(item); }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override public T getFirst() { return get(0); }
    @Override public T getLast() { return get(size - 1); }

    @Override
    public void remove(int index) {
        checkIndex(index);
        // Shift items to the left to fill the gap
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    @Override public void removeFirst() { remove(0); }
    @Override public void removeLast() { remove(size - 1); }

    @Override
    @SuppressWarnings("unchecked")
    public void sort() {
        // Simple bubble sort using Comparable
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((T)elements[j]).compareTo((T)elements[j+1]) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }

    @Override public boolean exists(Object object) { return indexOf(object) != -1; }
    @Override public int size() { return size; }
    @Override public void clear() { size = 0; }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++) arr[i] = elements[i];
        return arr;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;
            public boolean hasNext() { return cursor < size; }
            @SuppressWarnings("unchecked")
            public T next() { return (T) elements[cursor++]; }
        };
    }
}