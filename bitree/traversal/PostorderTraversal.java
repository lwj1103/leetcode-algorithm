package alrorithm.bitree.traversal;

import java.util.*;

/**
 * 二叉树的后序遍历
 */
public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
        List<Integer> list = postorderTraversalIterate(root);
        System.out.println(list);
    }

    /**
     * 迭代法后序遍历二叉树
     * 先序遍历-中左右
     * 后续遍历-左右中 = 中右左倒序
     * @param root
     * @return
     */
    private static List<Integer> postorderTraversalIterate(TreeNode root) {
        if(root == null){
            return new LinkedList<>();
        }
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        Collections.reverse(list);
        return list;
    }

    /**
     * 递归法后序遍历二叉树
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversalRecursion(TreeNode root){
        List<Integer> list = new LinkedList<>();
        postorderTraversal(root,list);
        return  list;
    }

    private static void postorderTraversal(TreeNode node, List<Integer> list) {
        if(node == null){
            return;
        }
        postorderTraversal(node.left,list);
        postorderTraversal(node.right,list);
        list.add(node.val);
    }
}
