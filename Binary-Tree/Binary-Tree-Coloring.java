public class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode[] target = new TreeNode[1];
        getNode(x,target,root);
        int leftCount = getCount(target[0].left);
        int rightCount = getCount(target[0].right);
        int rem = n- leftCount - rightCount- 1;
        if((leftCount > rightCount + rem) || (rightCount > leftCount + rem) || (rem > leftCount + rightCount)){
            return true;
        }
        return false;
    }

    void getNode(int x,TreeNode[] arr,TreeNode root){
        if(root == null){
            return ;
        }
        if(root.val == x){
            arr[0] = root;
            return ;
        }
        getNode(x,arr,root.left);
        getNode(x,arr,root.right);
    }

    int getCount(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + getCount(root.left) + getCount(root.right);
    }

} 
