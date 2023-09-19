class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getComboSum(0,target,arr,new ArrayList<>(),result);
        return result;
    }

    void getComboSum(int index,int target,int[] arr,List<Integer> list,List<List<Integer>> result){
        if(target < 0 || index >= arr.length){
            return ;
        }

        if(target == 0){
            result.add(new ArrayList<>(list));
            return ;
        }

        list.add(arr[index]);
        getComboSum(index,target-arr[index],arr,list,result);
        list.remove(list.size()-1);
        getComboSum(index+1,target,arr,list,result);
    }
}
