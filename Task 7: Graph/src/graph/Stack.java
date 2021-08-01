package graph;


import java.util.EmptyStackException;
import java.util.Vector;

public class Stack<T> extends Vector<T>
        implements DataStructure<T> {

    public Stack() {
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public void push(T item) {
        this.addElement(item);
    }

    public synchronized T pop() {
        int len = this.size();
        T obj = this.peek();
        this.removeElementAt(len - 1);
        return obj;
    }

    public synchronized T peek() {
        int len = this.size();
        if (len == 0) {
            throw new EmptyStackException();
        } else {
            return this.elementAt(len - 1);
        }
    }
}

