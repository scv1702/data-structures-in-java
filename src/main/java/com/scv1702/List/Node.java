package com.scv1702.List;

public class Node<E> {
	E data;
    Node<E> next;
    
    Node(E data) {
        this.data = data;
    }
    
    Node(E data, Node<E> next) {
        this.data = data; 
        this.next =next;
    }
}