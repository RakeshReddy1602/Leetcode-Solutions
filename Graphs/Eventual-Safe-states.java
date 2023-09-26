import java.awt.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        // create adjacency list
        for(int i =0;i<edges.length;i++){
            adj.add(new ArrayList<>());
            for(int j =0;j<edges[i].length;j++){
                adj.get(i).add(edges[i][j]);
            }
        }

        for(int i =0;i<n;i++){
            if(!visited[i]){
                checkCycle(i,new boolean[graph.length],visited,adj,result);
            }
        }

        return result;
    }

    boolean checkCycle(int node,boolean[] pathVisited,boolean[] visited,List<List<Integer>> adj,List<Integer> result){
        if(!pathVisited[node]){
            return true;
        }

        pathVisited[node] = true;
        visited[node] = true;
        
    }
}