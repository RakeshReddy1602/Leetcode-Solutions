class Solution {
    public int minPathSum(int[][] grid) {
        return getMinSum(grid);
    }
    int getMinSum(int[][] grid){
       int[][] pathCost = new int[grid.length][grid[0].length];
       pathCost[0][0] = grid[0][0];

       for(int i =1;i<grid[0].length;i++){
           pathCost[0][i] = pathCost[0][i-1] + grid[0][i];
       }
       for(int i=1;i<grid.length;i++){
           pathCost[i][0] = pathCost[i-1][0] + grid[i][0];
       }
       
        for(int i =1;i<grid.length;i++){
            for(int j =1;j<grid[0].length;j++){
                int leftPathCost = Integer.MAX_VALUE,topCostPath = Integer.MAX_VALUE;
                if(j > 0){
                    leftPathCost = pathCost[i][j-1];
                }
                if(i > 0){
                    topCostPath = pathCost[i-1][j];
                }
                pathCost[i][j] = grid[i][j] + Math.min(topCostPath,leftPathCost);
            }
           
        }
        return pathCost[grid.length-1][grid[0].length-1];
    }
}