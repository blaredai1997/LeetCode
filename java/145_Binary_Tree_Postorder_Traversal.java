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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        return recursion(postorder, root);
    }
    public List<Integer> recursion(List<Integer> postorder, TreeNode root) {
        if (root!=null) {
            recursion(postorder, root.left);
            recursion(postorder, root.right);
            postorder.add(root.val);
        }
        return postorder;
    }
}