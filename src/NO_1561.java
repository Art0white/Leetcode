import java.util.Arrays;

/**
 * @author Lovsog
 * 2022/4/18
 **/
class Solution_1561 {
    public int maxCoins(int[] piles) {
        int sum = 0;
        int num = piles.length / 3;
        if (piles.length == 0) {
            return sum;
        }
        Arrays.sort(piles);
        for(int i = num; i < piles.length; i+=2) {
            sum += piles[i];
        }
        return sum;
    }
}

public class NO_1561 {
    public static void main(String[] args) {
        System.out.println(new Solution_1561().maxCoins(new int[]{9,8,7,6,5,1,2,3,4}));
    }
}
