package 编程训练.按之字形顺序打印二叉树;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思想：使用两个栈轮流装载每行的数据实现之字形
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> aList = new ArrayList<>();
        if (pRoot == null)
            return aList;
        Stack<TreeNode> s1 = new Stack<>();
        s1.add(pRoot);
        Stack<TreeNode> s2 = new Stack<>();
        /**
         * 哪个栈不为空迭代哪个，迭代的同时把下一行的结点放入另一个栈中
         */
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                ArrayList<Integer> aList2 = new ArrayList<>();
                while (!s1.isEmpty()) {
                    TreeNode p = s1.pop();
                    aList2.add(p.val);
                    if (p.left != null)
                        s2.add(p.left);
                    if (p.right != null)
                        s2.add(p.right);
                }
                aList.add(aList2);
            } else {
                ArrayList<Integer> aList2 = new ArrayList<>();
                while (!s2.isEmpty()) {
                    TreeNode p = s2.pop();
                    if (p.right != null)
                        s1.add(p.right);
                    if (p.left != null)
                        s1.add(p.left);
                    aList2.add(p.val);
                }
                aList.add(aList2);
            }
        }
        return aList;
    }
}
