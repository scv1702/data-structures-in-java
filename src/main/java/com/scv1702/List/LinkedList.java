package com.scv1702.List;

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {
    protected int size;
    protected Node<E> head;
    protected Node<E> tail;

    public LinkedList() {}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> curr = head;
        sb.append("[");
        while (curr != null) {
            sb.append(curr.getData()).append(", ");
            curr = curr.getNext();
        }
        if (sb.length() > 2) {
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("]");
        return sb.toString();
    }

    public Node<E> getNode(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException(index);
        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        return curr;
    }

    @Override
    public E get(int index) {
        return getNode(index).getData();
    }

    public void addFirst(E value) {
        Node<E> node = new Node<>(value, head);
        head = node;
        if (tail == null) {
            tail = node;
        }
        size++;
    }

    public void addLast(E value) {
        if (size == 0) {
            addFirst(value);
            return ;
        }
        Node<E> node = new Node<>(value);
        tail.setNext(node);
        tail = node;
        size++;
    }
    
    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    @Override
    public void add(int index, E value) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException(index);
        if (index == 0) {
            addFirst(value);
            return ;
        }
        if (index == size) {
            addLast(value);
            return ;
        }
        Node<E> prev = getNode(index-1);
        Node<E> curr = new Node<>(value, prev.getNext());
        prev.setNext(curr);
    }

    public E remove() {
        if (size <= 0) throw new NoSuchElementException();
        E res = head.getData();
        Node<E> nextHead = head.getNext();
        head.setData(null);
        head.setNext(null);
        head = nextHead;
        size--;
        if (size == 0) {
            tail = null;
        }
        return res;
    }

    @Override
    public E remove(int index) {
        if (index == 0) return remove();
        if (index >= size || index < 0) throw new IndexOutOfBoundsException(index);
        if (size <= 0) throw new NoSuchElementException();
        Node<E> prev = getNode(index-1);
        Node<E> next = prev.getNext().getNext();
        E res = prev.getNext().getData();
        prev.getNext().setData(null);
        prev.getNext().setNext(null);
        prev.setNext(next);
        size--;
        if (next == null) {
            tail = prev;
        }
        return res;
    }

    @Override
    public boolean remove(Object value) {
        if (value == null || size == 0) throw new NoSuchElementException();
        boolean hasValue = false;
        Node<E> prev = null;
        Node<E> curr = head;
        while (curr != null) {
            if (value.equals(curr.getNext())) {
                hasValue = true;
                break;
            }
            prev = curr;
            curr = curr.getNext();
        }
        if (curr == null) return false;
        if (curr == head) {
            remove();
            return true;
        }
        if (hasValue) {
            Node<E> next = curr.getNext();
            curr.setData(null);
            curr.setNext(null);
            prev.setNext(next);
            size--;
            if (next == null) {
                tail = prev;
            }
        }
        return true;
    }

    @Override
    public void set(int index, E value) {
        Node<E> node = getNode(index);
        node.setData(value);
    }

    @Override
    public boolean contains(Object value) {
        if (value == null) throw new NoSuchElementException();
        Node<E> curr = head;
        while (curr != head) {
            if (value.equals(curr.getData())) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        if (value == null) throw new NoSuchElementException();
        int index = 0;
        Node<E> curr = head;
        while (curr != head) {
            if (value.equals(curr.getData())) {
                return index;
            }
            curr = curr.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public void clear() {
        if (size == 0) return ;
        while (head != null) {
            remove();
        }
    }
}