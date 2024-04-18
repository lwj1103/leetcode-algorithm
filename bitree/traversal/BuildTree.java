package alrorithm.bitree.traversal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildTree {
    static Map<Integer,Integer> map;
    public static void main(String[] args) {
        int[] inorder = {1,2,3,4,5};
        int[] postorder = {1,4,5,3,2};
        TreeNode node = buildTree(inorder, postorder);
        List<Integer> list = InorderTraversal.inorderTraversalRecursion(node);
        System.out.println(list);
    }

    /**
     * 106:从中序与后序遍历序列构造二叉树
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTree1(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        int rootValue = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootValue);
        if(postorder.length == 1) return root;
        //划分出左右孩子的中序和后序数组
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootValue){
                rootIndex = i;
                break;
            }
        }
        int[] leftInorder = new int[rootIndex];
        int[] leftPostorder = new int[rootIndex];
        int[] rightInorder = new int[inorder.length-rootIndex-1];
        int[] rightPostorder = new int[inorder.length-rootIndex-1];
        for (int i = 0; i < inorder.length; i++) {
            if(i<rootIndex)
                leftInorder[i] = inorder[i];
            else if(i>rootIndex)
                rightInorder[i-rootIndex-1] = inorder[i];
        }
        for (int i = 0; i < postorder.length-1; i++) {
            if(i<rootIndex)
                leftPostorder[i] = postorder[i];
            else
                rightPostorder[i-rootIndex] = postorder[i];
        }
        root.left = buildTree1(leftInorder,leftPostorder);
        root.right = buildTree1(rightInorder,rightPostorder);
        return root;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return findNode(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private static TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if(inBegin > inEnd) return null;
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        if(inBegin == inEnd) return root;
        //划分左右中后序区域
        int rootIndex = map.get(rootValue);
        int leftLen = rootIndex - inBegin;
        root.left = findNode(inorder,inBegin,rootIndex-1,postorder,postBegin,postBegin+leftLen-1);
        root.right = findNode(inorder,rootIndex+1,inEnd,postorder,postBegin+leftLen,postEnd-1);
        return root;
    }

}
