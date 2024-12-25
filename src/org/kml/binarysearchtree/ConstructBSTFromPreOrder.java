package org.kml.binarysearchtree;

public class ConstructBSTFromPreOrder {
    static public TreeNode bstFromPreorder(int[] preorder, int start, int end)
    {
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int leftEnd = start;
        for(int idx = start + 1; idx <= end; idx++)
        {
            if(preorder[start] > preorder[idx])
            {
                leftEnd = idx;
            }
        }
        root.left = bstFromPreorder(preorder, start + 1, leftEnd);
        root.right = bstFromPreorder(preorder, leftEnd + 1, end);
        return root;
    }
    static public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    public static void main(String[] args) {
        int[] preOrder = {8, 5, 1, 7, 10, 12};
        //int[] preOrder = {5, 1, 7};
        TreeNode root = bstFromPreorder(preOrder);
        System.out.println(root);
    }
}
