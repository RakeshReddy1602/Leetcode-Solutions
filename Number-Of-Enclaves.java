class Solution {
    public int numEnclaves(int[][] grid) {
        for(int i =0;i<grid[0].length;i++){
            if(grid[0][i] == 1){
                clearLandCells(0,i,grid);
            }
        }
        for(int i=0;i<grid[0].length;i++){
            if(grid[grid.length-1][i] == 1){
                clearLandCells(grid.length-1,i,grid);
            }
        }
        for(int i =0;i<grid.length;i++){
            if(grid[i][0] == 1){
                clearLandCells(i,0,grid);
            }
        }
        for(int i=0;i<grid.length;i++){
            if(grid[i][grid[0].length-1] == 1){
                clearLandCells(i,grid[0].length-1,grid);
            }
        }
        int encalves = 0;
        for(int i =1;i<grid.length-1;i++){
            for(int j =1;j<grid[0].length-1;j++){
                if(grid[i][j] == 1){
                    encalves++;
                }
            }
        }
        return encalves;
    }

    void clearLandCells(int r,int c,int[][] grid){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return ;
        }
        grid[r][c] = 0;
        clearLandCells(r-1,c,grid);
        clearLandCells(r+1,c,grid);
        clearLandCells(r,c-1,grid);
        clearLandCells(r,c+1,grid);
    }
}