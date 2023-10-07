class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for(int i =0;i<triangle.size();i++){
            dp.add( new ArrayList<>(triangle.get(i).size()));
            for(int j =0;j<triangle.get(i).size();j++){
                dp.get(i).add(Integer.MAX_VALUE);
            }
        }
        return getMinCostPath(0,0,triangle,dp);
    }

    int getMinCostPath(int row,int col,List<List<Integer>> list,List<List<Integer>> dp){
        if(row >= list.size()){
            return 0;
        }

        if(col >= list.get(row).size()){
            return Integer.MAX_VALUE;
        }

        if(dp.get(row).get(col) != Integer.MAX_VALUE){
            return dp.get(row).get(col);
        }
        int sameIndexCost = getMinCostPath(row+1, col, list,dp);
        int nextIndexCost = getMinCostPath(row+1, col+1, list,dp);
        int cost = list.get(row).get(col) + Math.min(sameIndexCost,nextIndexCost);
        dp.get(row).set(col,cost);
        return dp.get(row).get(col);
    }
}