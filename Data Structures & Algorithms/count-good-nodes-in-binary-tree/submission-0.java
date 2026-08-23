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
    int ans;
    public int goodNodes(TreeNode root) {
       ans=0;
       count(root, -101);
       return ans; 
    }
    public void count(TreeNode root, int parMax){
        if(root==null) return;
        if(root.val>=parMax){
            ans++;
        }
        count(root.left, Math.max(parMax, root.val));
        count(root.right, Math.max(parMax, root.val));
    }
}
