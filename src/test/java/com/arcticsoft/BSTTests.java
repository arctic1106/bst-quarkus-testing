package com.arcticsoft;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BSTTests 
{
    BST bst;

    @BeforeEach
    void init() {
        bst = new BST();
    }

    @Test
    public void creationTest() {
        assertNotNull(bst);
    }

    @Test
    public void InsertBSTTest()
    {
        List<Integer> list = Arrays.asList(5, 9, 11, 12, 13, 14, 20, 25);
        List<Integer> insertList = new ArrayList<>(list);
        Collections.shuffle(insertList);
        insertList.stream().forEach(value -> bst.insert(value));
        assertEquals(list, bst.listInOrder());
    }

    @Test
    public void insertNoDuplicatesTest()
    {
        List<Integer> list = Arrays.asList(20, 15, 7, 283, 534, 1, 45);
        list.stream().forEach(value -> bst.insert(value));
        bst.insert(20);
        bst.insert(534);
        Node n = bst.insert(1);
        assertEquals(1, n.value);

        List<Integer> listCopy = new ArrayList<>(list);
        listCopy.sort((i, j) -> i - j);
        // Collections.sort(listCopy);
        assertEquals(listCopy, bst.listInOrder());
    }

    @Test   
    public void findNextInOrderTest()
    {   
        List<Integer> list = Arrays.asList(5, 9, 11, 12, 13, 14, 20, 25);
        list.stream().forEach(value -> bst.insert(value));
        Node n = bst.insert(6);
        assertEquals(9, bst.findNextInnorder(n));
    }
}