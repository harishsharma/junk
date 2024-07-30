package concurrency;

import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class TreiberStack {

    AtomicReference<Node> top = new AtomicReference<TreiberStack.Node>();

    public void push(Integer item) {
        Node newNode = new Node(item);
        Node oldTop;
        do {
            oldTop = top.get();
            newNode.next = oldTop;
        } while (!top.compareAndSet(oldTop, newNode));
    }

    public Integer pop() {
        Node newHead;
        Node oldHead;
        do {
            oldHead = top.get();
            if (oldHead == null) return null;
            newHead = oldHead.next;
        } while (!top.compareAndSet(oldHead, newHead));
        Integer res = oldHead.item;
        return res;
    }

    private static class Node {
        Integer item;
        Node    next;

        public Node(Integer item) {
            this.item = item;
            this.next = null;
        }
    }
}
