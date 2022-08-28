package com.arcticsoft;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NodeTests {
    
    @Test
    void createNode() {
        var node = new Node(1);
        assertEquals(1, node.value());
    }

    @Test
    void addChild() {
        var root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        assertEquals(2, root.left().value());
        assertEquals(1, root.left().getParent().value());
        assertEquals(3, root.right().value());
        assertEquals(1, root.right().getParent().value());
    }
}