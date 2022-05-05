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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root==null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> sub = new ArrayList<>();
            for (int i=0; i<count; i++) {
                TreeNode curr = queue.poll();
                sub.add(curr.val);
                if (curr.left!=null)
                    queue.add(curr.left);
                if (curr.right!=null)
                    queue.add(curr.right);
            }
            list.add(0, sub);
        }
        return list;
    }
}