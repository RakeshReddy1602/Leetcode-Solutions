class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        int res = getMinPathSum(0,-1,grid,dp);
       return res;
    }

    int getMinPathSum(int row,int lastCol,int[][] grid,int[][] dp){
        if(row >= grid.length){
            return 0;
        }
        if(lastCol != -1 && dp[row][lastCol] != Integer.MAX_VALUE){
            return dp[row][lastCol];
        }
        int minSum = Integer.MAX_VALUE;

        for(int i =0;i<grid[0].length;i++){
            if(i != lastCol){
                int currSum = grid[row][i] + getMinPathSum(row+1,i,grid,dp);
                minSum = Math.min(minSum,currSum);
            }
        }
        if(lastCol == -1){
            return minSum;
        }
        return dp[row][lastCol] = minSum;
    }
}