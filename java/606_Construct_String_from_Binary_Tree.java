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
    // String res = "";
    // public String tree2str(TreeNode root) {
    //     helper(root);
    //     return res.substring(1, res.length()-1);
    // }
    // private void helper(TreeNode root) {
    //     if (root==null) return;
    //     res += "(";
    //     res += root.val;
    //     if (root.left!=null) helper(root.left);
    //     else res += "()";
    //     if (root.right!=null) helper(root.right);
    //     else {
    //         if (root.left==null) res = res.substring(0, res.length()-2);
    //     }
    //     res += ")";
    // }
    public String tree2str(TreeNode root) {
        if (root==null) return "";
        if (root.left==null && root.right==null)
            return root.val+"";
        if (root.right==null)
            return root.val+"("+tree2str(root.left)+")";
        return root.val+"("+tree2str(root.left)+")"+"("+tree2str(root.right)+")";
    }
}