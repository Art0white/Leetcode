import java.util.Arrays;

/**
 * @author Lovsog
 * 2022/5/25
 **/
class Solution_1299 {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] dx = new int[n];
        for(int i = 0; i < n; ++i) {
            if(i == n - 1) {
                arr[i] = -1;
                break;
            }
            int[] newarr = Arrays.copyOfRange(arr, i+1, n);
            arr[i] = Arrays.stream(newarr).max().getAsInt();
        }
        return arr;
    }
}

public class NO_1299 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_1299().replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
    }
}
