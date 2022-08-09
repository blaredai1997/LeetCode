/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        findTarget(root, target);
        dfs(root, target, k, map.get(root), res);
        return res;
    }
    private int findTarget(TreeNode root, TreeNode target) {
        if (root==null) return -1;
        if (root==target) {
            map.put(root, 0);
            return 0;
        }
        int left = findTarget(root.left, target);
        int right = findTarget(root.right, target);
        if (left>=0) {
            map.put(root, left+1);
            return left+1;
        }
        if (right>=0) {
            map.put(root, right+1);
            return right+1;
        }
        return -1;
    }
    private void dfs(TreeNode root, TreeNode target, int k, int len, List<Integer> res) {
        if (root==null) return;
        if (map.containsKey(root)) len = map.get(root);
        if (len==k) res.add(root.val);
        dfs(root.left, target, k, len+1, res);
        dfs(root.right, target, k, len+1, res);
    }
}