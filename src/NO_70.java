/**
 * @author Lovsog
 * 2022/4/9
 * LeetCode 70.爬楼梯
 **/

//递归超时了
class Solution70_RunTime {
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
}

//时间复杂度O(n)
class Solution70_AC1 {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}

public class NO_70 {
    public static void main(String[] args) {
        System.out.println(new Solution70_AC1().climbStairs(45));
    }
}
