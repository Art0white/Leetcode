package Sword_to_Offer_II;

/**
 * @author Lovsog
 * 2022/4/18
 **/
class Solution_S005 {
    public String replaceSpace(String s) {
        return s.replace(" ","%20");
    }
}

public class NO_005 {
    public static void main(String[] args) {
        System.out.println(new Solution_S005().replaceSpace("I love you!"));
    }
}
