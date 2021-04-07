package day106;
//剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class day106exercise_3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            TreeNode temp = q;
            q = p;
            p = temp;
        }

        while(root != null){
            if(root.val > q.val){
                root = root.left;
            }
            else if(root.val < p.val){
                root = root.right;
            }
            else{
                break;
            }
        }
        return root;
    }
}
