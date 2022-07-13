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
    int[] res;
    int curr;
    int count = 0;
    int max = 0;
    int mode = 0;
    public int[] findMode(TreeNode root) {
        recursion(root);
        res = new int[mode];
        mode = 0;
        count = 0;
        recursion(root);
        return res;
    }
    public void recursion(TreeNode root) {
        if (root==null) return;
        recursion(root.left);
        helper(root.val);
        recursion(root.right);
    }
    public void helper(int val) {
        if (curr!=val) {
            curr = val;
            count = 0;
        }
        count++;
        if (count>max) {
            max = count;
            mode = 1;
        }
        else if (count==max) {
            if (res!=null) res[mode] = curr;
            mode++;
        }
    }
}