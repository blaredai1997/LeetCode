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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // if (root==null) return res;
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.offer(root);
        // while (!queue.isEmpty()) {
        //     int size = queue.size();
        //     int val = 0;
        //     while (size-->0) {
        //         TreeNode node = queue.poll();
        //         val = node.val;
        //         if (node.left!=null) queue.offer(node.left);
        //         if (node.right!=null) queue.offer(node.right);
        //     }
        //     res.add(val);
        // }
        recursion(res, root, 0);
        return res;
    }
    public void recursion(List<Integer> res, TreeNode root, int height) {
        if (root==null) return;
        if (res.size()==height) res.add(root.val);
        recursion(res, root.right, height+1);
        recursion(res, root.left, height+1);
    }
}