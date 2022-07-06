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
    public List<TreeNode> generateTrees(int n) {
        return recursion(1, n);
    }
    public List<TreeNode> recursion(int l, int r) {
        List<TreeNode> res = new ArrayList<>();
        if (l>r) res.add(null);
        for (int i=l; i<=r; i++) {
            List<TreeNode> left = recursion(l, i-1);
            List<TreeNode> right = recursion(i+1, r);
            for (TreeNode n1 : left) {
                 for (TreeNode n2 : right) {
                     TreeNode node = new TreeNode(i);
                     node.left = n1;
                     node.right = n2;
                     res.add(node);
                 }
            }
        }
        return res;
    }
}