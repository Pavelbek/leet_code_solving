package pargunov.easy;

import pargunov.other.TreeNode;

import java.util.LinkedList;

public class MinimumDepthOfBinaryTree_100 {
    private int minDepth(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;

        while(queue.size() > 0) {
            int level = queue.size();
            for(int i = 0; i < level; i++) {
                var current = queue.pop();
                if(current.left == null && current.right == null) {
                    return depth;
                }
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
}
