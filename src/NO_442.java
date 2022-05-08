import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lovsog
 * 2022/5/8
 **/
class Solution_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; ++i) {
            if(nums[i] == nums[i+1]) {
                list.add(nums[i]);
                ++i;
            }
        }
        return list;
    }
}

class Solution_442_2 {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                ans.add(x);
            }
        }
        return ans;
    }
}

public class NO_442 {
    public static void main(String[] args) {
        System.out.println(new Solution_442().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
