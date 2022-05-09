package Sword_to_Offer;

/**
 * @author Lovsog
 * 2022/5/8
 **/
class Solution_58 {
    public String reverseLeftWords(String s, int n) {
        String a = s.substring(0, n);
        String b = s.substring(n, s.length());
        return b + a;
    }
}

public class NO_58 {
    public static void main(String[] args) {
        System.out.println(new Solution_58().reverseLeftWords("abcdefg", 2));
    }
}
