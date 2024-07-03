package pargunov.hard;

import pargunov.other.TreeNode;

public class BinaryTreeMaximumPathSum_124 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        return Math.max(findMaxSum(root), maxSum);
    }

    private int findMaxSum(TreeNode node) {
        if(node == null) return 0;
        int left = Math.max(findMaxSum(node.left), 0);
        int right = Math.max(findMaxSum(node.right), 0);
        maxSum = Math.max(maxSum, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
