package com.arcticsoft;

import java.util.List;

import java.util.ArrayList;

public class BST 
{
    Node root = null;

    public Node insert(int key) 
    {
        if (root == null) 
        {
            root = new Node(key, null, null, null);
            return root;
        } 
        else return insertRecursive(key, root);
    }

    private Node insertRecursive(int key, Node n) 
    {
        if (key < n.value) 
        {
            if (n.left == null) 
            {
                n.left = new Node(key, null, n, null);
                return n.left;
            }
            else return insertRecursive(key, n.left);
        } 
        else if (key > n.value) 
        {
            if (n.right == null) 
            {
                n.right = new Node(key, null, n, null);
                return n.right;
            }
            else return insertRecursive(key, n.right);
        } 
        else return n;
    }

    public int findNextInnorder(Node n) 
    {
        // Búsqueda hacia abajo
        if (n.right != null) {
            while (n.right != null) 
            {
                n = n.right;
                if (n.left != null) 
                {
                    while (n.left != null) n = n.left;
                    return n.value;
                }
            }
            return n.value;
        }
        // Búsqueda hacia arriba
        while (n.parent != null) {
            if (n == n.parent.left) return n.parent.value;
            n = n.parent;
        }
        return -1;
    }

    public List<Integer> listInOrder() 
    {
        List<Integer> list = new ArrayList<>();
        if (root != null) listInOrderRec(root, list);
        return list;
    }

    private void listInOrderRec(Node n, List<Integer> list) 
    {
        if (n.left != null) listInOrderRec(n.left, list);
        list.add(n.value);
        if (n.right != null) listInOrderRec(n.right, list);
    }
}