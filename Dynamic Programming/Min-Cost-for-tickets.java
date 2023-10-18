class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366]; 
        return getMinCost(0,0,days,costs,dp);
    }

    int getMinCost(int start,int index,int[] days,int[] costs,int[] dp){
        if(index >= days.length){
            return 0;
        }
        if(start > days[index]){
            return getMinCost(start, index+1, days, costs,dp);
        }
        if(dp[start] != 0){
            return dp[start];
        }
        int dayPassCost = costs[0] + getMinCost(days[index]+1,index+1, days, costs,dp);
        int weekPassCost = costs[1] + getMinCost(days[index]+7, index, days, costs,dp);
        int monthPassCost = costs[2] + getMinCost(days[index]+30, index, days, costs,dp);
        int minCost = Math.min(weekPassCost, dayPassCost);
        return dp[start] = Math.min(minCost,monthPassCost);
    }
}