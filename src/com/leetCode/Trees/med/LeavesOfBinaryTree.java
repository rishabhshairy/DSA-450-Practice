package com.leetCode.Trees.med;

import com.codingNinja.top100Tree.BinaryTreeNode;

import java.util.ArrayList;

public class LeavesOfBinaryTree {
    public static ArrayList<ArrayList<Integer>> collectLeaves(BinaryTreeNode<Integer> root) {
        ArrayList<ArrayList<Integer>> allLeaves = new ArrayList<>();
        BinaryTreeNode<Integer> prev = new BinaryTreeNode<>(0);
        prev.left = root;

        while (prev.left != null) {
            ArrayList<Integer> leaves = new ArrayList<>();
            solve(prev.left, prev, leaves);
            allLeaves.add(leaves);
        }
        return allLeaves;
    }

    private static void solve(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> prevNode, ArrayList<Integer> leaves) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leaves.add(root.data);
            // delink if prev node is just above leaf
            if (prevNode.left == root) {
                prevNode.left = null;
            } else {
                prevNode.right = null;
            }
        }
        solve(root.left, root, leaves);
        solve(root.right, root, leaves);
    }
}
