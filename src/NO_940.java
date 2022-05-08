import java.util.Arrays;

/**
 * @author Lovsog
 * 2022/4/18
 * LeetCode 940.不同的子序列 II
 **/

class Solution_940 {
    public int distinctSubseqII(String S) {
        // 除以 1 000 000 007
        int MOD = 1_000_000_007;
        // 记录输入S长度
        int N = S.length();
        // 动态
        int[] dp = new int[N+1];
        // 一个字母时
        dp[0] = 1;

        // 记录26个字母是否出现过(最后一次出现的位置)
        int[] last = new int[26];
        // 所以元素记为 -1
        Arrays.fill(last, -1);

        for (int i = 0; i < N; ++i) {
            // 字符减去'a'就是其在last中的index
            int x = S.charAt(i) - 'a';
            //
            dp[i+1] = dp[i] * 2 % MOD;
            if (last[x] >= 0)
                dp[i+1] -= dp[last[x]];
            dp[i+1] %= MOD;
            // 记录该字母出现最后一次出现的位置
            last[x] = i;
        }

        dp[N]--;
        if (dp[N] < 0) dp[N] += MOD;
        return dp[N];
    }
}

public class NO_940 {
    public static void main(String[] args) {
        System.out.println(new Solution_940().distinctSubseqII("abc"));
    }
}
