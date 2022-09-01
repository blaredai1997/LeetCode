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
    int count = 0;
    public int goodNodes(TreeNode root) {
        findGoodNodes(root, root.val);
        return count;
    }
    private void findGoodNodes(TreeNode root, int max) {
        if (root==null) return;
        if (root.val>=max) {
            count++;
            max = root.val;
        }
        if (root.left!=null) findGoodNodes(root.left, max);
        if (root.right!=null) findGoodNodes(root.right, max);
    }
}