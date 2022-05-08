/**
 * @author Lovsog
 * 2022/4/19
 * LeetCode 125. 验证回文串
 **/

class Solution_125 {
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }
}

public class NO_125 {
    public static void main(String[] args) {
        System.out.println(new Solution_125().isPalindrome("125521"));
    }
}
