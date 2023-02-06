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
    public boolean evaluateTree(TreeNode root) {
        int val = root.val;
        if (root.left != null && root.right != null) {
            int left_val = root.left.val;
            int right_val = root.right.val;
            boolean left = left_val == 0 ? false : left_val == 1 ? true : evaluateTree(root.left);
            boolean right = right_val == 0 ? false : right_val == 1 ? true : evaluateTree(root.right);
            return val == 2 ? left || right : left && right;
        }
        return val == 0 ? false : true;
    }
}