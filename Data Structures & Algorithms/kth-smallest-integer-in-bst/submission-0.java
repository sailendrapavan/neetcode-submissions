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
    int count =0;
    public int kthSmallest(TreeNode root, int k) {


     return smallest(root,k);
        
    }

    public int smallest(TreeNode root, int k){
      
      if(root==null)
      {
        return 0;
      }

      int left = smallest(root.left,k);
      count++;
      if(count ==k){
        return root.val;
      }
      int right = smallest(root.right,k);

      return left!=0?left:right;

    }
}
