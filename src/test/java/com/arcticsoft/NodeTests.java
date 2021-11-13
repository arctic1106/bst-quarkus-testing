package com.arcticsoft;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NodeTests
{
    Node node;
    
    @Test
    void createNode(){
        node = new Node(1, null, null, null);
        assertEquals(1, node.value);
    }
}
