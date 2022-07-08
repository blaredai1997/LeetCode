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
    public int countNodes(TreeNode root) {
        // if (root==null) return 0;
        // Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);
        // root = root.left;
        // int node = 0;
        // while (!stack.isEmpty() || root!=null) {
        //     while (root!=null) {
        //         stack.push(root);
        //         root = root.left;
        //     }
        //     root = stack.pop();
        //     node++;
        //     root = root.right;
        // }
        // return node;
        int h = height(root);
        if (h==-1) return 0;
        return height(root.right)==h-1 ? (1<<h)+countNodes(root.right) : (1<<h-1)+countNodes(root.left);
    }
    public int height(TreeNode root) {
        int height = -1;
        while (root!=null) {
            root = root.left;
            height++;
        }
        return height;
    }
}