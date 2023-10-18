class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int[][] dp = new int[nums.length][20001];
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 == 1){
            return false;
        }
        return canMakePartition(nums.length-1,0,sum,nums,dp);
    }

    boolean canMakePartition(int index,int currSum,int targetSum,int[] nums,int[][] dp){
        if(currSum == targetSum){
            return true;
        }

        if(index < 0){
            return false;
        }

        if(dp[index][currSum] != 0){
            return false;
        }
        boolean pickResult = canMakePartition(index-1,currSum+nums[index],targetSum - nums[index],nums,dp);
         boolean notPickResult = canMakePartition(index-1,currSum,targetSum,nums,dp);
        dp[index][currSum] = (pickResult || notPickResult) ?  2 : 1;
        return dp[index][currSum] == 2;
    }
}