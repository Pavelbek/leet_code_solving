package pargunov.easy;

import pargunov.other.TreeNode;

import java.util.LinkedList;

public class PathSum_112 {

    // BFS
    private boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        LinkedList<TreeNode> pathStack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();
        pathStack.add(root);
        sumStack.add(root.val);

        while(pathStack.size() > 0) {
            var currentNode = pathStack.pop();
            var currentSum = sumStack.pop();

            if(currentNode.left == null && currentNode.right == null && currentSum == targetSum) {
                return true;
            }

            if(currentNode.left != null) {
                pathStack.add(currentNode.left);
                sumStack.add(currentNode.left.val + currentSum);
            }

            if(currentNode.right != null) {
                pathStack.add(currentNode.right);
                sumStack.add(currentNode.right.val + currentSum);
            }
        }

        return false;
    }

   // DFS
    private boolean hasPathSum2(TreeNode root, int targetSum) {
        if(root == null) return false;

        targetSum -= root.val;

        if(root.left == null && root.right == null) {
            return targetSum == 0;
        }

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

}
