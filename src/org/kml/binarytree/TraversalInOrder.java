package org.kml.binarytree;

import org.kml.binarysearchtree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalInOrder
{
    static  List<Integer> inOrderIter(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> parkingStack = new Stack<>();
        Stack<TreeNode> processingStack = new Stack<>();
        parkingStack.add(root);
        while(!parkingStack.isEmpty() || !processingStack.isEmpty())
        {
            while (!parkingStack.isEmpty())
            {
                TreeNode curr = parkingStack.pop();
                processingStack.add(curr);
                if(curr.left != null)
                    parkingStack.add(curr.left);
            }
            TreeNode curr = processingStack.pop();
            ans.add(curr.data);
            if(curr.right != null)
                parkingStack.add(curr.right);
        }
        return ans;
    }
    static  List<Integer> inOrderRec(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        ans.addAll(inOrderRec(root.left));
        ans.add(root.data);
        ans.addAll(inOrderRec(root.right));
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);

        System.out.println(inOrderRec(root));
        System.out.println(inOrderIter(root));
    }
}
