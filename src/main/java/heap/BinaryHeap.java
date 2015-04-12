package heap;

import java.util.NoSuchElementException;

import array.Util;

public class BinaryHeap {

    private int[] heap;
    private int   size;

    public BinaryHeap(int capacity) {
        heap = new int[capacity];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public void makeEmpty() {
        size = 0;
    }

    private int parent(int a) {
        return (a - 1) / 2;
    }

    private int left(int a) {
        return 2 * a + 1;
    }

    private int right(int a) {
        return 2 * (a + 1);
    }

    public void insert(int a) {
        if (isFull()) throw new IllegalStateException("Heap is full cannot insert");
        heap[size++] = a;
        heapifyUp(size - 1);
    }

    public int findMin() {
        if (isEmpty()) throw new NoSuchElementException("Heap Empty");
        return heap[0];
    }

    public int deleteMin() {
        return deleteAt(0);
    }

    public int deleteAt(int index) {
        if (index < 0 || index > size - 1) throw new IllegalArgumentException("Index out of bound");
        int ele = heap[index];
        heap[index] = heap[--size];
        heapifyDown(index);
        return ele;
    }

    private void heapifyUp(int index) {
        if (index == 0) return;
        int parent = parent(index);
        if (heap[parent] > heap[index]) {
            Util.swap(heap, parent, index);
        }
        heapifyUp(parent);
    }

    private void heapifyDown(int index) {
        if (index >= (size / 2)) return;
        int leftIdx = left(index);
        int rightIdx = right(index);
        int minIdx = leftIdx;
        if (heap[leftIdx] > heap[rightIdx]) {
            minIdx = rightIdx;
        }
        Util.swap(heap, index, minIdx);
        heapifyDown(minIdx);
    }

    public void printHeap() {
        System.out.print("\nHeap = ");
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(10);
        heap.insert(5);
        heap.insert(3);
        heap.insert(2);
        heap.insert(10);
        heap.insert(7);
        heap.printHeap();
        heap.deleteMin();
        heap.insert(0);
        heap.printHeap();
        heap.deleteAt(1);
        heap.printHeap();
    }
}
