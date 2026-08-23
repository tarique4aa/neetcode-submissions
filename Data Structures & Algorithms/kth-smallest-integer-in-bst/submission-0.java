/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int n,ans;
    public int kthSmallest(TreeNode root, int k) {
        n=0;
        find(root, k);
        return ans;
    }

    public void find(TreeNode root, int k){
        if(root==null) return;
        find(root.left,k);
        n++;
        if(n==k){
            ans=root.val;
            return;
        }
        find(root.right,k);
    }
}
