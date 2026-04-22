package org.kml.binarytree;

import org.kml.binarysearchtree.TreeNode;

public class BuildDLLUsingInorderTraversal {
    static TreeNode head = null;
    static void buildDLL(TreeNode node){
        if(node == null) return;
        if(node.left != null){
            TreeNode rightLastNode = findRightLastNode(node.left);
            buildDLL(node.left);
            rightLastNode.right = node;
            if(head == null){
                head = node.left;
            }
        }

        if(node.right != null){
            TreeNode leftLastNode = findLeftLastNode(node.right);
            buildDLL(node.right);
            leftLastNode.left = node;
            node.right = leftLastNode;
        }
    }

    static TreeNode findRightLastNode(TreeNode node){
        while(node.right != null){
            node = node.right;
        }
        return node;
    }

    static TreeNode findLeftLastNode(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
    public static void main(String[] args) {

        /*
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(36);
        */

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(7);

        buildDLL(root);
        root = head;
        while (root != null){
            System.out.print(root.data + "->");
            root = root.right;
        }
   }
}
