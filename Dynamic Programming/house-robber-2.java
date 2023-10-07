class Solution {
    public int rob(int[] nums) {
        if(nums.length <= 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int zeroIndexAmount = robMax(0,nums.length-1,nums,dp);
        Arrays.fill(dp,-1);
        int oneIndexAmount = robMax(1,nums.length,nums,dp);
        return Math.max(zeroIndexAmount, oneIndexAmount);
    }

    int robMax(int index,int end,int[] nums,int[] dp){
        if(index >= end){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int pos1 = nums[index] + robMax(index+2,end,nums,dp);
        int pos2 = robMax(index+1, end, nums,dp);
        dp[index] = Math.max(pos1,pos2);
        return dp[index];
    }
}