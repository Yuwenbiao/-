package 编程训练.二叉搜索树的第k个节点;

//思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
public class Solution {
    int index = 0; //计数器

    TreeNode KthNode(TreeNode root, int k) {
        if (root != null) { //中序遍历寻找第k个
            TreeNode node = KthNode(root.left, k);
            if (node != null)
                return node;
            index++;
            if (index == k)
                return root;
            node = KthNode(root.right, k);
            if (node != null)
                return node;
        }
        return null;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}