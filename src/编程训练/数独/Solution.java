package 编程训练.数独;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[][] data = new int[9][9];//9*9的二维数组，代表数独棋盘
            ArrayList<HashSet<Integer>> row = new ArrayList<HashSet<Integer>>();//行
            ArrayList<HashSet<Integer>> col = new ArrayList<HashSet<Integer>>();//列
            ArrayList<HashSet<Integer>> squ = new ArrayList<HashSet<Integer>>();//宫

            //初始化,利用HashSet排除当前行、当前列、当前宫重复的数字
            for (int i = 0; i < 9; i++) {
                row.add(new HashSet<Integer>());
                col.add(new HashSet<Integer>());
                squ.add(new HashSet<Integer>());
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    data[i][j] = sc.nextInt();
                    if (data[i][j] != 0) {
                        //如果输入不为零则加入hashset
                        row.get(i).add(data[i][j]);
                        col.get(j).add(data[i][j]);
                        squ.get(i / 3 * 3 + j / 3).add(data[i][j]);
                    }
                }
            }

            //调用求解
            dfs(data, row, col, squ, 0);

            //输出
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (j != 8)
                        System.out.print(data[i][j] + " ");
                    else
                        System.out.println(data[i][j]);
                }
            }
        }
        sc.close();
    }


    public static boolean dfs(int[][] data, ArrayList<HashSet<Integer>> row, ArrayList<HashSet<Integer>> col, ArrayList<HashSet<Integer>> squ, int index) {
        if (index == 81)
            return true;
        int m = index / 9;//行
        int n = index % 9;//列
        int k = m / 3 * 3 + n / 3;//宫

        if (data[m][n] != 0) {
            //如果该索引位置的数字不为零则递归调用，索引+1
            return dfs(data, row, col, squ, index + 1);
        } else {
            for (int i = 1; i <= 9; i++) {
                //遍历1~9，如果该数字所对应的行列宫都不存在，则填入该数字
                if (!row.get(m).contains(i) && !col.get(n).contains(i) && !squ.get(k).contains(i)) {
                    data[m][n] = i;
                    row.get(m).add(i);
                    col.get(n).add(i);
                    squ.get(k).add(i);
                    //如果当前填入的数字无法满足后面的情况则回退，删除该数字
                    if (dfs(data, row, col, squ, index + 1))
                        return true;
                    data[m][n] = 0;
                    row.get(m).remove(i);
                    col.get(n).remove(i);
                    squ.get(k).remove(i);
                }
            }
            return false;
        }
    }
}
