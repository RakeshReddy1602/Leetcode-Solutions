import java.util.*;
class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int moves = 0;
        queue.add(start);
        set.add(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                int node = queue.poll();
                if(node == goal){
                    return moves;
                }
                if(node >= 0 && node <= 1000){
                    for(int k : nums){
                        int val1 = node + nums[i];
                        int val2 = node - nums[i];
                        int val3 = node ^ nums[i];

                        if(!set.contains(val1)){
                            queue.add(val1);
                            set.add(val1);
                        }
                        if(!set.contains(val2)){
                            queue.add(val12);
                            set,add(val2);
                        }
                        if(!set.contains(val3)){
                            queue.add(val3);
                            set.add(val3);

                        }                    
                    }
                }
            }
            moves++;

        }
        return -1;
    }
}