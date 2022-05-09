package Sword_to_Offer;

/**
 * @author Lovsog
 * 2022/5/9
 **/
class Solution_53_01 {
    public int search(int[] nums, int target) {
        int num = 0;
        for (int j : nums) {
            if (j == target) {
                ++num;
            }
        }
        return num;
    }
}

class Solution_53_01_2 {
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}

public class NO_53_01 {
}
