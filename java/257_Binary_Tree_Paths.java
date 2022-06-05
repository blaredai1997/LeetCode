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
    // public List<String> binaryTreePaths(TreeNode root) {
    //     List<String> res = new LinkedList<>();
    //     dfs(root, res, "");
    //     return res;
    // }
    // public void dfs(TreeNode root, List<String> res, String temp) {
    //     if (root==null) return;
    //     if (root.left!=null || root.right!=null) {
    //         dfs(root.left, res, temp+root.val+"->");
    //         dfs(root.right, res, temp+root.val+"->");
    //     }
    //     else 
    //         res.add(temp+root.val);
    // }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuffer temp = new StringBuffer();
        dfs(root, res, temp);
        return res;
    }
    public void dfs(TreeNode root, List<String> res, StringBuffer temp) {
        if (root==null) return;
        // keep track the length before append new val
        int len = temp.length();
        temp.append(root.val);
        if (root.left!=null || root.right!=null) {
            temp.append("->");
            dfs(root.left, res, temp);
            dfs(root.right, res, temp);
        }
        else 
            res.add(temp.toString());
        // back track with the len
        temp.setLength(len);
    }
}