package trees.segment;

public abstract class Node<T> {
    int start, end;

    protected abstract void assignLeaf(T a);

    protected abstract void merge(Node<T> left, Node<T> right);

    protected abstract T getValue();
}
