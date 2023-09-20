class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        getSubset(0,nums,new ArrayList<>(),result);
        return result;
    }

    void getSubset(int index,int[] nums,List<Integer> list,List<List<Integer>> result){
       
        if(index >= nums.length){
            return ;
        }

       list.add(nums[index]);
       result.add(new ArrayList(list));
       getSubset(index+1,nums,list,result);
       list.remove(list.size()-1);
       getSubset(index+1,nums,list,result);

    }
}