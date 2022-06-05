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
    int sum = 0;
    // public int sumNumbers(TreeNode root) {
    //     StringBuffer temp = new StringBuffer();
    //     dfs(root, temp);
    //     return sum;
    // }
    // public void dfs(TreeNode root, StringBuffer temp) {
    //     if (root==null) return;
    //     if (root.left==null && root.right==null) {
    //         temp.append((char)(root.val+'0'));
    //         sum += Integer.parseInt(temp.toString());
    //         temp.deleteCharAt(temp.length()-1);
    //         return;
    //     }
    //     temp.append((char)(root.val+'0'));
    //     dfs(root.left, temp);
    //     dfs(root.right, temp);
    //     temp.deleteCharAt(temp.length()-1);
    // }
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    public void dfs(TreeNode root, int temp) {
        if (root==null) return;
        temp = temp*10 + root.val;
        if (root.left!=null || root.right!=null) {
            dfs(root.left, temp);
            dfs(root.right, temp);
        }
        else
            sum += temp;        
    }
}