package com.ranjit.policies;

import com.ranjit.cache.policies.EvictionPolicy;
import com.ranjit.cache.policies.LRUEvictionPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvictionPolicyTest {

    private EvictionPolicy<Integer> lru;

    @BeforeEach
    void setup() {
        lru = new LRUEvictionPolicy<>();
    }

    @Test
    void testKeysAreEvictedInTheOrderInWhichTheyAreInserted() {
        lru.keyAccessed(1);
        lru.keyAccessed(2);
        lru.keyAccessed(3);
        lru.keyAccessed(4);
        lru.keyAccessed(5);

        assertEquals(1, lru.evictKey());
        assertEquals(2, lru.evictKey());
        assertEquals(3, lru.evictKey());
        assertEquals(4, lru.evictKey());
        assertEquals(5, lru.evictKey());

    }

    @Test
    void testReassessingKeyPreventItFromEviction() {
        lru.keyAccessed(1);
        lru.keyAccessed(2);
        lru.keyAccessed(3);
        lru.keyAccessed(4);
        lru.keyAccessed(5);
        lru.keyAccessed(2);
        lru.keyAccessed(4);
        lru.keyAccessed(1);

        assertEquals(3, lru.evictKey());
        assertEquals(5, lru.evictKey());
        assertEquals(2, lru.evictKey());
        assertEquals(4, lru.evictKey());
    }
}
