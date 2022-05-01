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
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> preorder = new ArrayList<>();
    //     return recursion(preorder, root);
    // }
    // public List<Integer> recursion(List<Integer> preorder, TreeNode root) {
    //     if (root!=null) {
    //         preorder.add(root.val);
    //         recursion(preorder, root.left);
    //         recursion(preorder, root.right);
    //     }
    //     return preorder;
    // }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr!=null || !stack.isEmpty()) {
            while (curr!=null) {
                stack.push(curr);
                preorder.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return preorder;
    }
}