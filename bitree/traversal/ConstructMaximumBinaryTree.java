package alrorithm.bitree.traversal;

import java.util.Arrays;
import java.util.List;

public class ConstructMaximumBinaryTree {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,5,0};
        TreeNode node = constructMaximumBinaryTree(nums);
        List<Integer> list = InorderTraversal.inorderTraversalRecursion(node);
        System.out.println(list);
    }
    /**
     * 654最大二叉树
     * @param nums
     * @return
     */
    public static TreeNode constructMaximumBinaryTree1(int[] nums) {
        //如果nums为空，返回空节点
        if(nums.length == 0) return null;
        //如果nums只有一个元素，创建根节点并返回
        if(nums.length == 1) return new TreeNode(nums[0]);
        //获取nums中的最大值和下标
        int max = Integer.MIN_VALUE;
        int indexOfMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
                indexOfMax = i;
            }
        }
        TreeNode root = new TreeNode(max);
        int[] leftNums = new int[indexOfMax];
        int[] rightNums = new int[nums.length-1-indexOfMax];
        //根据下标划分为左右两个数组
        for (int i = 0; i < nums.length; i++) {
            if(i < indexOfMax)
                leftNums[i] = nums[i];
            else if(i > indexOfMax)
                rightNums[i-indexOfMax-1] = nums[i];
        }
        root.left = constructMaximumBinaryTree1(leftNums);
        root.right = constructMaximumBinaryTree1(rightNums);
        return root;
    }

    /**
     * 最大二叉树，使用索引
     * @param nums
     * @return
     */
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildNode(nums,0,nums.length-1);
    }

    private static TreeNode buildNode(int[] nums, int left, int right) {
        if(left > right) return null;
        if(left == right) return new TreeNode(nums[left]);
        //获取范围内最大值
        int max = nums[left];
        int indexOfMax = left;
        for (int i = left+1;i<= right ; i++){
            if(nums[i] > max){
                max = nums[i];
                indexOfMax = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = buildNode(nums,left,indexOfMax-1);
        root.right = buildNode(nums,indexOfMax+1,right);
        return root;
    }
}
