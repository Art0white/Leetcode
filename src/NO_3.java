import java.util.Vector;

/**
 * LeetCode 3.无重复字符的最长子串
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] ns = s.toCharArray();
        Vector<Integer> pos = new Vector<Integer>(128, -1);
        int ans = 0;
        // j相当于左边界
        for(int i = 0, j = 0; i < s.length(); i++) {
            j = Math.max(j, pos.get(ns[i]) + 1);
            // 当前窗口的长度
            ans = Math.max(ans, i - j + 1);
            // 当前字符位置
            pos.set(ns[i], i);
        }
        return ans;
    }
}
public class NO_3 {
    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abcabcbb"));
    }
}
