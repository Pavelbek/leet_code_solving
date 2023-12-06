package pargunov.easy;

import pargunov.other.TreeNode;

import java.util.LinkedList;

public class MaximumDepthOfBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    // iterative more slow solution
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while(queue.size() > 0) {
            int level = queue.size();
            for(int i = 0; i < level; i++) {
                var current = queue.poll();
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            depth++;
        }

        return depth;
    }

    private int maxDepth3(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
