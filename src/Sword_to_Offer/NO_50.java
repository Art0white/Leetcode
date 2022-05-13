package Sword_to_Offer;

import java.util.Arrays;

/**
 * @author Lovsog
 * 2022/5/10
 **/
class Solution_50 {
    public char firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            if(arr[s.charAt(i) - 'a'] == 1) {
                arr[s.charAt(i) - 'a'] = 2;
            }else if(arr[s.charAt(i) - 'a'] != 2 && arr[s.charAt(i) - 'a'] != 1){
                arr[s.charAt(i) - 'a'] = 1;
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            if(arr[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}

public class NO_50 {
    public static void main(String[] args) {
        System.out.println(new Solution_50().firstUniqChar("aadadaad"));
    }
}
