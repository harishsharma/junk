package junk;

import lombok.Data;

/**
 * Created by harish.sharma on 10/12/16.
 */
public class HashMap<K, V> {

    private final int size;
    private final Entry[] elems;
    private int count;
    private Entry<K, V> head;
    private Entry<K, V> tail;

    public HashMap(int size) {
        this.size = size;
        this.count = 0;
        this.elems = new Entry[size];
    }

    private int hashToSlot(K key) {
        return (key.hashCode() % size + size) % size;
    }

    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("Null not supported");
        int slot = hashToSlot(key);
        Entry<K, V> entry = elems[slot];
        if (entry == null) return null;
        Entry<K, V> e = entry;
        while (e != null) {
            if (e.key.equals(key)) {
                if (e != tail) {
                    Entry<K, V> t = tail;
                    if (e.back != null)
                        e.back.front = e.front;
                    if (e.front != null)
                        e.front.back = e.back;
                    if (e == head) {
                        head = e.front;
                    }
                    tail.front = e;
                    e.front = null;
                    e.back = tail;
                    tail = e;
                }
                return e.value;
            }
            e = e.next;
        }
        return null;
    }

    public void put(K key, V value) {
        if (key == null || value == null) throw new IllegalArgumentException("Null not supported");

        //Check if we need to delete item.
        if (count == size) {
            Entry<K, V> h = head;
            int slot = hashToSlot(h.key);
            Entry<K, V> e = elems[slot];
            if (e == h) {
                elems[slot] = e.next;
                e.next = null;
            } else {
                while (e.next != h) {
                    e = e.next;
                }
                e.next = e.next.next;
            }
            //Remove the pointers back and front.
            head = h.front;
            h.front = null;
            count--;
        }

        int slot = hashToSlot(key);
        Entry<K, V> entry = elems[slot];
        count++;
        if (entry == null) {
            entry = new Entry<>(key, value);
            elems[slot] = entry;
            addEntryInTheBack(entry);
            return;
        }
        Entry<K, V> e = entry;
        while (e.next != null) {
            if (e.key.equals(key)) {
                e.value = value;
                return;
            }
            e = e.next;
        }
        if (e.key.equals(key)) {
            e.value = value;
            return;
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        e.next = newEntry;
        addEntryInTheBack(newEntry);
    }

    private void addEntryInTheBack(Entry<K, V> entry) {
        Entry<K, V> end = tail;
        tail = entry;
        if (end == null) {
            head = entry;
        } else {
            end.front = tail;
            tail.back = end;
        }
    }


    public void toString(int n) {
        Entry<K, V> h = head;
        while (h != null) {
            System.out.print(h.key + " ");
            h = h.front;
        }
        System.out.println();
    }

    @Data
    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;
        private Entry<K, V> front;
        private Entry<K, V> back;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.front = null;
            this.back = null;
        }

        public String toString() {
            return key + " " + value;
        }

    }

    public static void main(String[] arg) {
        HashMap<String, String> map = new HashMap<>(3);
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        map.toString(1);
        map.get("1");
        map.toString(1);
        map.put("4", "four");
        map.toString(1);
        //System.out.println(map.get("harihs"));
        System.out.println(map.head);
        System.out.println(map.tail);
    }
}
