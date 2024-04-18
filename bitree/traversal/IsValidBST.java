package alrorithm.bitree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 98,验证二叉搜索树
 */
public class IsValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,new TreeNode(1),new TreeNode(4,new TreeNode(3),new TreeNode(6)));
        System.out.println(isValidBST1(root));
        System.out.println(isValidBST(root));
    }

    /**
     * 先得到树的中序遍历序列，再判断是不是有序的
     * @param root
     * @return
     */
    public static boolean isValidBST1(TreeNode root) {
        //先得到树的中序遍历序列，再判断是不是有序的
        List<Integer> list = new ArrayList<>();
        traversal(root,list);
        for(int i = 0;i<list.size()-1;i++){
            if(list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public static void traversal(TreeNode root,List<Integer>list) {
        if(root == null) return ;
        traversal(root.left,list);
        list.add(root.val);
        traversal(root.right,list);
    }

    /**
     * 使用迭代法中序遍历，判断前一个节点的值是否大于等于后一个节点，如果是返回false
     */
    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                if(pre != null && pre.val >= cur.val)
                    return false;
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }
}
