package com.arcticsoft;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class NodeTests {
    
    @Test
    void createNode() {
        var node = new Node(1, null);
        assertEquals(1, node.value());
    }

    @Test
    void addChild() {
        var root = new Node(1, null);
        var leftChild = new Node(2, root);
        root.setLeft(leftChild);
        var rightChild = new Node(3, root);
        root.setRight(rightChild);
        assertEquals(leftChild, root.getLeft());
        assertEquals(1, leftChild.getParent().value());
        assertEquals(rightChild, root.getRight());
        assertEquals(1, rightChild.getParent().value());
    }
}