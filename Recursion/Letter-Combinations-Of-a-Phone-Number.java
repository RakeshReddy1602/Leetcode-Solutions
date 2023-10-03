import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[] keyboard = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        getCombinations("", digits.length(),keyboard,result);
        return result;
    }

    void getCombinations(String currCombo,int target,String[] keyboard,List<String> result){
        if(currCombo.length() == target){
            result.add(currCombo);
            return ;
        }

        
    }
}