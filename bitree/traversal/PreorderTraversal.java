package alrorithm.bitree.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 先序遍历
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
        List<Integer> list = preorderTraversalIterate(root);
        System.out.println(list);
    }

    /**
     * 迭代法先序遍历二叉树
     * @param root
     * @return
     */
    private static List<Integer> preorderTraversalIterate(TreeNode root) {
        if(root == null){
            return new LinkedList<>();
        }
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return list;

    }

    /**
     * 递归法先序遍历二叉树
     * @param root
     * @return
     */
    private static List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preorderTraversal(root,list);
        return list;
    }

    private static void preorderTraversal(TreeNode node, List<Integer> list) {
        if(node == null){
            return;
        }
        list.add(node.val);
        preorderTraversal(node.left,list);
        preorderTraversal(node.right,list);
    }



}
