package com.arcticsoft;

import java.util.List;

import java.util.ArrayList;

public class BST {
    private Node root = null;

    public Node insert(int key) {
        if (root == null) {
            root = new Node(key, null);
            return root;
        } 
        else return insertRecursive(key, root);
    }

    private Node insertRecursive(int key, Node n) {
        if (key < n.value()) {
            if (n.getLeft() == null) {
                return n.setLeft(new Node(key, n));
            }
            else return insertRecursive(key, n.getLeft());
        } 
        else if (key > n.value()) {
            if (n.getRight() == null) {
                return n.setRight(new Node(key, n));
            }
            else return insertRecursive(key, n.getRight());
        } 
        else return n;
    }

    public int findNextInnorder(Node n) {
        if (n == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        // Búsqueda hacia abajo
        if (n.getRight() != null) {
            while (n.getRight() != null) {
                n = n.getRight();
                if (n.getLeft() != null) {
                    while (n.getLeft() != null) {
                        n = n.getLeft();
                    }
                    return n.value();
                }
            }
            return n.value();
        }
        // Búsqueda hacia arriba
        while (n.getParent() != null) {
            if (n == n.getParent().getLeft()) {
                return n.getParent().value();
            }
            n = n.getParent();
        }
        return -1;
    }

    public List<Integer> listInOrder() {
        List<Integer> list = new ArrayList<>();
        if (root != null) listInOrderRec(root, list);
        return list;
    }

    private void listInOrderRec(Node n, List<Integer> list) {
        if (n.getLeft() != null) {
            listInOrderRec(n.getLeft(), list);  
        } 
        list.add(n.value());
        if (n.getRight() != null) {
            listInOrderRec(n.getRight(), list);
        }
    }

    public Node getRoot() {
        return root;
    }
}