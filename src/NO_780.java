/**
 * @author Lovsog
 * 2022/4/9
 * LeetCode 780.到达终点
 **/

/* 错了 */
class Solution780_RunTime {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
//        int min = Math.min(sx, sy) - 1;

        while (tx - ty > 0 || ty - tx > 0) {
            if(ty > tx) {
                ty %= tx;
                if(ty == 0) {
                    ty = tx;
                }
            } else {
                tx %= ty;
                if(tx == 0) {
                    tx = ty;
                }
            }
        }
        while (sx - sy > 0 || sy - sx > 0) {
            if(sy > sx) {
                sy %= sx;
                if(sy == 0) {
                    sy = sx;
                }
            } else {
                sx %= sy;
                if(sx == 0) {
                    sx = sy;
                }
            }
        }
        return sx == tx && sy == ty;
//        System.out.println(sx + "," + sy + "," + tx + "," + ty);

    }
}

class Solution780_AC {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy && tx != ty) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        if (tx == sx && ty == sy) {
            return true;
        } else if (tx == sx) {
            return ty > sy && (ty - sy) % tx == 0;
        } else if (ty == sy) {
            return tx > sx && (tx - sx) % ty == 0;
        } else {
            return false;
        }
    }
}

public class NO_780 {
    public static void main(String[] args) {
        System.out.println(new Solution780_AC().reachingPoints(6, 3, 6, 15));
    }
}
