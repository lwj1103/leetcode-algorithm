package alrorithm.bitree.traversal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        List<List<Integer>> list = levelOrderTraversal(root);
        System.out.println(list);
        List<Integer> list1 = rightSideView(root);
        System.out.println(list1);
        List<Double> doubles = averageOfLevels(root);
        System.out.println(doubles);
        List<Integer> list2 = largestValues(root);
        System.out.println(list2);
        int i = maxDepth(root);
        System.out.println("maxDepth:"+i);
        int i1 = minDepth(root);
        System.out.println("minDepth:"+i1);
        int[] nums = {2,2,2,2};
        List<List<Integer>> lists = fourSum(nums, 8);
        System.out.println(lists);
    }

    /**
     * 二叉树的层次遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> traversal = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0;i < size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            traversal.add(list);
        }
        return traversal;
    }

    /**
     * 二叉树的右视图
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(i == size-1) result.add(node.val); //判断是否为最右边的节点
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }

    /**
     * 二叉树的层平均值
     * @param root
     * @return
     */
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            double avg = sum/size;
            result.add(avg);
        }
        return result;
    }

    /**
     * N叉树的层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                queue.addAll(node.children);
            }
            result.add(list);
        }
        return result;
    }

    /**
     * 每行树上的最大值
     * @param root
     * @return
     */
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i <size; i++) {
                TreeNode node = queue.poll();
                if(node.val>max) max = node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.add(max);
        }
        return result;
    }

    /**
     * 二叉树最大深度
     * @param root
     * @return
     */
    public static int maxDepthIterate(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        if(root != null) queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            count++;
        }
        return count;
    }

    /**
     * 二叉树的最大深度-后续递归法
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return 1 + Integer.max(leftMaxDepth,rightMaxDepth);
    }
    /**
     * 最小深度
     * @param root
     * @return
     */
    public static int minDepthIterate(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        if(root != null) queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left== null && node.right == null){
                    return count+1;
                }
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            count++;
        }
        return count;
    }

    /**
     * 二叉树的最小深度-递归法
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if(root.left == null && root.right != null) return rightDepth+1;
        if(root.left != null && root.right == null) return leftDepth+1;
        return 1+Integer.min(leftDepth,rightDepth);
    }

    /**
     * 四数之和
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if(target>0 && nums[i]>target) continue;
            //去重
            if(i>0&&nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length; j++) {
                //去重
                if(j>i+1&& nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = nums.length-1;
                while (left<right){
                    long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum > target) right--;
                    else if(sum < target) left++;
                    else {
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //去重
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left<right && nums[right] == nums[right-1]) right--;
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
