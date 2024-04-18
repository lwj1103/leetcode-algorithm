package alrorithm.bitree.traversal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildTree2 {
    static Map<Integer,Integer> map;
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        List<Integer> list = InorderTraversal.inorderTraversalRecursion(root);
        System.out.println(list);
    }

    /**
     * 根据前序和中序遍历序列构造二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return getNode(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private static TreeNode getNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if(preBegin > preEnd) return null;
        int rootValue = preorder[preBegin];
        TreeNode root = new TreeNode(rootValue);
        if(preBegin == preEnd) return root;
        //获取中序遍历中根节点的下标
        int rootIndex = map.get(rootValue);
        int leftLen = rootIndex - inBegin;
        root.left = getNode(preorder,preBegin+1,preBegin+leftLen,inorder,inBegin,rootIndex-1);
        root.right = getNode(preorder,preBegin+leftLen+1,preEnd,inorder,rootIndex+1,inEnd);
        return root;
    }
}
