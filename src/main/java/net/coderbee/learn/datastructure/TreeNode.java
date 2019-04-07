package net.coderbee.learn.datastructure;

public class TreeNode<T extends Comparable> {
    TreeNode<T> leftTree;
    TreeNode<T> rightTree;
    private T data;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(TreeNode<T> leftTree) {
        this.leftTree = leftTree;
    }

    public TreeNode<T> getRightTree() {
        return rightTree;
    }

    public void setRightTree(TreeNode<T> rightTree) {
        this.rightTree = rightTree;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TreeNode)) {
            return false;
        }

        TreeNode node = (TreeNode) obj;
        return data.equals(node.data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"data\":").append(data);
        if (leftTree != null) {
            sb.append(",\"leftTree\":").append(leftTree);
        }
        if (rightTree != null) {
            sb.append(",\"rightTree\":").append(rightTree);
        }
        sb.append("}");
        return sb.toString();
    }
}
