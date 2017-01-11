package heap;

/**
 * Created by harish.sharma on 2/13/16.
 */
public class NewMinHeap {

    private int[] internal;
    private int size;

    public NewMinHeap(int size) {
        this.internal = new int[size];
        this.size = 0;
    }

    public void put(int data) {
        if (size > internal.length - 1) throw new IllegalStateException("Sorry full...");
        internal[size] = data;
        int index = size;
        size++;
        heapUp(index);
    }

    public int peek() {
        if (size == 0) return Integer.MIN_VALUE;
        return internal[0];
    }

    public int deleteMin() {
        if (size < 0) return Integer.MIN_VALUE;
        int result = internal[0];
        internal[0] = internal[size - 1];
        size--;
        heapDown(0);
        return result;
    }

    public int parent(int n) {
        return (n - 1) / 2;
    }

    public int left(int n) {
        return 2 * n + 1;
    }

    public int right(int n) {
        return 2 * n + 2;
    }

    private void heapUp(int index) {
        if (index < 0 || index >= size) throw new IllegalStateException("Index out of bound ");
        int parent = parent(index);
        while (parent >= 0 && internal[parent] > internal[index]) {
            swap(parent, index);
            index = parent;
            parent = parent(index);
        }
    }

    private void swap(int parent, int index) {
        int temp = internal[parent];
        internal[parent] = internal[index];
        internal[index] = temp;
    }

    private void heapDown(int index) {
        if (index < 0 || index >= size) throw new IllegalStateException("Index out of bound");
        int left = left(index);
        int right = right(index);
        int moveIndex = left;
        while (left < size && right < size) {
            if (internal[right] < internal[left]) moveIndex = right;
            if (internal[index] > internal[moveIndex]) {
                swap(index, moveIndex);
                index = moveIndex;
                left = left(index);
                right = right(index);
            } else {
                break;
            }
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(" " + internal[i]);
        }
        System.out.println();
    }

    public static void main(String[] arg) {
        NewMinHeap heap = new NewMinHeap(10);
        heap.put(12);
        heap.put(5);
        heap.put(6);
        heap.put(4);
        heap.put(3);
        heap.put(1);
        heap.print();
        heap.deleteMin();
        heap.print();
        heap.deleteMin();
        heap.print();
        heap.deleteMin();
        heap.print();
    }
}
