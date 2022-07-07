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
    // public int kthSmallest(TreeNode root, int k) {
    //     List<Integer> res = new ArrayList<>();
    //     recursion(root, res);
    //     return res.get(k-1);
    // }
    // public void recursion(TreeNode root, List<Integer> res) {
    //     if (root==null) return;
    //     recursion(root.left, res);
    //     res.add(root.val);
    //     recursion(root.right, res);
    // }
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k==0) return root.val;
            root = root.right;
        }
    }
}