package pargunov.easy;

import pargunov.other.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        addInPostOrder(root, res);
        return res;
    }

    private void addInPostOrder(TreeNode root, List<Integer> container) {
        if(root == null) return;
        addInPostOrder(root.left, container);
        addInPostOrder(root.right, container);
        container.add(root.val);
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        stack1.push(root);
        while(stack1.size() > 0) {
            var current = stack1.pop();
            stack2.push(current);

            if(current.left != null) {
                stack1.push(current.left);
            }

            if(current.right != null) {
                stack1.push(current.right);
            }
        }

        while(stack2.size() > 0) {
            var current = stack2.pop();
            res.add(current.val);
        }

        return res;
    }
}
