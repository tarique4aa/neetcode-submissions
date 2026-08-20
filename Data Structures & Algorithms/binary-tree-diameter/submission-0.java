class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0; // Reset for each test case
        getHeight(root);
        return maxDiameter;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // Longest path through this node = left height + right height
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Height of current node = 1 + max child height
        return 1 + Math.max(leftHeight, rightHeight);
    }
}