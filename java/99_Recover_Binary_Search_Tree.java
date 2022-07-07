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
    TreeNode parent = null, node1 = null, node2 = null;
    public void recoverTree(TreeNode root) {
        recursion(root);
        exchange(node1, node2);
    }
    public void recursion(TreeNode root) {
        // inorder check
        if (root==null) return;
        recursion(root.left);
        if (parent!=null && root.val<parent.val) {
            if (node1==null) node1 = parent;
            node2 = root;
        }
        parent = root;
        recursion(root.right);
    }
    public void exchange(TreeNode node1, TreeNode node2) {
        int value = node1.val;
        node1.val = node2.val;
        node2.val = value;
    }
}