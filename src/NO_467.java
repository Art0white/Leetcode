import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Lovsog
 * 2022/5/25
 **/

// 超时
class Solution_467_1 {
    public int findSubstringInWraproundString(String p) {
        Set<String> set = new HashSet<String>();
        int n = p.length();
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                set.add(p.substring(i, j+1));
            }
        }
        n = set.size();
        String[] arr = new String[n];
        String[] arrover = new String[n];
        int dx = 0;
        set.toArray(arr);
//        System.out.println(Arrays.toString(arr));


        for(int i = 0; i < n; ++i) {
            if(arr[i].length() == 1) {
                arrover[dx] = arr[i];
                ++dx;
            } else {
                int arrn = arr[i].length();
                int flag = 0;
                for (int x = 1; x < arrn; ++x) {
                    if(arr[i].charAt(x-1) == 'z') {
                        if(arr[i].charAt(x) != 'a') {
                            flag = 1;
                        }
                    } else {
                        if(arr[i].charAt(x) - arr[i].charAt(x-1) != 1) {
                            flag = 1;
                        }
                    }
                }
                if(flag == 0) {
                    arrover[dx] = arr[i];
                    ++dx;
                }
            }
        }
//        System.out.println(Arrays.toString(arrover));
        return dx;
    }
}

class Solution_467_2 {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); ++i) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) { // 字符之差为 1 或 -25
                ++k;
            } else {
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
        }
        return Arrays.stream(dp).sum();
    }
}

public class NO_467 {
    public static void main(String[] args) {
        System.out.println(new Solution_467_2().findSubstringInWraproundString("zab"));
    }
}
