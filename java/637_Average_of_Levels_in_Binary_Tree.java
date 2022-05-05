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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root==null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            double sum = 0;
            for (int i=0; i<count; i++) {
                TreeNode curr = queue.poll();
                sum += (double)curr.val;
                if (curr.left!=null)
                    queue.add(curr.left);
                if (curr.right!=null)
                    queue.add(curr.right);
            }
            list.add(sum/count);
        }
        return list;
    }
}