package com.scv1702.List;

public class Node<E> {
	private E data;
    private Node<E> next;
    
    public Node(E data) {
        this.data = data;
    }
    
    public Node(E data, Node<E> next) {
        this.data = data; 
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setNext(Node<E> node) {
        this.next = node;
    }
}