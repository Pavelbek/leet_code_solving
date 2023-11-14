package pargunov.easy;

import pargunov.other.TreeNode;

public class MaximumDepthOfBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
