package alrorithm.bitree.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
        List<Integer> list = inorderTraversalIterate(root);
        System.out.println(list);
    }

    /**
     * 迭代法中序遍历二叉树
     * @param root
     * @return
     */
    private static List<Integer> inorderTraversalIterate(TreeNode root) {
        List<Integer> traversal = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                traversal.add(cur.val);
                cur = cur.right;
            }
        }
        return traversal;
    }

    /**
     * 递归发中序遍历二叉树
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversalRecursion(TreeNode root){
        List<Integer> list = new LinkedList<>();
        inorderTraversal(root,list);
        return list;
    }
    public static void inorderTraversal(TreeNode node,List<Integer> list){
        if(node == null){
            return;
        }
        inorderTraversal(node.left,list);
        list.add(node.val);
        inorderTraversal(node.right,list);
    }

}
