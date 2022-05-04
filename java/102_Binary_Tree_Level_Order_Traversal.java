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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        // Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
        // int level = 0;
        // queue.add(new Pair(1, root));
        // while (!queue.isEmpty()) {
        //     Pair<Integer, TreeNode> pair = queue.poll();
        //     int key = pair.getKey();
        //     TreeNode curr = pair.getValue();
        //     if (curr!=null) {
        //         if (level!=key) {
        //             level = key;
        //             list.add(new ArrayList<>(Arrays.asList(curr.val)));
        //         }
        //         else
        //             list.get(list.size()-1).addAll(Arrays.asList(curr.val));
        //         queue.add(new Pair(level+1, curr.left));
        //         queue.add(new Pair(level+1, curr.right));
        //     }
        // }
        if (root==null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> sub = new ArrayList<>(count);
            for (int i=0; i<count; i++) {
                TreeNode node = queue.poll();
                sub.add(node.val);
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
            list.add(sub);
        }
        return list;
    }
}