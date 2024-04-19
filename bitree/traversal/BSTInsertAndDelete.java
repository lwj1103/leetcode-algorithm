package alrorithm.bitree.traversal;

public class BSTInsertAndDelete {
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
}
