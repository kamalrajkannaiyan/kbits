package org.kml.binarysearchtree;

public class KthSmallestLargest {
    static int kthSmallest(TreeNode root, int[] k)
    {
        if(root == null) return -1;
        int left = kthSmallest(root.left, k);
        if(left != -1) return left;
        if(--k[0] == 0)
            return root.data;
        return kthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        //root.right = new TreeNode(10);
        //root.right.right = new TreeNode(15);
        //root.right.right.right = new TreeNode(20);

        System.out.println("Kth smallest - " + kthSmallest(root, new int[]{2}));
    }
}
