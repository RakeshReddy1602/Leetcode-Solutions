class Solution {
    public int coinChange(int[] coins, int amount) {
        long[][] dp = new long[amount+1][coins.length];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int req = (int)getMinCoins(0,amount,coins,dp);
        return req < Integer.MAX_VALUE ? req : -1;
    }

    long getMinCoins(int index,int target,int[] arr,long[][] dp){
        if(target == 0){
            return 0;
        }
        if(target < 0 || index >= arr.length ){
            return Integer.MAX_VALUE;
        }
        if(dp[target][index] != -1){
            return dp[target][index];
        }

        long req1 = 1+ getMinCoins(index,target - arr[index],arr,dp);
        long req2 = getMinCoins(index+1,target,arr,dp);
        dp[target][index] =  Math.min(req1,req2);
        return (int)dp[target][index];
    }
}