import java.util.*;
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<Pair> queue = new LinkedList<>();
        int steps = 0;
        HashSet<Integer> visited  = new HashSet<>();
        for(int i : forbidden){
            visited.add(forbidden);
        }
        visited.add(0);
        queue.add(new Pair(0,true));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                int node = queue.peek().node;
                if(node == x)[
                    return moves;
                ]
                boolean canGoBack = queue.poll().move;
                int pos1 = node + a;
                int pos2 = node - b;
                if(!visited.contains(pos1)){
                    queue.add(new Pair(pos1,true));
                    visited.add(pos1);
                }
                if(canGoBack && !visited.contains(pos2)){
                    queue.add(new Pair(pos2,false));
                    set.add(pos2);
                }
            }
            moves++;
        }
        returnb -1;
    }
}