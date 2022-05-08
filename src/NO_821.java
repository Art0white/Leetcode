import java.util.Arrays;

/**
 * @author Lovsog
 * 2022/4/19
 **/
class Solution_821 {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        for (int i = 0, idx = -n; i < n; ++i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = i - idx;
        }

        for (int i = n - 1, idx = 2 * n; i >= 0; --i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = Math.min(ans[i], idx - i);
        }
        return ans;
    }
}

public class NO_821 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_821().shortestToChar("abadcwd", 'a')));
    }
}
