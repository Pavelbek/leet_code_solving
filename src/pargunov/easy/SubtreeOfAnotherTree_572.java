package pargunov.easy;

import pargunov.other.TreeNode;

public class SubtreeOfAnotherTree_572 {

    private boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String rootString = preOrderTraversal(root);
        String subRootString = preOrderTraversal(subRoot);
        return rootString.contains(subRootString);
    }

    private String preOrderTraversal(TreeNode root) {
        if(root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder("^");
        sb.append(root.val);
        sb.append(preOrderTraversal(root.left));
        sb.append(preOrderTraversal(root.right));
        return sb.toString();
    }


    // EFFECTIVE SOLUTION O(S * R)
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) {
            return true;
        }
        if(root == null) {
            return false;
        }
        if(isSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if(root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }

}
