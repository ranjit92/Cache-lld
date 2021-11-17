package com.ranjit.algorithms;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DLLTest {

    @Test
    void testDLLAdditions() {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);

        dll.addNodeAtLast(node1);
        verifyDLL(dll,List.of(1));

        dll.addNodeAtLast(node2);
        verifyDLL(dll, List.of(1, 2));

        dll.addNodeAtLast(node3);
        verifyDLL(dll, List.of(1, 2, 3));

        dll.addNodeAtLast(node4);
        verifyDLL(dll, List.of(1, 2,3,4));


    }


    @Test
    void testDLLDetachment() {

        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        Node<Integer> node1 = dll.addElementAtLast(1);
        Node<Integer> node2 = dll.addElementAtLast(2);
        Node<Integer> node3 = dll.addElementAtLast(3);
        Node<Integer> node4 = dll.addElementAtLast(4);

        verifyDLL(dll, List.of(1, 2, 3, 4));

        dll.detached(node3);
        verifyDLL(dll, List.of(1, 2, 4));

        dll.detached(null);
        verifyDLL(dll, List.of(1, 2, 4));
    }

    void verifyDLL(DoublyLinkedList<Integer> dll, List<Integer> expectedList) {
        assertEquals(expectedList.get(expectedList.size() - 1), dll.getLastNode().element);
        assertEquals(expectedList.get(0), dll.getFirstNode().element);

        Node currNode = dll.getFirstNode();

        for (Integer value : expectedList) {
            assertNotNull(currNode);
            assertEquals(value, currNode.element);
            currNode = currNode.next;
        }
    }
}
