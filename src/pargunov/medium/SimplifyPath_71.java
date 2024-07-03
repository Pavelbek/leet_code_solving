package pargunov.medium;

import java.util.LinkedList;

public class SimplifyPath_71 {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        queue.offerFirst("a");
        queue.offerFirst("b");
        System.out.println(queue);
        queue.pollLast();
        System.out.println(queue);
    }

    public String simplifyPath(String path) {
        LinkedList<String> queue = new LinkedList<>();
        String[] tokens = path.split("/");

        for(String token : tokens) {
            if(token.equals("..")) {
                if(queue.size() > 0) queue.pollLast();
            } else {
                if(!token.isEmpty() && !token.equals(".")) {
                    queue.offerLast(token);
                }
            }
        }

        if(queue.size() == 0) return "/";

        StringBuilder simplifiedPath = new StringBuilder();

        while(queue.size() > 0) {
            simplifiedPath.append("/").append(queue.pollFirst());
        }

        return simplifiedPath.toString();
    }
}
