public class MyMinHeap<T extends Comparable<T>> {
    // We use ArrayList because we can easily calculate parent/child positions using math
    private MyArrayList<T> list = new MyArrayList<>();

    public void insert(T item) {
        list.add(item);
        traverseUp(list.size() - 1);
    }

    public T extractMin() {
        if (list.size() == 0) return null;
        T min = list.getFirst();
        list.set(0, list.getLast());
        list.removeLast();
        traverseDown(0);
        return min;
    }

    private void traverseUp(int index) {
        while (index > 0 && list.get(index).compareTo(list.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void traverseDown(int index) {
        while (2 * index + 1 < list.size()) {
            int j = 2 * index + 1; // Left child
            if (j + 1 < list.size() && list.get(j).compareTo(list.get(j + 1)) > 0) j++; // Right child
            if (list.get(index).compareTo(list.get(j)) <= 0) break;
            swap(index, j);
            index = j;
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public T peekMin() { return list.getFirst(); }
    public int size() { return list.size(); }
}