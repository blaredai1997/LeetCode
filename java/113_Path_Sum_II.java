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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recursion(res, temp, root, targetSum);
        return new ArrayList<>(res);
    }
    public void recursion(List<List<Integer>> res, List<Integer> temp, TreeNode root, int targetSum) {
        if (root==null) return;
        if (root.left==null && root.right==null) {
            if (targetSum-root.val==0) {
                temp.add(root.val);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
            return;
        }
        temp.add(root.val);
        recursion(res, temp, root.left, targetSum-root.val);
        recursion(res, temp, root.right, targetSum-root.val);
        temp.remove(temp.size()-1);
    }
}