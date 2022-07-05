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
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        // TreeNode root = new TreeNode(preorder[0]);
        // Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);
        // for (int i=1; i<preorder.length; i++) {
        //     TreeNode node = new TreeNode(preorder[i]);
        //     if (preorder[i]<stack.peek().val)
        //         stack.peek().left = node;
        //     else {
        //         TreeNode parent = stack.peek();
        //         while (!stack.isEmpty() && stack.peek().val<preorder[i])
        //             parent = stack.pop();
        //         parent.right = node;
        //     }
        //     stack.push(node);
        // }
        // return root;
        return recursion(preorder, Integer.MAX_VALUE);
    }
    public TreeNode recursion(int[] preorder, int bound) {
        if (i==preorder.length || preorder[i]>bound) return null;
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = recursion(preorder, root.val);
        root.right = recursion(preorder, bound);
        return root;
    }
}