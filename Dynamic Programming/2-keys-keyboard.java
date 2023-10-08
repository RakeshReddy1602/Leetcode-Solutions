class Solution {
    public int minSteps(int n) {
        int[][] dp = new int[n+1][n+1];
        return getMinSteps(1,0,n,dp);
    }

    int getMinSteps(int sum,int copy,int target,int[][] dp){
        if(sum > target){
            return Integer.MAX_VALUE;
        }

        if(sum == target){
            return 0;
        }
        if(dp[sum][copy] != 0){
            return dp[sum][copy];
        }
        int copyCost = Integer.MAX_VALUE-1000,pasteCost = Integer.MAX_VALUE-1000;
        int newCopy = sum;
        if(newCopy != copy){
            copyCost = getMinSteps(sum,newCopy,target,dp);
        }
        int newSum = copy + sum;
        if(newSum != sum){
            pasteCost = getMinSteps(newSum,copy,target,dp);
        }
        return dp[sum][copy] = 1 + Math.min(copyCost,pasteCost);
    }
}