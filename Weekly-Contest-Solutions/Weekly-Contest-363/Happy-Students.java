class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int count = 0;
        if(nums.get(0) > 0){
            count++;
        }
        for(int i =0;i<nums.size();i++){
            if(nums.get(i) < i+1 && i+1 < nums.size() && nums.get(i+1)> i+1){
                count++;
            }
        }
        int index = nums.size()-1;
        if(nums.get(index) < index+1){
            count++;
        }
        return count;
    }
}