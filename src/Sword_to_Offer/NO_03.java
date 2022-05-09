package Sword_to_Offer;

/**
 * @author Lovsog
 * 2022/5/9
 **/
class Solution_03 {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            if(arr[Math.abs(nums[i])] == 1) {
                return Math.abs(nums[i]);
            } else {
                arr[Math.abs(nums[i])] = 1;
            }
        }
        return 0;
    }
}

class Solution_03_2  {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}

public class NO_03 {
    public static void main(String[] args) {
        System.out.println(new Solution_03().findRepeatNumber(new int[]{3, 3, 1, 0, 2, 5, 3}));
    }
}
