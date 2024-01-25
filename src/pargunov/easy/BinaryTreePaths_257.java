package pargunov.easy;

import pargunov.other.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
    private List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        buildPaths(root, sb, result);
        return result;
    }

    private void buildPaths(TreeNode node, StringBuilder sb, List<String> collection) {
        if(node == null) return;
        int levelLength = sb.length();

        if(levelLength > 0) {
            sb.append("->");
        }

        sb.append(node.val);

        if(node.left == null && node.right == null) {
            collection.add(sb.toString());
        } else {
            buildPaths(node.left, sb, collection);
            buildPaths(node.right, sb, collection);
        }
        sb.setLength(levelLength);
    }}
