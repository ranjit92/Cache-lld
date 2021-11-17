package com.ranjit.cache.policies;

/**
 * @param <Key>
 */
public interface EvictionPolicy<Key> {

    void keyAccessed(Key key);

    Key evictKey();
}
