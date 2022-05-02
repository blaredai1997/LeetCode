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
    // Apply Inorder Traversal
    // public boolean isValidBST(TreeNode root) {
    //     List<Integer> nodes = new ArrayList<>();
    //     inorder(root, nodes);
    //     for (int i=0; i<nodes.size()-1; i++) {
    //         if (!(nodes.get(i) < nodes.get(i+1)))
    //             return false;
    //     }
    //     return true;
    // }
    // public void inorder(TreeNode root, List<Integer> nodes) {
    //     if (root!=null) {
    //         inorder(root.left, nodes);
    //         nodes.add(root.val);
    //         inorder(root.right, nodes);
    //     }
    // }
    public boolean isValidBST(TreeNode root) {
        return recursion(root, null, null);
    }
    public boolean recursion(TreeNode root, TreeNode left, TreeNode right) {
        if (root==null)
            return true;
        else if (left!=null && !(left.val<root.val))
            return false;
        else if (right!= null && !(right.val>root.val))
            return false;
        else 
            return recursion(root.left, left, root) && recursion(root.right, root, right);
    }
}