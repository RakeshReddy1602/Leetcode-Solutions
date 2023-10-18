class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int freeCells = getFreeCellCount(grid);
        int[] start = getStartCell(grid);
        return getUniquePaths(start[0],start[1],freeCells,grid,new boolean[grid.length][grid[0].length]);
        
    }

    int getUniquePaths(int row,int col,int freeCells,int[][] grid,boolean[][] visited){

        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1 || visited[row][col]){
            return 0;
        }

        if(grid[row][col] == 2){
            return freeCells == 0 ? 1 : 0;
        }
        visited[row][col] = true;
        int[] dx = {0,-1,1,0};
        int[] dy = {1,0,0,-1};
        int ways = 0;
        for(int i =0;i<4;i++){
            int cr = row + dx[i];
            int cc = col + dy[i];
            ways += getUniquePaths(cr,cc,freeCells-1,grid,visited);
        }

        visited[row][col] = false;
        return ways;
    }

    int getFreeCellCount(int[][] grid){
        int freeCells = grid.length * grid[0].length;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == -1){
                    freeCells--;
                }
            }
        }

        return freeCells-1;
    }

    int[] getStartCell(int[][] grid){

        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    return new int[]{i,j};
                }
               
            }
        }
        return new int[]{-1,-1};
    }
}