package pargunov.medium;

import java.util.*;

public class Find_All_Possible_Recipes_from_Given_Supplies_2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> res = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        Map<String, Integer> degree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();

        for(int i = 0; i < recipes.length; i++) {
            degree.put(recipes[i], ingredients.get(i).size());
            for(int j = 0; j < ingredients.get(i).size(); j++) {
                if(!graph.containsKey(ingredients.get(i).get(j))) {
                    graph.put(ingredients.get(i).get(j), new ArrayList<String>());
                }
                graph.get(ingredients.get(i).get(j)).add(recipes[i]);
            }
        }

        for(int i = 0; i < supplies.length; i++) {
            queue.add(supplies[i]);
        }

        while(queue.size() > 0) {
            String supply = queue.poll();
            if(!graph.containsKey(supply)) continue;

            for(String recipy : graph.get(supply)) {
                degree.put(recipy, degree.get(recipy) - 1);
                if(degree.get(recipy) == 0) {
                    res.add(recipy);
                    queue.offer(recipy);
                }
            }
        }

        return res;
    }
}
