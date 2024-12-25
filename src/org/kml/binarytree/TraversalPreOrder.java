package org.kml.binarytree;

import org.kml.binarysearchtree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class TraversalPreOrder
{
    static List<Integer> preOrderMoris(TreeNode root)
    {
        List<Integer> traversal = new ArrayList<>();
        //if(root == null) return traversal;
        TreeNode curr = root;
        while(curr != null)
        {
            if(curr.left == null)
            {
                traversal.add(curr.data);
                curr = curr.right;
            }
            else
            {
                TreeNode inOrderPredecessor = findnOrderPredecessor(curr);
                if(inOrderPredecessor.right == null)
                {
                    inOrderPredecessor.right = curr;
                    traversal.add(curr.data);
                    curr = curr.left;
                }
                else
                {
                    inOrderPredecessor.right = null;
                    curr = curr.right;
                }
            }
        }
        return traversal;
    }
    static TreeNode findnOrderPredecessor(TreeNode root)
    {
        TreeNode inOrderPredecessor = root.left;
        while (inOrderPredecessor.right != null && inOrderPredecessor.right != root)
        {
            inOrderPredecessor = inOrderPredecessor.right;
        }
        return inOrderPredecessor;
    }

    static List<Integer> preOrderRec(TreeNode root)
    {
        List<Integer> traversal = new ArrayList<>();
        if(root == null) return traversal;
        traversal.add(root.data);
        traversal.addAll(preOrderRec(root.left));
        traversal.addAll(preOrderRec(root.right));
        return traversal;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);

        System.out.println(preOrderMoris(root));
        System.out.println(preOrderRec(root));
    }

}
