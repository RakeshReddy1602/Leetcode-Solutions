class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        getSubsetCombo(0,nums,new ArrayList<>(),result);
        result.add(new ArrayList<>());
        return result;
    }

    void getSubsetCombo(int index,int[] nums,List<Integer> list,List<List<Integer>> result){
        
        if(index >= nums.length){
            return ;
        }
        for(int i =index;i<nums.length;i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            getSubsetCombo(i+1,nums,list,result);
            list.remove(list.size()-1);
        }
    }
}