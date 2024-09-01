package pargunov.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clone_Graph_133 {
    // helped: https://youtu.be/mQeF6bN8hMk?si=0OTLhB39-NTyDjzU
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Map<Node, Node> oldToNew = new HashMap<>();
        return copy(oldToNew, node);
    }

    private Node copy(Map<Node, Node> map, Node node) {
        if(map.containsKey(node)) return map.get(node);

        var copy = new Node(node.val);
        map.put(node, copy);

        for(Node n : node.neighbors) {
            copy.neighbors.add(copy(map, n));
        }

        return copy;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
