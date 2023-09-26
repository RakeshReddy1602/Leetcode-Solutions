class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        getCombinations(0,k,target,arr,new ArrayList<>(),result);
        return result;
    }

    void getCombinations(int index,int k,int target,int[] arr,List<Integer> list,List<List<Integer>> result){

        if(target == 0 && list.size() == k){
            result.add(new ArrayList<>(list));
            return ;
        }
        if(target < 0 || index >= arr.length){
            return ;
        }

        list.add(arr[index]);
        getCombinations(index+1,k,target- arr[index],arr,list,result);
        list.remove(list.size()-1);
        getCombinations(index+1,k,target,arr,list,result);
    }
}