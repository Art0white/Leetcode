import java.util.Arrays;

/**
 * @author Lovsog
 * 2022/5/29
 **/
// IPv4 还有问题，当里面有字母时出错
class Solution_468 {
    public String validIPAddress(String queryIP) {
        // IPv4
        if(queryIP.indexOf('.') >= 0) {
            if(queryIP.charAt(0) == '.' || queryIP.charAt(queryIP.length() - 1) == '.') {
                return "Neither";
            }
            if(queryIP.indexOf(':') >= 0) {
                return "Neither";
            }
            String[] strs = queryIP.split("\\.");
            if(strs.length != 4) {
                return "Neither";
            }
            for(int i = 0; i < strs.length; ++i) {
                if(strs[i].length() > 3) {
                    return "Neither";
                } else if(strs[i].length() == 3) {
                    if(strs[i].charAt(0) == '0' || strs[i].charAt(0) > '2') {
                        return "Neither";
                    }
                    if(strs[i].charAt(0) == '2') {
                        if(strs[i].charAt(1) > '5' || (strs[i].charAt(1) == '5' && strs[i].charAt(2) > '5')) {
                            return "Neither";
                        }
                    }
                } else if(strs[i].length() == 2) {

                    if(strs[i].charAt(0) == '0') {
                        return "Neither";
                    }
                }
            }
            return "IPv4";
        } else {
            if(queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length() - 1) == ':') {
                return "Neither";
            }
            String[] strs = queryIP.split(":");
            if(strs.length != 8) {
                return "Neither";
            }
            for(int i = 0; i < strs.length; ++i) {
                if(strs[i].length() > 4 || strs[i].length() == 0) {
                    return "Neither";
                }
                for (int j = 0; j < strs[i].length(); ++j) {
                    char a = strs[i].charAt(j);
                    if(!((a >= '0' && a <= '9')||(a >= 'a' && a <= 'f')||(a >= 'A' && a <= 'F'))) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
    }
}

public class NO_468 {
    public static void main(String[] args) {
        System.out.println(new Solution_468().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}
