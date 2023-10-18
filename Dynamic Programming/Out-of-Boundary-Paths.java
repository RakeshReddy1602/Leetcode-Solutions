class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove+1];
        for(int i =0;i<dp.length;i++){
            for(int j =0;j<dp[i].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return getPathCount(startRow,startColumn,m,n,maxMove,dp);
    }

    int getPathCount(int row,int col,int m,int n,int movesLeft,int[][][] dp){
        if(outOfBoundary(row,col,m,n)){
            return 1;
        }
        if(dp[row][col][movesLeft] != -1){
            return dp[row][col][movesLeft];
        }
        if(movesLeft == 0){
            return 0;
        }
        int count = 0,mod = (int)(1e9+7);
        int[] dx = {-1,0,0,1};
        int[] dy = {0,1,-1,0};
        for(int i =0;i<4;i++){
            int cr= row + dx[i];
            int cc = col + dy[i];
            count = (count + getPathCount(cr,cc,m,n,movesLeft-1,dp))%mod;
        }
        return dp[row][col][movesLeft] = count;
    }

    boolean outOfBoundary(int row,int col,int m,int n){
        if(row < 0 || col < 0 || row >= m || col >= n){
            return true;
        }
        return false;
    }
}