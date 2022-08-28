package com.arcticsoft;

class Node {
    private final int value;
    private Node parent;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public Node getParent() {
        return parent;
    }

    public Node left() {
        return left;
    }

    public Node setLeft(Node n) {
        n.parent = this;
        return left = n;
    }

    public Node right() {
        return right;
    }

    public Node setRight(Node n) {
        n.parent = this;
        return right = n;
    }
}