class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int cost = calculateEnergy(0,0,0,0,dungeon);
        return cost < 0 ? -(cost -1) : 0;
    }

    int calculateEnergy(int row,int col,int totalEnergy,int energyRequired,int[][] grid){
        if(row >= grid.length || col >= grid[0].length){
            return Integer.MIN_VALUE;
        }

        int newEnergy = totalEnergy\ + grid[row][col];
        energyRequired = Math.min(totalEnergy, newEnergy);
        int rightPath = calculateEnergy(row, col+1, newEnergy, energyRequired, grid);
        int downPath = calculateEnergy(row+1, col, newEnergy, energyRequired, grid);
        return Math.min(rightPath,downPath);
    }
}