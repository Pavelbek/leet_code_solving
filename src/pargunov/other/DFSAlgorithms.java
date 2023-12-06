package pargunov.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DFSAlgorithms {

            //      4
            //    /   \
            //   2     5
            //  / \     \
            // 1   3     6

    // iterative dfs
    private List<Integer> iterativePreOrderDfs(TreeNode root) { // res = 4 2 1 3 5 6
         if(root == null) return Collections.emptyList();
         List<Integer> res = new ArrayList<>();
         LinkedList<TreeNode> stack = new LinkedList<>();
         stack.add(root);

         while (stack.size() > 0) {
             var current = stack.pop();
             res.add(current.val);

             if (current.right != null) {
                 stack.push(current.right);
             }
             if (current.left != null) {
                 stack.push(current.left);
             }
         }

         return res;
    }

    private void iterativeInOrderDfs(TreeNode root) { // res = 1 2 3 4 5 6
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        var current = root;

        while (current != null && stack.size() > 0) {
            stack.add(current);
            current = current.left;

            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

    private void iterativePostOrderTraversal(TreeNode root) { // 1 3 2 6 5 4
        if(root == null) {
            return;
        }
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        stack1.add(root);

        while (stack1.size() > 0) {
            var current = stack1.pop();
            stack2.add(current);
            if (current.left != null) {
                stack1.add(current.left);
            }
            if (current.right != null) {
                stack1.add(current.right);
            }
        }

        while (stack2.size() > 0) {
            var current = stack2.pop();
            System.out.print(current.val + " ");
        }
    }
}
