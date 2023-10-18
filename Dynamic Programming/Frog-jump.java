class Solution {
    public boolean canCross(int[] stones) {
        int[][] visited = new int[stones.length][stones.length+1];
        for(int i =0;i<visited.length;i++){
            Arrays.fill(visited[i],-1);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<stones.length;i++){
            map.put(stones[i],i);
        }
        return canReachLastStone(1,1,stones,map,visited);
    }

    boolean canReachLastStone(int lastJump,int currStone,int[] stones,HashMap<Integer,Integer> map,int[][] visited){

        if(currStone == stones[stones.length-1]){
            return true;
        }

        if(currStone > stones[stones.length-1]){
            return false;
        }
        if(map.containsKey(currStone)){
            int index = map.get(currStone);
            if(visited[index][lastJump] != -1){
             return false;
            }
            for(int i = -1;i<=1;i++){
                int nextJump = lastJump + i;
                int nextStone = currStone + nextJump;
                if(nextStone != currStone && map.containsKey(nextStone)){
                    if(canReachLastStone(nextJump,nextStone,stones,map,visited)){
                        return true;
                    }
                }  
            }

            visited[index][lastJump] = 0;
        }
       return false;

    }
}