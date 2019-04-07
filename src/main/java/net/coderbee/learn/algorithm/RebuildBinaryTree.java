package net.coderbee.learn.algorithm;

import net.coderbee.learn.datastructure.TreeNode;

import java.util.Collections;
import java.util.List;

public class RebuildBinaryTree {

    public static <T extends Comparable> TreeNode<T> rebuild(List<TreeNode<T>> preOrder, List<TreeNode<T>> inOrder) {
        if (preOrder.isEmpty()) {
            return null;
        }
        if (preOrder.size() == 1) {
            return preOrder.get(0);
        }

        TreeNode<T> root = preOrder.get(0);
        int rootIndex = inOrder.indexOf(root);

        if (rootIndex > 0) {
            List<TreeNode<T>> leftPreOrder = preOrder.subList(1, rootIndex + 1);
            List<TreeNode<T>> leftInOrder = inOrder.subList(0, rootIndex);
            root.setLeftTree(rebuild(leftPreOrder, leftInOrder));
        }
        if (rootIndex < inOrder.size()) {
            List<TreeNode<T>> rightPreOrder = preOrder.subList(rootIndex + 1, preOrder.size());
            List<TreeNode<T>> rightInOrder = inOrder.subList(rootIndex + 1, inOrder.size());
            root.setRightTree(rebuild(rightPreOrder, rightInOrder));
        }

        return root;
    }

}
