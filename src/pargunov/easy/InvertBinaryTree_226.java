package pargunov.easy;

import pargunov.other.TreeNode;

import java.util.LinkedList;

public class InvertBinaryTree_226 {
    private TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        var left = invertTree(root.left);
        var right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    // level order traversal technique
    private TreeNode invertTree2(TreeNode root) {
        if(root == null) {
            return null;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size() > 0) {
            var current = queue.poll();

            var left = current.left;
            current.left = current.right;
            current.right= left;

            if(current.left != null) {
                queue.add(current.left);
            }

            if(current.right != null) {
                queue.add(current.right);
            }
        }
        return root;
    }
}
