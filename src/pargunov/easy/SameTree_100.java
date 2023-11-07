package pargunov.easy;

import pargunov.other.TreeNode;

import java.util.LinkedList;

public class SameTree_100 {
    /*
    * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
    * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
    * */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Runtime 0ms Beats 100.00%of users with Java
        // Memory Beats 34.98%of users with Java
        var queue = new LinkedList<TreeNode>();
        queue.add(p);
        queue.add(q);

        while (queue.size() > 0) {
            var f = queue.poll();
            var s = queue.poll();
            if (f == null && s == null) {
                continue;
            }
            if (f == null || s == null || f.val != s.val) {
                return false;
            }

            queue.add(f.left);
            queue.add(s.left);
            queue.add(f.right);
            queue.add(s.right);
        }

        return true;
    }

    // recursive solution
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null || q.val != p.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
