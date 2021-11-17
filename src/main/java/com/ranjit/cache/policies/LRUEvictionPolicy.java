package com.ranjit.cache.policies;

import com.ranjit.algorithms.DoublyLinkedList;
import com.ranjit.algorithms.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private DoublyLinkedList<Key> dll;
    private Map<Key, Node<Key>> mapper;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if (mapper.containsKey(key)) {
            dll.detached(mapper.get(key));
            dll.addElementAtLast(key);
        } else {
            Node<Key> newNode = dll.addElementAtLast(key);
            mapper.put(key, newNode);
        }
    }

    @Override
    public Key evictKey() {
        Node<Key> firstNode = dll.getFirstNode();
        if (firstNode != null) {
            dll.detached(firstNode);
            return firstNode.element;
        }
        return null;
    }

}
