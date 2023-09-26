class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b)->(b.safeness-a.safeness));
        Queue<Triplet> queue = new LinkedList<>();
        int[][] dist = new int[grid.size()][grid.get(0).size()];
        int[] dr = {-1,0,0,1};
        int[] dc = {0,1,-1,0};
        for(int i=0;i< dist.length;i++){
            for(int j =0;j<dist[0].length;j++){
                if(grid.get(i).get(j) == 1){
                    queue.add(new Triplet(i,j,0));
                }
                else{
                    dist[i][j] = -1;
                }
            }
        }

        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int safeness = queue.poll().safeness;
            for(int i =0;i<4;i++){
                int cr = row + dr[i];
                int cc = col + dc[i];
                if(isValid(cr,cc,grid) && dist[cr][cc] == -1){
                    dist[cr][cc] = safeness +1;
                    queue.add(new Triplet(cr,cc,safeness+1));
                }
            }
        }
        pq.add(new Triplet(0,0,dist[0][0]));
        boolean[][] visited = new boolean[grid.size()][grid.get(0).size()];
        visited[0][0] = true;
        int maxSafeness = Integer.MAX_VALUE;
        while(!pq.isEmpty()){

            int row = pq.peek().row;
            int col = pq.peek().col;
            int safeness = pq.poll().safeness;
            maxSafeness = Math.min(maxSafeness,safeness);
            if(row == grid.size()-1 && col == grid.get(0).size()-1){
                return maxSafeness;
            }
            // int maxSafeness = 0;\   
            for(int i =0;i<4;i++){
                int cr = row + dr[i];
                int cc = col + dc[i];
                if(isValid(cr,cc,grid) && !visited[cr][cc]){
                    pq.add(new Triplet(cr,cc,dist[cr][cc]));
                    visited[cr][cc] = true;;
                }
            }
        }
        return maxSafeness;

    }

    boolean isValid(int r,int c,List<List<Integer>> grid){
        if(r < 0 || c < 0 || r >= grid.size() || c >= grid.get(0).size()){
            return false;
        }
        return true;
    }
}

class Triplet{
    int row,col,safeness;
    Triplet(int row,int col,int safeness){
        this.row = row;
        this.col = col;
        this.safeness = safeness;
    }
}