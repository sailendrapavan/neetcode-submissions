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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root,p,q);
    }

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        TreeNode left = lca(root.left,p,q);
        TreeNode right = lca(root.right,p,q);
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        if(left !=null && right !=null){
            return root;
        }
        return left!=null ? left:right;
    }
}
