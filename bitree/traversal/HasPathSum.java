package alrorithm.bitree.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class HasPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,new TreeNode(4,new TreeNode(11,new TreeNode(7),new TreeNode(2)),null),new TreeNode(8,new TreeNode(13),new TreeNode(4,new TreeNode(5),new TreeNode(1))));
        boolean b = hasPathSum2(root, 22);
        System.out.println(b);
        List<List<Integer>> lists = pathSum(root, 22);
        System.out.println(lists);

    }

    /**
     * 路径总和-递归法
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }

    /**
     * 路径总和-迭代法
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum2(TreeNode root, int targetSum) {
       if(root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sum = new Stack<>();
        stack.push(root);
        sum.push(root.val);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            Integer target = sum.pop();
            if(node.left == null && node.right==null){
                if(target == targetSum) return true;
                continue;
            }
            if(node.right != null){
                stack.push(node.right);
                sum.push(target+node.right.val);
            }
            if(node.left != null){
                stack.push(node.left);
                sum.push(target+node.left.val);
            }
        }
        return false;
    }

    /**
     * 113.路径总和2
     * @param root
     * @param targetSum
     * @return
     */
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        traversalPath(root,targetSum,path,result);
        return result;
    }

    private static void traversalPath(TreeNode root, int targetSum, List<Integer> path,List<List<Integer>> result) {
        if(root == null) return;
        path.add(root.val);
        if(root.left == null && root.right == null && targetSum == root.val){
            List<Integer> list = new LinkedList<>();
            list.addAll(path);
            result.add(list);
        }
        traversalPath(root.left,targetSum-root.val,path,result);
        traversalPath(root.right,targetSum-root.val,path,result);
        path.remove(path.size()-1);
    }
}
