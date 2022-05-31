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
    boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        recursion(root);
        return isBalanced;
    }
    public int recursion(TreeNode curr) {
        if (curr==null || !isBalanced) return 0;
        int left = recursion(curr.left);
        int right = recursion(curr.right);
        if (Math.abs(left-right)>1) {
            isBalanced = false;
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}