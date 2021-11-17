package com.ranjit.cache.factories;

import com.ranjit.cache.Cache;
import com.ranjit.cache.policies.LRUEvictionPolicy;
import com.ranjit.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache(){
        return new Cache<>(new LRUEvictionPolicy<Key>(), new HashMapBasedStorage<Key,Value>(16));

    }

}
