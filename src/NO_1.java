/**
 * LeetCode 1.两数之和
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (record.containsKey(target - nums[i])) {
                return new int[]{record.get(target - nums[i]), i};
            }
            record.put(nums[i], i);
        }
        return new int[0];
    }
}

public class NO_1 {
    public static void main (String[] args) {
        int[] nums = {0};
        Scanner sc = new Scanner(System.in);
        nums = new int[]{2, 7, 11, 15};
        Solution1 solution1 = new Solution1();
        solution1.twoSum(nums, 9);
    }
}
