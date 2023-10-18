class Solution {
    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(arrLen,steps);
        int[][] dp = new int[arrLen][steps+1];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return getNumberOfWays(0,steps,arrLen,dp);
    }

    int getNumberOfWays(int currIndex,int steps,int len,int[][] dp){
        int mod = (int)(1e9 +7);
        if(currIndex < 0 || currIndex >= len){
            return 0;
        }
        if(dp[currIndex][steps] != -1){
            return dp[currIndex][steps];
        }
        if(steps == 0){
            return currIndex == 0 ? 1 : 0;
        }
        int count = 0;
        for(int i = -1;i<=1;i++){
            count += getNumberOfWays(currIndex + i,steps-1,len,dp);
            count %= mod;
        }
        return dp[currIndex][steps] = count;
    }
}