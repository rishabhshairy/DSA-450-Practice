package com.trees.binarySearchTree;

import com.trees.TreeNode;

/**
 * IMP Question interview per se
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode currNode = root;
        while (true) {
            if (currNode.val <= val) {
                if (currNode.right != null) {
                    currNode = currNode.right;
                } else {
                    currNode.right = new TreeNode(val);
                    break;
                }
            } else {
                if (currNode.left != null) {
                    currNode = currNode.left;
                } else {
                    currNode.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
