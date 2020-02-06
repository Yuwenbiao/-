package binarytree;

/**
 * 合并二叉树
 *
 * @author yuwb@corp.21cn.com
 * @date 2020/2/6 17:11
 */
public class MergeBinaryTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            t1.val += t2.val;
            return t1;
        }
        return t1 == null ? t2 : t1;
    }
}
