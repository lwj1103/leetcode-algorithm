package alrorithm.bitree.traversal;

public class GetMinimumDifference {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(6));
        int minimumDifference = getMinimumDifference(root);
        System.out.println(minimumDifference);
    }
    static int pre;
    static int min;
    public static int getMinimumDifference(TreeNode root) {
        pre = -1;
        min = Integer.MAX_VALUE;
        traversal(root);
        return min;
    }
    private static void traversal(TreeNode root){
        if(root == null) return;
        traversal(root.left);
        if(pre != -1 && root.val - pre < min){
            min = root.val - pre;
        }
        pre = root.val;
        traversal(root.right);

    }
}
