/**
 * LeetCode 762.二进制表示中质数个计算置位
 */
class Solution762 {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int x = left; x <= right; ++x) {
            if (((1 << Integer.bitCount(x)) & 665772) != 0) {
                ++ans;
            }
        }
        return ans;
    }
}

public class NO_762 {
    public static void main(String[] args) {
        System.out.println(new Solution762().countPrimeSetBits(0, 10));
    }
}

