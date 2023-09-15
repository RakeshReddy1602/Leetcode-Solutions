class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        long[] min = new long[2];
        min[0] = min[1]  = Long.MAX_VALUE;
        traverse(min,root);
        return min[1] == Long.MAX_VALUE ? -1: (int)min[1];
    }

    void traverse(long[] arr,TreeNode root){
        if(root == null){
            return ;
        }
        if(root.val < arr[0]){
            arr[1] = arr[0];
            arr[0] = root.val;
        }
        else if(root.val > arr[0] && root.val < arr[1]){
            arr[1] = root.val;
        }
        traverse(arr, root.left);
        traverse(arr, root.right);
    }
}