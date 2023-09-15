import java.util.List;

class Solution {
    public int amountOfTime(TreeNode root, int start) {
        List<TreeNode> path = new ArrayList<>();
        getPath(target,path,root);
    }

    boolean getPath(int target,List<Integer> path,TreeNode root){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.val == target){
            return true;
        }
        if(getPath(target,path,root.left) || getPath(target,apth,root.right)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}