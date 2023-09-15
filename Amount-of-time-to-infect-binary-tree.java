class Solution {
    public int amountOfTime(TreeNode root, int start) {
        List<TreeNode> path = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int maxTime = 0;
        getPath(start,path,root);
       int t = 0;
       for(int i =path.size()-1;i>=0;i--){
        queue.add(new Pair(path.get(i),t));
        set.add(path.get(i).val);
        t++;
       }
       while(!queue.isEmpty()){
        TreeNode node = queue.peek().node;
        int time = queue.poll().time;
        maxTime = Math.max(maxTime,time);
        if(node.left != null && (!set.contains(node.left.val))){
            queue.add(new Pair(node.left,time+1));
            set.add(node.left.val);
        }
        if(node.right != null && (!set.contains(node.right.val))){
            queue.add(new Pair(node.right,time+1));
            set.add(node.right.val);
        }
       }
       return maxTime;
    }

    boolean getPath(int target,List<TreeNode> path,TreeNode root){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.val == target){
            return true;
        }
        if(getPath(target,path,root.left) || getPath(target,path,root.right)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}

class Pair{
    TreeNode node;
    int time;
    Pair(TreeNode node,int time){
        this.node = node;
        this.time = time;
    }
}