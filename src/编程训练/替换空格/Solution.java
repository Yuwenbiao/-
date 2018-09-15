package 替换空格;

/**
 * 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author yuwb
 * @date 2018/9/15 8:09
 */
public class Solution {
    /**
     * 方法1
     */
    private static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newStr.append("%20");
            } else {
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }

    /**
     * 方法2
     */
    private static String replaceSpace2(StringBuffer stringBuffer) {
        return stringBuffer.toString().replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        String str = "We Are Happy";
        StringBuffer sb = new StringBuffer(str);
        System.out.println(replaceSpace2(sb));
    }
}
