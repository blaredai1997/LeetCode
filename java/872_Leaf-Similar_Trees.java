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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        recursion(root1, l1);
        recursion(root2, l2);
        if (l1.equals(l2)) return true;
        return false;
    }
    public void recursion(TreeNode root, List<Integer> list) {
        if(root==null) return;
        if (root.left==null && root.right==null)
            list.add(root.val);
        recursion(root.left, list);
        recursion(root.right, list);
    }
}