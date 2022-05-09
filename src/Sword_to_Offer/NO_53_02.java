package Sword_to_Offer;

/**
 * @author Lovsog
 * 2022/5/9
 **/
class Solution_53_02 {
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

public class NO_53_02 {
    public static void main(String[] args) {

    }
}
