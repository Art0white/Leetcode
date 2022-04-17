import java.util.Arrays;
import java.util.Vector;

/**
 * LeetCode 3.无重复字符的最长子串
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] ns = s.toCharArray();
//        System.out.println("“" + ns[0] + "”");
        int[] pos = new int[200];
        Arrays.fill(pos, -1);
//        Vector<Integer> pos = new Vector<Integer>(128);
        int ans = 0;
        // j相当于左边界
        for(int i = 0, j = 0; i < ns.length; i++) {
            // pos[ns[i]] + 1 为当前字符上次出现的位置
            j = Math.max(j, pos[ns[i]] + 1);
//            System.out.println("“" + ns[i] + "”");
//            System.out.println("“" + pos[ns[i]] + "”");
            // 当前窗口的长度 (将窗口出现过的最大值存下来)
            ans = Math.max(ans, i - j + 1);
            // 当前字符位置
            pos[ns[i]] = i;
        }
        return ans;
    }
}

public class NO_3 {
    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abcabcbb"));
    }
}
