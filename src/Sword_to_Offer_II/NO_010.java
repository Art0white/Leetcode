package Sword_to_Offer_II;

import java.util.HashMap;

/**
 * @author Lovsog
 * 2022/4/18
 **/
class Solution_S010 {
    public int subarraySum(int[] nums, int k) {

        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap <> ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
//            System.out.println(pre + " " + count);
//            System.out.println("map" + ":" + mp);
        }
        return count;
    }
}



public class NO_010 {
    public static void main(String[] args) {
        System.out.println(new Solution_S010().subarraySum(new int[]{1, 2, 3, 4}, 5));
    }
}
