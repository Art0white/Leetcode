/**
 * @author Lovsog
 * 2022/4/18
 * LeetCode 479.最大回文数乘积
 **/
class Solution_479 {
    public int largestPalindrome(int n) {
        // 1位
        if (n == 1) {
            return 9;
        }
        // n位
        int upper = (int) Math.pow(10, n) - 1;
        // 结果
        int ans = 0;

        for (int left = upper; ans == 0; --left) {
            // 枚举回文数的左半部分
            long p = left;
            for (int x = left; x > 0; x /= 10) {
                // 翻转左半部分到其自身末尾，构造回文数 p
                p = p * 10 + x % 10;
            }
            for (long x = upper; x * x >= p; --x) {
                if (p % x == 0) {
                    // x 是 p 的因子
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }
}

public class NO_479 {
    public static void main(String[] args) {
        System.out.println(new Solution_479().largestPalindrome(8));
    }
}
