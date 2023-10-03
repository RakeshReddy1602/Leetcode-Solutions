class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        String[] keyboard = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        getCombinations(0,"", digits,keyboard,result);
        return result;
    }

    void getCombinations(int index,String path,String digits,String[] keyboard,List<String> result){
        if(path.length() == digits.length()){
            result.add(path);
            return ; 
        }
        String currString = keyboard[digits.charAt(index) -'0'];
        for(int i =0;i<currString.length();i++){
            getCombinations(index+1, path + currString.charAt(i), digits, keyboard, result);  
        }
    }
}