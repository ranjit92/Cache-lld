package com.ranjit.cache;

import com.ranjit.cache.exceptions.NotFoundException;
import com.ranjit.cache.exceptions.StorageFullException;
import com.ranjit.cache.policies.EvictionPolicy;
import com.ranjit.cache.storage.Storage;

public class Cache<Key, Value> {

	private final EvictionPolicy<Key> evictionPolicy;
	private final Storage<Key, Value> storage;
	
	public Cache(final EvictionPolicy<Key> evictionPolicy, final Storage<Key, Value> storage) {
		this.evictionPolicy = evictionPolicy;
		this.storage = storage;
	}
	
	public void put(Key k, Value v) {
		try {
			storage.add(k, v);
			evictionPolicy.keyAccessed(k);
		}
		catch(StorageFullException e) {
			System.out.println(e.getMessage());
			Key key = evictionPolicy.evictKey();

			if(key == null){
				throw new RuntimeException("Unexpected state storage is full but no key to evict");
			}
			try {
				this.storage.remove(key);
			} catch (NotFoundException ex) {
				System.out.println(e.getMessage());
			}
			put(k,v);
		}
	}
	
	public Value get(Key k) {
		Value value = null;
		try {
			value = storage.get(k);
			evictionPolicy.keyAccessed(k);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		if(value == null) {
			System.out.println("Key not found");
		}
		return value;
	}
}
