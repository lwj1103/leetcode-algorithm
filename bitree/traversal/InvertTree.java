package alrorithm.bitree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(LevelOrderTraversal.levelOrderTraversal(root));
        TreeNode revertTree = invertTree(root);
        List<List<Integer>> lists = LevelOrderTraversal.levelOrderTraversal(revertTree);
        System.out.println(lists);
        TreeNode symmetricTree = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        System.out.println("---对称二叉树---");
        System.out.println(LevelOrderTraversal.levelOrderTraversal(symmetricTree));
        System.out.println("是否为对称二叉树："+isSymmetric2(symmetricTree));

    }

    /**
     * 翻转二叉树
     * 遍历节点，交换左右孩子
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        //
        if(root != null) queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            //如果左右孩子不都为空，交换左右孩子
            TreeNode temp= new TreeNode();
            if(node.left!=null || node.right != null){
                temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        return root;
    }

    /**
     * 对称二叉树-迭代法
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        boolean result = true;
        //定义空节点
        TreeNode emptyNode = new TreeNode(101);
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                //判断是否为空节点
                if(node.val == 101) continue;
                if(node.left != null) queue.add(node.left);
                //如果为空加入空节点
                else queue.add(emptyNode);
                if(node.right != null) queue.add(node.right);
                //如果为空加入空节点
                else queue.add(emptyNode);
            }
            int left = 0;
            int right = level.size()-1;
            while (left <= right){
                if(level.get(left) != level.get(right)){
                    result = false;
                    break;
                }
                left ++;
                right --;
            }
        }
        return result;
    }

    /**
     * 对称二叉树-递归法
     * @param root
     * @return
     */
    public static boolean isSymmetric2(TreeNode root) {
        if(root == null) return true;
        return compare(root.left,root.right);
    }

    /**
     * 判断左右子树是否是对称的
     * @param left
     * @param right
     * @return
     */
    public static boolean compare(TreeNode left,TreeNode right){
        if(left == null && right != null) return false;
        if(left != null && right == null) return false;
        if(left == null && right == null) return true;
        if(left.val != right.val) return  false;
        boolean outside = compare(left.left,right.right);
        boolean inside = compare(left.right,right.left);
        return outside && inside;
    }
}
