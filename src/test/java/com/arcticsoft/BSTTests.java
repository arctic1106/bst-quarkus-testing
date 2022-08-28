package com.arcticsoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class BSTTests {
    BST bst;
    List<Integer> list;

    @BeforeEach
    void init() {
        bst = new BST();
        list = Arrays.asList(20, 15, 7, 283, 534, 1, 45);
    }

    @Test
    public void creation() {
        assertNotNull(bst);
        assertEquals(new ArrayList<Integer>(Collections.emptyList()), bst.listInOrder());
        Executable exec = () -> bst.findNextInnorder(bst.getRoot());
        assertThrows(IllegalArgumentException.class, exec);
    }

    @Test
    public void InsertIsOrderedBST() {
        List<Integer> insertList = new ArrayList<>(list);
        List<Integer> expectedOrderedList = List.of(1, 7, 15, 20, 45, 283, 534);
        Collections.shuffle(insertList);
        insertList.forEach(value -> bst.insert(value));
        assertEquals(expectedOrderedList, bst.listInOrder());
    }

    @Test
    public void insertHasNoDuplicates() {
        list.forEach(value -> bst.insert(value));
        bst.insert(20);
        bst.insert(534);
        bst.insert(1);
        Collections.sort(list);
        assertEquals(list, bst.listInOrder());
    }

    @Test   
    public void findNextInOrder() {   
        List<Integer> list = Arrays.asList(5, 9, 11, 12, 13, 14, 20, 25);
        list.forEach(value -> bst.insert(value));
        Node n = bst.insert(6);
        assertEquals(9, bst.findNextInnorder(n));
    }
}