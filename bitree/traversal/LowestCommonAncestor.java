package alrorithm.bitree.traversal;

/**
 * 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6,new TreeNode(2,new TreeNode(0),new TreeNode(4,new TreeNode(3),new TreeNode(5))),new TreeNode(8,new TreeNode(7),new TreeNode(9)));
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        TreeNode node = lowestCommonAncestor.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        System.out.println(node.val);
        TreeNode node1 = lowestCommonAncestor.lowestCommonAncestor2(root, p, q);
        System.out.println(node1.val);

    }
    /**
     * 普通二叉树的公共祖先
     * @param root 根节点
     * @param p 节点1
     * @param q 节点2
     * @return 返回公共祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null) return root;
        else if(left == null) return right;
        else if(right == null) return left;
        else return null;
    }

    /**
     * 二叉搜索树的最近公共祖先
     * @param root 根节点
     * @param p 节点p
     * @param q 节点q
     * @return 返回节点p和节点q的公共祖先
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else return root;
    }
}
