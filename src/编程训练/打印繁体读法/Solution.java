package 编程训练.打印繁体读法;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.next();
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '0':
                    if (i != chars.length-1&&chars[chars.length-1]!='0'&&chars[i+1]!='0') {
                        System.out.print("零");
                    }
                    break;
                case '1':
                    System.out.print("壹");
                    add(i, chars);
                    break;
                case '2':
                    System.out.print("贰");
                    add(i, chars);
                    break;
                case '3':
                    System.out.print("叁");
                    add(i, chars);
                    break;
                case '4':
                    System.out.print("肆");
                    add(i, chars);
                    break;
                case '5':
                    System.out.print("伍");
                    add(i, chars);
                    break;
                case '6':
                    System.out.print("陆");
                    add(i, chars);
                    break;
                case '7':
                    System.out.print("柒");
                    add(i, chars);
                    break;
                case '8':
                    System.out.print("捌");
                    add(i, chars);
                    break;
                case '9':
                    System.out.print("玖");
                    add(i, chars);
                    break;
            }
        }
    }

    public static void add(int i, char[] chars) {
        if (chars.length - i == 2) {
            System.out.print("什");
        }
        if (chars.length - i == 3) {
            System.out.print("佰");
        }
        if (chars.length - i == 4) {
            System.out.print("仟");
        }
    }
}
