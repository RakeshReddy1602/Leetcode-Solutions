
class Solution {
    public int minimumEffortPath(int[][] grid) {
        if(grid.length == 1 && grid[0].length ==1){
            return 0;
        }
        PriorityQueue<Triplet> queue = new PriorityQueue<>((a,b) -> (a.cost-b.cost));
        int[][] dist = new int[grid.length][grid[0].length];
        for(int i =0;i<dist.length;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        int[] dr = {-1,0,0,1};
        int[] dc = {0,1,-1,0};
        queue.add(new Triplet(0,0,0));
        while(!queue.isEmpty()){
            int row = queue.peek().x;
            int col = queue.peek().y;
            int cost = queue.poll().cost;
            if(row == grid.length-1 && col == grid[0].length-1){
                return cost;
            }
            for(int i =0;i<4;i++){
                int cr = row + dr[i];
                int cc = col + dc[i];
                if(isValid(cr,cc,grid)){
                    int newCost = Math.abs(grid[cr][cc] - grid[row][col]);
                    newCost =Math.max(newCost,cost);
                    if(newCost < dist[cr][cc]){
                        queue.add(new Triplet(cr, cc, newCost));
                        dist[cr][cc] = newCost;
                    }
                }
            }
        }
        return 0;
    }


    boolean isValid(int r,int c,int[][] grid){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return false;
        }
        return true;
    }
}

class Triplet{
    int x,y,cost;
    Triplet(int x,int y,int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}