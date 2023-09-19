package com.scv1702.Queue;

import com.scv1702.List.LinkedList;

public class LinkedQueue<T> extends LinkedList<T> implements Queue<T>{
    public LinkedQueue() {
        super();
    }

    public void offer(T item) {
        addLast(item);
    }

    public T poll() {
        return remove();
    }

    public T peek() {
        return head.getData();
    }

    public int size() {
        return super.size();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }
}
