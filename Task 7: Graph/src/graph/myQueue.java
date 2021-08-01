package graph;

import java.util.LinkedList;
import java.util.Queue;

public class myQueue<T> implements DataStructure<T> {
    Queue<T> q = new LinkedList<>();


    public T pop() {
        return q.remove();
    }

    @Override
    public void push(T x) {
        q.add(x);
    }

    @Override
    public boolean isEmpty() {
        return q.isEmpty();
    }
}
