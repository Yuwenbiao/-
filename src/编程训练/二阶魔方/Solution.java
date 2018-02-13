package 编程训练.二阶魔方;

/**
 * 最多五步，每一步都有6种可能，分别是前面，上面和右面顺时针或逆时针旋转90度。枚举就可以。
 */
public class Solution {
    private int[] _up = new int[4];
    private int[] _down = new int[4];
    private int[] _left = new int[4];
    private int[] _right = new int[4];
    private int[] _front = new int[4];
    private int[] _back = new int[4];

    public static void main(String[] args) {

    }

    private int calnow() {
        int now[] = {1, 1, 1, 1, 1, 1};
        int result = 0;
        for (int i = 0; i < 4; i++) {
            now[0] *= _up[i];
            now[1] *= _down[i];
            now[2] *= _left[i];
            now[3] *= _right[i];
            now[4] *= _front[i];
            now[5] *= _back[i];
        }
        for (int i = 0; i < 6; i++) {
            result += now[i];
        }
        return result;
    }

    // 上层顺时针旋转90度
    private void upp() {
    }

    // 上层逆时针旋转90度
    private void upn() {

    }

    // 右层顺时针旋转90度
    private void rightp() {

    }

    // 右层逆时针旋转90度
    private void rightn() {

    }

    // 前层顺时针旋转90度
    private void frontp() {

    }

    // 前层逆时针旋转90度
    private void frontn() {

    }

    public int rotate(int i) {
        return 0;
    }
}
