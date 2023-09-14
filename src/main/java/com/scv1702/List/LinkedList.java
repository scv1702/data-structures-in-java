package com.scv1702.List;

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {
    int size;
    Node<E> head;
    Node<E> tail;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> curr = head;
        sb.append("[");
        while (curr != null) {
            sb.append(curr.data).append(", ");
            curr = curr.next;
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
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    public void addFirst(E value) {
        Node<E> node = new Node<>(value);
        node.next = head;
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
        tail.next = node;
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
        Node<E> curr = new Node<>(value, prev.next);
        prev.next = curr;
    }

    public E remove() {
        if (size <= 0) throw new NoSuchElementException();
        E res = head.data;
        Node<E> nextHead = head.next;
        head.data = null;
        head.next = null;
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
        Node<E> next = prev.next.next;
        E res = prev.next.data;
        prev.next.data = null;
        prev.next.next = null;
        prev.next = next;
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
            if (value.equals(curr.next)) {
                hasValue = true;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) return false;
        if (curr == head) {
            remove();
            return true;
        }
        if (hasValue) {
            Node<E> next = curr.next;
            curr.data = null;
            curr.next = null;
            prev.next = next;
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
        node.data = value;
    }

    @Override
    public boolean contains(Object value) {
        if (value == null) throw new NoSuchElementException();
        Node<E> curr = head;
        while (curr != head) {
            if (value.equals(curr.data)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        if (value == null) throw new NoSuchElementException();
        int index = 0;
        Node<E> curr = head;
        while (curr != head) {
            if (value.equals(curr.data)) {
                return index;
            }
            curr = curr.next;
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