package pargunov.easy;

import pargunov.other.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AverageOfLevelsInBinaryTree_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        List<Double> res = new ArrayList<>();
        queue.add(root);

        while(queue.size() > 0) {
            double sum = 0;
            int level = queue.size();

            for(int i = 0; i < level; i++) {
                var currentNode = queue.pop();
                sum += currentNode.val;

                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            res.add(sum / level);
        }

        return res;
    }
}
