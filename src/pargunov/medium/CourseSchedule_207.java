package pargunov.medium;

import java.util.*;

public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            graph.get(pre[0]).add(pre[1]);
        }

        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < numCourses; i++){
            if(!helper(graph, visited, i)) return false;
        }

        return true;
    }

    private boolean helper(Map<Integer, List<Integer>> graph, Set<Integer> visited, int current){
        if(visited.contains(current)) return false;
        if(graph.get(current).isEmpty()) return true;

        visited.add(current);

        for(int next : graph.get(current)){
            if(!helper(graph, visited, next)) return false;
        }

        visited.remove(current);
        graph.put(current, new ArrayList<>());
        return true;
    }
}
