class Solution {
    public List<Integer> eventualSafeNodes(int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[edges.length];
        boolean[] pathVisited = new boolean[edges.length];
        // create adjacency list
        for(int i =0;i<edges.length;i++){
            adj.add(new ArrayList<>());
            for(int j =0;j<edges[i].length;j++){
                adj.get(i).add(edges[i][j]);
            }
        }

        for(int i =0;i<edges.length;i++){
            if(!visited[i]){
                checkCycle(i,pathVisited,visited,adj,result);
            }
        }
        Collections.sort(result);
        return result;
    }

    boolean checkCycle(int node,boolean[] pathVisited,boolean[] visited,List<List<Integer>> adj,List<Integer> result){
        pathVisited[node] = true;
        visited[node] = true;
        for(int i : adj.get(node)){
            if(!visited[i]){
                if(checkCycle(i,pathVisited,visited,adj,result)){
                    return true;
                }
            }
            else if(pathVisited[i]){
                return true;
            }
        }
        pathVisited[node] = false;
        result.add(node);
        return false;
    }
}