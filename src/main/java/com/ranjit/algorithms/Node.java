package com.ranjit.algorithms;

public class Node<Key> {

	public Node next;
	public Node prev;
	public Key element;
	
	public Node(Key element) {
		this.next = null;
		this.prev = null;
		this.element = element;
	}
}
