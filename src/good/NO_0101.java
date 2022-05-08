package good;

/**
 * @author Lovsog
 * 2022/5/6
 **/
class Solution_0101 {
    public boolean isUnique(String s) {
        long left = 0;
        long right = 0;
        for(char c:s.toCharArray()) {
            if(c >= 64){
                long bitIndex=1L << (c - 64);
                if((left & bitIndex)!=0){
                    return false;
                }
                left |= bitIndex;
            } else {
                long bitIndex=1L << c;
                if((right & bitIndex) != 0){
                    return false;
                }
                right |= bitIndex;
            }
        }
        return true;
    }
}

public class NO_0101 {
}
