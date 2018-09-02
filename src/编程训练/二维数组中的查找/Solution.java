package 编程训练.二维数组中的查找;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {
    public boolean Find(int target, int[][] array) {
        //数组的行数
        int len = array.length - 1;
        int i = 0;

        //当len大于等于0且i小于总列数时
        while ((len >= 0) && (i < array[0].length)) {
            if (array[len][i] > target) {
                //当大于目标整数时行数减1
                len--;
            } else if (array[len][i] < target) {
                //当小于目标整数时列数加1
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}