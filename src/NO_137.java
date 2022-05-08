import java.util.HashMap;
import java.util.Map;

/**
 * @author Lovsog
 * 2022/4/18
 **/
class Solution_137 {
    public int singleNumber(int[] nums) {
        int over = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }
        for(Map.Entry<Integer,Integer> temp : hashMap.entrySet()) {
            if(temp.getValue() == 1) {
                return temp.getKey();
            }
        }
        return over;
    }
}

public class NO_137 {
    public static void main(String[] args) {
        System.out.println(new Solution_137().singleNumber(new int[]{1,1,3,1,2,2,2}));
    }
}
