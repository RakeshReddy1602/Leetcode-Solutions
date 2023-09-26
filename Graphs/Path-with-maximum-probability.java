
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        double[] probability = new double[n];
        PriorityQueue<Pair> queue = new PriorityQueue<>((b,a)->Double.compare(a.probability,b.probability));
        Arrays.fill(probability,0.00000);
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<edges.length;i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            double prob = succProb[i];
            adj.get(node1).add(new Pair(node2,prob));
            adj.get(node2).add(new Pair(node1,prob));
        }
        for(Pair nei : adj.get(start)){
            int node = nei.node;
            double prob = nei.probability;
            queue.add(new Pair(node,prob));
            probability[node] = prob;
        }

        while(!queue.isEmpty()){
            int node = queue.peek().node;
            double prob = queue.poll().probability;
            for(Pair nei : adj.get(node)){
                int adjNode = nei.node;
                double newProbability = prob*(nei.probability);
                if(newProbability > probability[adjNode]){
                    probability[adjNode] = newProbability;
                    queue.add(new Pair(adjNode,newProbability));
                }
            }
        }
        return probability[end];

    }
}

class Pair{
    int node;
    double probability;
    Pair(int node,double probability){
        this.node = node;
        this.probability =probability;
    }
}