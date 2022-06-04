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
    int count = 0;
    // public int pathSum(TreeNode root, int targetSum) {
    //     recursion(root, targetSum);
    //     return count;
    // }
    // public void recursion(TreeNode root, int targetSum) {
    //     if (root==null) return;
    //     dfs(root, targetSum);
    //     recursion(root.left, targetSum);
    //     recursion(root.right, targetSum);
    // }
    // public void dfs(TreeNode root, int targetSum) {
    //     if (root==null) return;
    //     targetSum -= root.val;
    //     if (root.left==null && root.right==null) {
    //         if (targetSum==0)
    //             count++;
    //         return;
    //     }
    //     if (targetSum==0)
    //         count++;
    //     dfs(root.left, targetSum);
    //     dfs(root.right, targetSum);
    // }
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        recursion(root, targetSum, 0, map);
        return count;
    }
    public void recursion(TreeNode root, int targetSum, int sum, Map<Integer, Integer> map) {
        if (root==null) return;
        sum += root.val;
        if (map.containsKey(sum-targetSum))
            count += map.get(sum-targetSum);
        if (map.containsKey(sum))
            map.put(sum, map.get(sum)+1);
        else
            map.put(sum, 1);
        recursion(root.left, targetSum, sum, map);
        recursion(root.right, targetSum, sum, map);
        map.put(sum, map.get(sum)-1);
    }
}