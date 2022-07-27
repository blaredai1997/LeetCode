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
    public void flatten(TreeNode root) {
        // helper(root);  
        if (root==null) return;
        TreeNode node = root;
        while (node!=null) {
            if (node.left!=null) {
                TreeNode right = node.left;
                while(right.right!=null) right = right.right;
                right.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
    // private TreeNode helper(TreeNode node) {
    //     if (node==null) return null;
    //     if (node.left==null && node.right==null) return node;
    //     TreeNode left = helper(node.left);
    //     TreeNode right = helper(node.right);
    //     if (left!=null) {
    //         left.right = node.right;
    //         node.right = node.left;
    //         node.left = null;
    //     }
    //     if (right==null) return left;
    //     return right;
    // }
}