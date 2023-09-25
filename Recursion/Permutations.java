import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getPermutations(new ArrayList<>(),marked,result,nums);
        return result;
    }

    void getPermutations(List<Integer> list,boolean[] marked,List<List<Integer>> result,int[] nums){

        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return ;
        }

        for(int i =0;i<nums.length;i++){
            if(!marked[i]){
                list.add(nums[i]);
                marked[i] = true;
                getPermutations(list, marked, result, nums);
                list.remove(list.size()-1);
                marked[i] = false;
            }
        }
    }

}