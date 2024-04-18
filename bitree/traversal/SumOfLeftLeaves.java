package alrorithm.bitree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        int i = sumOfLeftLeaves(root);
        System.out.println(i);
    }

    /**
     * 左叶子之和--前序遍历迭代法
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves1(TreeNode root) {
        int sum = 0;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
                if(cur!=null&&cur.left==null&& cur.right==null){
                    sum+=cur.val;
                }
            }
            else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return sum;
    }

    /**
     * 递归法
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);
        int sum = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            sum = root.left.val;
        }
        return sum + leftSum + rightSum;
    }


}
