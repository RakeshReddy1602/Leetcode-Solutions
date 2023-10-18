class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return getLongestSequence(Integer.MIN_VALUE,-1,0,nums,dp);
    }

    int getLongestSequence(int prevValue,int prevIndex,int index,int[] nums,int[][] dp){
        if(index >= nums.length){
            return 0;
        }
        if(prevIndex != -1 && dp[index][prevIndex] != -1){
            return dp[index][prevIndex];
        }
        int pickCount = 0,notPickCount = 0;
        if(nums[index] > prevValue){
            pickCount = 1 + getLongestSequence(nums[index],index,index+1,nums,dp);
        }
        notPickCount = getLongestSequence(prevValue,prevIndex,index + 1,nums,dp);
        if(prevIndex == -1){
            return  Math.max(pickCount,notPickCount);
        }
        return dp[index][prevIndex] = Math.max(pickCount,notPickCount);
    }
}

/*
 int getLongestSequence(int prevValue,int index,int[] nums){
        if(index >= nums.length){
            return 0;
        }
        int pickCount = 0,notPickCount = 0;
        if(nums[index] > prevValue){
            pickCount = 1 + getLongestSequence(nums[index],index+1,nums);
        }
        notPickCount = getLongestSequence(prevValue,index + 1,nums);
        return Math.max(pickCount,notPickCount);
    }
     */