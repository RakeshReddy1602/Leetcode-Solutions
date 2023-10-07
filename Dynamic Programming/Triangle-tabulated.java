
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prevPath = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        prevPath.add(triangle.get(0).get(0));
        
        for(int i =1;i<triangle.size();i++){
            for(int j = 0;j<triangle.get(i).size();j++){
                int cost1 = Integer.MAX_VALUE,cost2 = Integer.MAX_VALUE;
                int x = i-1, y = j;
                if(j < prevPath.size()){
                    cost1 = prevPath.get(y);
                }
                y = j-1;
                if(y >= 0){
                     cost2  = prevPath.get(y);
                }
                int minCost = Math.min(cost1, cost2) + triangle.get(i).get(j);
                currPath.add(minCost);
            }
           
            prevPath = currPath;
            currPath = new ArrayList<>();
        }
        int min = Integer.MAX_VALUE;
        for(int i : prevPath){
            min = Math.min(min,i);
        }
        return min;
    }
}