class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        getComboSum(0,target,arr,new ArrayList<>(),result);
        return result;
    }

    void getComboSum(int index,int target,int[] arr,List<Integer> list,List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return ;
        }

        for(int i =index;i<arr.length;i++){
            if(i > index && arr[i] == arr[i-1]){
                continue;
            }
            if(arr[i] > target){
                break;
            }
            list.add(arr[i]);
            getComboSum(i+1,target-arr[i],arr,list,result);
            list.remove(list.size()-1);

        }
    }
}