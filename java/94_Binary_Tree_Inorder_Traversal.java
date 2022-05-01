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
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> inorder = new ArrayList<>();
    //     return recursion(inorder, root);
    // }
    // public List<Integer> recursion(List<Integer> inorder, TreeNode root) {
    //     if (root != null) {
    //         recursion(inorder, root.left);
    //         inorder.add(root.val);
    //         recursion(inorder, root.right);
    //     }
    //     return inorder;
    // }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode curr = root;
        TreeNode leftsub;
        while (curr!=null) {
            if (curr.left==null) {
                inorder.add(curr.val);
                curr = curr.right;
            }
            else {
                leftsub = curr.left;
                while (leftsub.right!=null)
                    leftsub = leftsub.right;
                leftsub.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return inorder;
    }
}