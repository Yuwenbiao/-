package 编程训练.把二叉树打印成多行;

import java.util.ArrayList;
import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/**
 * 定义一个临时集合tmp存放每一行数据，以及链表q用于存放每一行迭代的数据
 * next代表下一行节点的个数，now代表本行节点的个数，now为零时输出并把temp清空
 */
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        if (pRoot == null)
            return ret;
        q.add(pRoot);
        int now = 1, next = 0;
        while (!q.isEmpty()) {
            TreeNode t = q.remove();
            now--;
            tmp.add(t.val);
            if (t.left != null) {
                q.add(t.left);
                next++;
            }
            if (t.right != null) {
                q.add(t.right);
                next++;
            }
            if (now == 0) {
                ret.add(new ArrayList<>(tmp));
                tmp.clear();
                now = next;
                next = 0;
            }
        }
        return ret;
    }
}
