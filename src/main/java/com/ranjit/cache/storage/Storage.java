package com.ranjit.cache.storage;

import com.ranjit.cache.exceptions.NotFoundException;
import com.ranjit.cache.exceptions.StorageFullException;

public interface Storage<Key, Value> {

	 void add (Key key , Value value) throws StorageFullException;
	 void remove(Key key) throws NotFoundException;
	 Value get(Key key) throws NotFoundException;
}
