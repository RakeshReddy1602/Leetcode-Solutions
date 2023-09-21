class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];
        int[] indegree = new int[n];
        int src = 0;
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =-0;i<leftChild.length;i++){
         
            if(leftChild[i] != -1){
                adj.get(i).add(leftChild[i]);
                indegree[leftChild[i]]++;
            }

            if(rightChild[i] != -1){
                adj.get(i).add(rightChild[i]);
                indegree[rightChild[i]]++;

            }
        }
        for(int i =0;i<n;i++){
            if(indegree[i] == 0){
                src = i;
                break;
            }
        }
        if(traverseTree(src,vis,adj)){
            for(boolean b : vis){
                if(!b){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    boolean traverseTree(int node,boolean[] vis,List<List<Integer>> adj){
        
        if(vis[node]){
            return false;
        }

        vis[node] = true;
        for(int nei : adj.get(node)){

            if(!traverseTree(nei,vis,adj)){
                return false;
            }
        }

        return true;


    }
} 