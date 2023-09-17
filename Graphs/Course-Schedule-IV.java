
class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>(); // node value -> level 
        List<Boolean> result = new ArrayList<>();
       
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<pre.length;i++){
            int src = pre[i][0];
            int des = pre[i][1];
            adj.get(src).add(des);
        }
        for(int i =0;i<n;i++){
            boolean[] vis = new boolean[n];
            // vis[i] = true;
            HashSet<Integer> set = new HashSet<>();
            getDependancyList(i,set,vis,adj);
            map.put(i,set);
        }
    //    (n,map,adj);
        for(int i =0;i<queries.length;i++){
            int prec = queries[i][0];
            int curr = queries[i][1];
            result.add(map.get(prec).contains(curr));
        }
        return result;
    }

    void getDependancyList(int src,HashSet<Integer> set,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        if(vis[src]){
            return ;
        }
        vis[src] = true;
        set.add(src);
        for(int i : adj.get(src)){
            getDependancyList(i,set,vis,adj);
        }

    }
}