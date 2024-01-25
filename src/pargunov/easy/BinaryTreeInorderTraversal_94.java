package pargunov.easy;

import pargunov.other.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        var res = new ArrayList<Integer>();
        traversInOrder(root, res);
        return res;
    }

    private void traversInOrder(TreeNode root, List<Integer> container) {
        if(root == null) return;
        traversInOrder(root.left, container);
        container.add(root.val);
        traversInOrder(root.right, container);
    }

    //iterative approach
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        var current = root;

        while (current != null || stack.size() > 0) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            res.add(current.val);
            current = current.right;
        }
        return res;
    }
}
