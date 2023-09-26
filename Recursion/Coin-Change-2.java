class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i =0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(7278191 > 35502874);
        return getCombo(0,amount,dp,coins);
    }

    int getCombo(int index,int target,int[][] dp,int[] arr){
         if(target < 0 || index >= arr.length){
            return 0;
        }
        if(dp[index][target] != -1){
            return dp[index][target];
        }
        if(target == 0){
            return 1;
        }
       
        int ways = getCombo(index,target-arr[index],dp,arr) + getCombo(index+1,target,dp,arr);
        dp[index][target] = ways;
        return dp[index][target];
    }
    
}