package com.arcticsoft;

class Node {
    private int value;
    private Node left;
    private Node parent;
    private Node right;

    public Node(int value, Node parent) {
        this.value = value;
        this.parent = parent;
    }

    public int value() {
        return value;
    }

    public Node getParent() {
        return parent;
    }

    public Node getLeft() {
        return left;
    }

    public Node setLeft(Node n) {
        return left = n;
    }

    public Node getRight() {
        return right;
    }

    public Node setRight(Node n) {
        return right = n;
    }
}