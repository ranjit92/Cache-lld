package com.ranjit.cache.storage;

import com.ranjit.cache.exceptions.NotFoundException;
import com.ranjit.cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {
    private final int capacity;
    private final Map<Key, Value> storage;


    public HashMapBasedStorage(int capacity) {
        this.capacity = capacity;
        this.storage = new HashMap<>();
    }


    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if (isFull()) throw new StorageFullException("Storage is full");
        storage.put(key, value);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if (!storage.containsKey(key)) throw new NotFoundException(key + " " + "doesn't exist in cache");
        storage.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if (!storage.containsKey(key)) throw new NotFoundException(key + " " + "doesn't exist in cache");
        return storage.get(key);
    }

    public boolean isFull() {
        return capacity == storage.size();
    }

}
