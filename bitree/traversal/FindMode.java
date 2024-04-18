package alrorithm.bitree.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 501二叉搜索树中的众数
 */
public class FindMode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,new TreeNode(1,new TreeNode(1),null),new TreeNode(3,null,new TreeNode(3)));
        FindMode findMode = new FindMode();
        int[] mode = findMode.findMode(root);
        for (int i = 0; i <mode.length; i++) {
            System.out.println(mode[i]);
        }
    }
    TreeNode pre;
    int count;
    int maxCount;
    List<Integer> result;
    public int[] findMode(TreeNode root) {
        pre = null;
        count = 0;
        maxCount = 0;
        result = new ArrayList<>();
        traversal(root);
        int [] nums = new int[result.size()];
        for (int i = 0; i <result.size(); i++) {
            nums[i] = result.get(i);
        }
        return nums;
    }
    public void traversal(TreeNode root){
        if(root == null) return;
        traversal(root.left);
        if(pre == null) count = 1;
        else if(pre.val == root.val) count++;
        else count = 1;
        if(count == maxCount) result.add(root.val);
        else if(count > maxCount){
            maxCount = count;
            result.clear();
            result.add(root.val);
        }
        pre = root;
        traversal(root.right);

    }
}
