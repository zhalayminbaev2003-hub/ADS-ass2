public class Main {
    public static void main(String[] args) {
        System.out.println("Testing MyArrayList:");
        MyArrayList<Integer> arr = new MyArrayList<>();
        arr.add(10); arr.add(5); arr.add(20);
        arr.sort();
        for(Integer i : arr) System.out.print(i + " "); // Output: 5 10 20

        System.out.println("\n\nTesting MyStack:");
        MyStack<String> stack = new MyStack<>();
        stack.push("A"); stack.push("B");
        System.out.println("Pop: " + stack.pop()); // Output: B

        System.out.println("\nTesting MyMinHeap:");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(50); heap.insert(10); heap.insert(30);
        System.out.println("Min: " + heap.extractMin()); // Output: 10
    }
}