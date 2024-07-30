package concurrency;

import java.util.HashMap;
import java.util.Map;

public class LRUCache1<K, V> implements Cache<K, V> {
    private final Map<K, Node<K, V>> map;
    private Node<K, V> head;
    private Node<K, V> tail;
    private final int capacity;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
    }

    @Override
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.value = value;
            moveToFront(node);
            return;
        }
        Node<K, V> node = new Node<>(key, value);
        if (map.size() == capacity) {
            map.remove(tail.key);
            deleteNode(tail);
        }
        map.put(key, node);
        addFirst(node);
    }

    @Override
    public V get(K key) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            moveToFront(node);
            return node.value;
        }
        return null;
    }

    private void moveToFront(Node node) {
        deleteNode(node);
        addFirst(node);
    }

    private void addFirst(Node<K, V> node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    private void deleteNode(Node<K, V> node) {
        Node<K, V> prev = node.prev;
        Node<K, V> next = node.next;

        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }

        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;
        private Node<K, V> prev;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
