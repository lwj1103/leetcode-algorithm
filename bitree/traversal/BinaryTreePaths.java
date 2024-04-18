package alrorithm.bitree.traversal;

import java.util.*;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7,new TreeNode(7),null)));
        List<String> strings = binaryTreePaths(root);
        System.out.println(strings);
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return null;
        List<Integer> path = new ArrayList<>();
        List<String> result = new LinkedList<>();
        traversal(root,path,result);
        return result;
    }
    public static void traversal(TreeNode node, List<Integer> path,List<String> result){
        path.add(node.val);
        if(node.left == null && node.right ==null){
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < path.size()-1; i++) {
                sb.append(path.get(i)+"->");
            }
            sb.append(path.get(path.size()-1));
            result.add(sb.toString());
        }
        if(node.left != null){
            traversal(node.left,path,result);
            path.remove(path.size()-1);
        }
        if(node.right != null){
            traversal(node.right,path,result);
            path.remove(path.size()-1);
        }
    }
}
