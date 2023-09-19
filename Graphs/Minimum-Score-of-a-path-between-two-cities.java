class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        int[] vis = new int[n+1];
        Arrays.fill(vis,Integer.MAX_VALUE);
        int minCost = Integer.MAX_VALUE;
        for(int i =0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<roads.length;i++){
            int node1 = roads[i][0];
            int node2 = roads[i][1];
            int cost = roads[i][2];
            adj.get(node1).add(new Pair(node2,cost));
            adj.get(node2).add(new Pair(node1,cost));
        }
        queue.add(new Pair(1,Integer.MAX_VALUE));
        // vis[0] = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int node = queue.peek().node;
            minCost = Math.min(minCost,queue.poll().cost);
            for(Pair p :adj.get(node)){
                if(vis[p.node] > p.cost){
                    vis[p.node] = p.cost;
                    queue.add(new Pair(p.node,p.cost));
                }
            }
        }
        return minCost;
    }
}

class Pair{
    int node,cost;
    Pair(int node,int cost){
        this.node = node;
        this.cost = cost;
    }
}