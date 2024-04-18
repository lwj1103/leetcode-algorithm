package alrorithm.bitree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static alrorithm.bitree.traversal.BinaryTreePaths.traversal;

public class FindBottomLeftValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),null),new TreeNode(3,new TreeNode(5,new TreeNode(7),null),new TreeNode(6)));
        int bottomLeftValue = findBottomLeftValue(root);
        System.out.println(bottomLeftValue);
    }

    /**
     * 找树左下角的值
     * 层次遍历从右到左，最后遍历的节点为最左节点
     * @param root
     * @return
     */
    public static int findBottomLeftValue(TreeNode root) {
        int bottomValue = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            bottomValue = node.val;
            if(node.right != null) queue.offer(node.right);
            if(node.left != null) queue.offer(node.left);
        }
        return bottomValue;
    }


}
