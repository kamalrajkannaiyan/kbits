package org.kml.binarysearchtree;

import sun.reflect.generics.tree.Tree;

public class TreeNode {
    public int data;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode(int data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return String.valueOf(data);
    }
}
