class Solution {
    public int checkRecord(int n) {
        int[][][] dp = new int[n+1][2][3];
        for(int i=0;i<dp.length;i++){
            for(int j =0;j<dp[i].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
         return getRewardCount(-1,0,0,n,dp);   
    }

    int getRewardCount(int lastRecord,int absentCount,int lateCount,int n,int[][][] dp){
        if(absentCount >= 2 || lateCount >= 3){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(lastRecord != -1 && dp[n][absentCount][lateCount] != -1){
            return dp[n][absentCount][lateCount];
        }
        int count = 0,mod = (int)(1e9 + 7);
        count = (count + getRewardCount(0,absentCount,0,n-1,dp))%mod;
        count = (count + getRewardCount(1,absentCount + 1,0,n-1,dp))%mod;
        if(lastRecord == 2){
            count = (count + getRewardCount(2,absentCount,lateCount + 1,n-1,dp))%mod;
        }
        else{
            count = (count + getRewardCount(2,absentCount,1,n-1,dp))%mod;
        }
        if(lastRecord == -1){
            return count;
        }
        return dp[n][absentCount][lateCount] = count;
    }
}