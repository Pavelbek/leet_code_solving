package pargunov.easy;

import pargunov.other.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DiameterOfBinaryTree_543 {

    private int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        int diameter  = 0;

        if(root != null) {
            stack.push(root);
        }

        while(stack.size() > 0) {
            var current = stack.peek();

            if(current.left != null && !map.containsKey(current.left)) {
                stack.push(current.left);
            } else if(current.right != null && !map.containsKey(current.right)) {
                stack.push(current.right);
            } else {
                stack.pop();

                int leftDepth = map.getOrDefault(current.left, 0);
                int rightDepth = map.getOrDefault(current.right, 0);

                map.put(current, 1 + Math.max(leftDepth, rightDepth));
                diameter = Math.max(diameter, leftDepth + rightDepth);
            }
        }

        return diameter;
    }

    // FAST recursive solution time O(n) space O(1)
    private int len = 0;
    public int diameterOfBinaryTree2(TreeNode root) {
        dfs(root);
        return len;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        len = Math.max(left + right, len);

        return Math.max(left, right) + 1;
    }
}
