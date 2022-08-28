package com.arcticsoft;

import java.util.List;

import java.util.ArrayList;

public class BST {
    private Node root = null;

    public Node getRoot() {
        return root;
    }

    public Node insert(int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        } 
        else return insertRecursive(key, root);
    }

    private Node insertRecursive(int key, Node n) {
        if (key < n.value()) {
            if (n.left() == null) {
                return n.setLeft(new Node(key));
            }
            else return insertRecursive(key, n.left());
        } 
        else if (key > n.value()) {
            if (n.right() == null) {
                return n.setRight(new Node(key));
            }
            else return insertRecursive(key, n.right());
        } 
        else return n;
    }

    public int findNextInnorder(Node n) {
        if (n == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        // Búsqueda hacia abajo
        if (n.right() != null) {
            while (n.right() != null) {
                n = n.right();
                if (n.left() != null) {
                    while (n.left() != null) {
                        n = n.left();
                    }
                    return n.value();
                }
            }
            return n.value();
        }
        // Búsqueda hacia arriba
        while (n.getParent() != null) {
            if (n == n.getParent().left()) {
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
        if (n.left() != null) {
            listInOrderRec(n.left(), list);
        } 
        list.add(n.value());
        if (n.right() != null) {
            listInOrderRec(n.right(), list);
        }
    }
}