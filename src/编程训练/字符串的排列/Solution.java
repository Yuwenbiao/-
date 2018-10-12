package 编程训练.字符串的排列;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * @author yuwb
 * @date 18-10-12 下午10:24
 */
public class Solution {
    public ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            //进行回溯，并将回溯组合结果保存到集合当中
            permutationhelper(str.toCharArray(), 0, res);
            //将结果排序
            Collections.sort(res);
        }
        return res;
    }

    /**
     * 基于回溯法
     * @param cs 待组合的字符数组
     * @param i 回溯的位置
     * @param list 组合结果集合
     */
    private void permutationhelper(char[] cs, int i, ArrayList<String> list) {
        //如果i的位置为数组长度-1，则将该字符组合加入结果集中，否则进行回溯
        if(i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val)) {
                list.add(val);
            }
        } else {
            for(int j = i; j < cs.length; ++j) {
                swap(cs, i, j);
                permutationhelper(cs, i + 1, list);
                //回溯时将原来调换位置的元素还原回来
                swap(cs, i, j);
            }
        }
    }

    /**
     * 交换数组中两个元素的值
     */
    private void swap(char[] cs, int i, int j){
        char temp=cs[i];
        cs[i]=cs[j];
        cs[j]=temp;
    }
}
