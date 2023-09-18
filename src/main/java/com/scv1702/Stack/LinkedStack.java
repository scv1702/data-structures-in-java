package com.scv1702.Stack;

import com.scv1702.List.LinkedList;

public class LinkedStack<T> extends LinkedList<T> implements Stack<T>{
    public LinkedStack() {
        super();
    }

    public void push(T item) {
        addFirst(item);
    }

    public T peek() {
        return head.getData();
    }

    public T pop() {
        return remove();
    }

    public int size() {
        return super.size();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }
}
