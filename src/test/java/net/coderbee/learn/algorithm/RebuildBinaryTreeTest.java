package net.coderbee.learn.algorithm;

import net.coderbee.learn.datastructure.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RebuildBinaryTreeTest {

    @Test
    public void rebuild() {
        List<TreeNode<Integer>> preOrder = node(Arrays.asList(4, 2, 1, 3, 6, 5, 8, 7, 9));
        List<TreeNode<Integer>> inOrder = node(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TreeNode<Integer> root = RebuildBinaryTree.rebuild(preOrder, inOrder);
        System.out.println(root);
    }

    private List<TreeNode<Integer>> node(List<Integer> list) {
        return list.stream().map(TreeNode::new).collect(Collectors.toList());
    }

}