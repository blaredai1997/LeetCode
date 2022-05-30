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
    int res = 0, deepest = 0;
    public int deepestLeavesSum(TreeNode root) {
        recursion(root, 0);
        return res;
    }
    public void recursion(TreeNode curr, int depth) {
        if (curr==null) return;
        if (depth>deepest) {
            deepest = depth;
            res = curr.val;
        }
        else if (depth==deepest)
            res += curr.val;
        recursion(curr.left, depth+1);
        recursion(curr.right, depth+1);
    }
}