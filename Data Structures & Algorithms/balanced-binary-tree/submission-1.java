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
    boolean ans;
    public boolean isBalanced(TreeNode root) {
        ans = true;
        bal(root);
        return ans;
    }

    int bal(TreeNode root){
        if(root==null) return 0;

        int l = bal(root.left);
        int r = bal(root.right);

        ans = ans && (Math.abs(l - r)<=1);

        return 1 + Math.max(l,r);
    }
}
