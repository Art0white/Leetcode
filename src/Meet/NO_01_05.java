package Meet;

/**
 * @author Lovsog
 * 2022/5/13
 * https://leetcode.cn/problems/one-away-lcci/
 **/
class Solution_01_05 {
    public boolean oneEditAway(String first, String second) {
        if(first.length() == second.length()) {
            int n = second.length();
            int wnum = 0;
            for(int i = 0; i < n; ++i) {
                if(first.charAt(i) != second.charAt(i)) {
                    if (wnum == 0) {
                        ++wnum;
                    } else if(wnum == 1) {
                        return false;
                    }
                }
            }
            return true;
        } else if(first.length() - 1 == second.length()) {
            int firstw = 0;
            int secondw = 0;
            int n = second.length();
            for(int i = 0; i < n; ++i) {
                if(first.charAt(firstw) != second.charAt(secondw)) {
                    if(firstw - secondw == 1) {
                        return false;
                    } else {
                        ++firstw;
                        --i;
                        continue;
                    }
                }
                ++firstw;
                ++secondw;
            }
            return true;
        } else if(first.length() == second.length() - 1) {
            int firstw = 0;
            int secondw = 0;
            int n = first.length();
            for(int i = 0; i < n; ++i) {
                if(first.charAt(firstw) != second.charAt(secondw)) {
                    if(secondw - firstw == 1) {
                        return false;
                    } else {
                        ++secondw;
                        --i;
                        continue;
                    }
                }
                ++firstw;
                ++secondw;
            }
            return true;
        }
        return false;
    }
}

public class NO_01_05 {
}
