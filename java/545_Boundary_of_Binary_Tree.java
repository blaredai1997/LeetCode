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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (!isLeaf(root)) res.add(root.val);
        TreeNode node = root.left;
        while (node!=null) {
            if (!isLeaf(node)) res.add(node.val);
            if (node.left!=null) node = node.left;
            else node = node.right;
        }
        addLeaves(res, root);
        Stack<Integer> stack = new Stack<>();
        node = root.right;
        while (node!=null) {
            if (!isLeaf(node)) stack.push(node.val);
            if (node.right!=null) node = node.right;
            else node = node.left;
        }
        while (!stack.isEmpty())
            res.add(stack.pop());
        return res;
    }
    private void addLeaves(List<Integer> res, TreeNode node) {
        if (isLeaf(node)) res.add(node.val);
        else {
            if (node.left!=null) addLeaves(res, node.left);
            if (node.right!=null) addLeaves(res, node.right);    
        }
    }
    private boolean isLeaf(TreeNode node) {
        return node.left==null && node.right==null;
    }
}