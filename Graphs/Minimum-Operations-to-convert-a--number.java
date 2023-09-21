// import java.util.*;
class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int moves = 0;
        queue.add(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            // System.out.println(size+" "+moves);
            for(int i =0;i<size;i++){
                int node = queue.poll();
                if(node == goal){
                    return moves;
                }
                if(node >= 0 && node <= 1000 && !set.contains(node)){
                    set.add(node);
                    for(int k : nums){
                        queue.add(node + k);
                        queue.add( node - k);
                        queue.add(node ^ k);
                                       
                    }
                }
            }
            moves++;

        }
        return -1;
    }
}