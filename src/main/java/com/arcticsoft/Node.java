package com.arcticsoft;

class Node 
{
    int value;
    Node left;
    Node parent;
    Node right;

    public Node(int value, Node left, Node parent, Node right) 
    {
        this.value = value;
        this.left = left;
        this.parent = parent;
        this.right = right;
    }
}