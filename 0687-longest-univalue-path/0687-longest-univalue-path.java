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
    private int height(TreeNode node, int[] ans){
        if(node==null){
            return 0;
        }
        int lh = height(node.left,ans);
        int rh = height(node.right,ans);

        int leftPath=0, rightPath=0;
        if (node.left != null && node.left.val == node.val) {
            leftPath = lh + 1;
        }

        if (node.right != null && node.right.val == node.val) {
            rightPath = rh + 1;
        }
        ans[0]=Math.max(ans[0],leftPath+rightPath);

        return Math.max(leftPath,rightPath);
    }
    public int longestUnivaluePath(TreeNode root) {
        int ans[]=new int[1];
        height(root,ans);
        return ans[0];
    }
}