package pargunov.easy;

import pargunov.other.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        addInPreOrder(root, res);
        return res;
    }

    private void addInPreOrder(TreeNode root, List<Integer> container) {
        if(root == null) return;
        container.add(root.val);
        addInPreOrder(root.left, container);
        addInPreOrder(root.right, container);
    }

    public List<Integer> preorderTraversalIteratrive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        var current = root;

        while (current != null || stack.size() > 0) {
            while(current != null) {
                stack.push(current);
                res.add(current.val);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }

        return res;
    }
}
