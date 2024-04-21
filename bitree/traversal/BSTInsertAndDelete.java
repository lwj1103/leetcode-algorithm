package alrorithm.bitree.traversal;

import java.util.List;

public class BSTInsertAndDelete {
    public static void main(String[] args) {
        int[] nums = {10,-3,0,5,9};
        BSTInsertAndDelete bstInsertAndDelete = new BSTInsertAndDelete();
        TreeNode root = bstInsertAndDelete.sortedArrayToBST(nums);
        List<Integer> list = InorderTraversal.inorderTraversalRecursion(root);
        System.out.println(list);
    }
    /**
     * 二叉搜索树中插入节点
     * @param root 根节点
     * @param val 要插入节点的值
     * @return 返回根节点
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }
        if(root.val > val){
            root.left = insertIntoBST(root.left,val);
        }
        if(root.val < val){
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }

    /**
     * 删除二叉树中的节点
     * @param root 根节点
     * @param key 要删除节点的值
     * @return 返回删除后的根节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            if(root.left == null && root.right == null) return null;
            else if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{
                TreeNode cur = root.right;
                while(cur.left != null){
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }
        else if(root.val > key){
            root.left = deleteNode(root.left,key);
        }
        else
            root.right = deleteNode(root.right,key);
        return root;
    }

    /**
     * 修剪二叉树
     * @param root 根节点
     * @param low 修剪区间左边界
     * @param high 修剪区间右边界
     * @return 返回修剪后的根节点
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(root.val < low) return trimBST(root.right,low,high);
        if(root.val > high) return trimBST(root.left,low,high);
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }

    /**
     * 108.将有序数组转换为二叉搜索树
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵
     * 平衡二叉搜索树。
     * @param nums 整数数组
     * @return 返回创建的平衡二叉搜索树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return getNode(nums,0,nums.length);
    }
    public TreeNode getNode(int[] nums,int left,int right){
        if(left >= right) return null;
        int mid = (right+left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = getNode(nums,left,mid);
        node.right = getNode(nums,mid+1,right);
        return node;
    }
}
