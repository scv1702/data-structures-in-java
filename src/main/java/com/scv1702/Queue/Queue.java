package com.scv1702.Queue;

public interface Queue<T> {
    void offer(T item);
    T poll();
    T peek();
    int size();
    boolean isEmpty();
}
