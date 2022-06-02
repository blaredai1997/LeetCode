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
    // public TreeNode pruneTree(TreeNode root) {
    //     TreeNode res = root;
    //     recursion(root);
    //     if (root.val!=1 && root.left==null && root.right==null) return null;
    //     return res;
    // }
    // public void recursion(TreeNode root) {
    //     if (root==null) return;
    //     recursion(root.left);
    //     recursion(root.right);
    //     if (root.left!=null && root.left.val!=1) {
    //         if (root.left.left==null && root.left.right==null)
    //             root.left = null;
    //     }
    //     if (root.right!=null && root.right.val!=1) {
    //         if (root.right.left==null && root.right.right==null)
    //             root.right = null;
    //     }
    // }
    public TreeNode pruneTree(TreeNode root) {
        if (root==null) return root;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return (root.val==1 |814. Binary Tree Pruning| root.left!=null || root.right!=null) ? root : null;
    }
}