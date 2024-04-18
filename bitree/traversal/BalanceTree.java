package alrorithm.bitree.traversal;

public class BalanceTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7,new TreeNode(7),null)));
        System.out.println(isBalanced(root));
    }

    /**
     * 平衡二叉树
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        return getHeight(root)==-1 ? false : true;
    }

    /**
     * 获取节点高度
     *
     * @param node
     * @return
     */
    public static int getHeight(TreeNode node){
        if(node == null) return 0;

        int leftHeight = getHeight(node.left);
        if(leftHeight == -1) return -1;

        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) return -1;

        if(Math.abs(leftHeight-rightHeight) > 1){
            return -1;
        }
        else {
            return Integer.max(leftHeight,rightHeight)+1;
        }
    }
}
