class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0;i<candidates.length;i++){
            getComboSum(i,0,target,candidates,new ArrayList<>(),result);
        }
        return result;
    }

    void getComboSum(int start,int currSum,int target,int[] arr,ArrayList<Integer> list,List<List<Integer>> result){
        int total = currSum + arr[start];
        if(total == target){
            list.add(arr[start]);
            result.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return ;
        }
        if(total > target){
            return ;
        }
        list.add(arr[start]);
        for(int i = start;i<arr.length;i++){
            getComboSum(i,total,target,arr,list,result);
        }
        list.remove(list.size()-1);
    }
}