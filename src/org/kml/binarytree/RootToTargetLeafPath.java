package org.kml.binarytree;

import org.kml.binarysearchtree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToTargetLeafPath {

    static List<Integer> rootToTargetLeaf(TreeNode root, int target, List<Integer> path) {
        if (root == null) return path;
        path.add(root.data);
        if (root.left == null && root.right == null) {
            if (root.data == target) {
                return path;
            }
            path.remove(path.size() - 1);
            return path;
        }
        List<Integer> newPath = rootToTargetLeaf(root.left, target, path);
        if (path.get(path.size() - 1) == target && root.left == null && root.right == null) {
            return newPath;
        }

        List<Integer> newPath1 = rootToTargetLeaf(root.right, target, path);
        if (path.get(path.size() - 1) == target && root.left == null && root.right == null) {
            return newPath1;
        }
        path.remove(path.size() - 1);
        return path;
    }
    static boolean rootToTargetLeafBoolean(TreeNode root, int target, List<Integer> path) {
        if (root == null) return false;
        path.add(root.data);
        if (root.left == null && root.right == null) {
            if (root.data == target) {
                return true;
            }
            path.remove(path.size() - 1);
            return false;
        }
        boolean foundPathInLeft = rootToTargetLeafBoolean(root.left, target, path);
        if (foundPathInLeft) {
            return foundPathInLeft;
        }

        boolean foundPathInRight = rootToTargetLeafBoolean(root.right, target, path);
        if (foundPathInRight) {
            return foundPathInRight;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);

        int target = 10;
        List<Integer> path = rootToTargetLeaf(root, target, new ArrayList<>());
        System.out.println(path);
        List<Integer> path1 = new ArrayList<>();
        rootToTargetLeafBoolean(root, target, path1);
        System.out.println(path1);
    }
}
