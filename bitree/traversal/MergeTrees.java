package alrorithm.bitree.traversal;

public class MergeTrees {
    /**
     * 617合并二叉树
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        TreeNode root = new TreeNode(root1.val+root2.val);
        root.left = mergeTrees(root1.left,root2.left);
        root.right = mergeTrees(root1.right,root2.right);
        return root;
    }
    /**
     * 二叉搜索树中的搜索
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        else if(root.val > val) return searchBST(root.left,val);
        else return searchBST(root.right,val);
    }
}
