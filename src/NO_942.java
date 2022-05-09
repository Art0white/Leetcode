import java.util.Arrays;

/**
 * @author Lovsog
 * 2022/5/9
 **/
class Solution_942 {
    public int[] diStringMatch(String s) {
        int n = s.length(), lo = 0, hi = n;
        int[] perm = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            perm[i] = s.charAt(i) == 'I' ? lo++ : hi--;
        }
        perm[n] = lo; // 最后剩下一个数，此时 lo == hi
        return perm;
    }
}

public class NO_942 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_942().diStringMatch("IDID")));
    }
}
