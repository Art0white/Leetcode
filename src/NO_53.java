/**
 * @author Lovsog
 * 2022/5/29
 **/
class Solution_53 {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}

public class NO_53 {
}
