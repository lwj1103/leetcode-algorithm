package alrorithm.bitree.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        int i = countNodesIterate(root);
        System.out.println(i);
    }

    /**
     * 完全二叉树的节点个数--迭代法
     * @param root
     * @return
     */
    public static int countNodesIterate(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            count++;
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        return count;
    }
    /**
     * 完全二叉树的节点个数 -- 递归法
     */
    public static int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount+rightCount+1;
    }
}
