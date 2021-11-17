package com.ranjit.algorithms;

import com.ranjit.algorithms.exceptions.InvalidElementException;

public class DoublyLinkedList<Key> {

	private Node<Key> head;
	private Node<Key> tail;

	public DoublyLinkedList() {
		head = new Node<>(null);
		tail = new Node<>(null);

		head.next = tail;
		tail.prev = head;
	}

	public void detached(Node<Key> node) {
		if (node != null) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
	}

	public void addNodeAtLast(Node<Key> node) {

		if (node != null) {
			Node tailPrev = tail.prev;
			tailPrev.next= node;
			node.next = tail;
			tail.prev = node;
			node.prev = tailPrev;
		}
	}

	public Node<Key> addElementAtLast(Key key) {
		if (key == null) {
			throw new InvalidElementException("Null Element");
		}
		Node<Key> node = new Node(key);
		addNodeAtLast(node);
		return node;
	}

	public boolean isItemPresent() {
		return head.next != tail;
	}

	public Node<Key> getFirstNode(){
		if(!isItemPresent()) {
			return null;
		}
		return head.next;
	}

	public Node<Key> getLastNode() {
		if(!isItemPresent()) {
			return null;
		}
		return tail.prev;
	}

}
