import java.util.*;

/**
 * @author Lovsog
 * 2022/4/17
 * LeetCode 819.最常见的单词
 **/

class Solution_819 {
    public String mostCommonWord(String paragraph, String[] banned) {

        Map<String, Integer> map = new HashMap<>(); //用来存放单词，key为单词，value为出现次数
        Set<String> set = new HashSet<>(Arrays.asList(banned));// 用来存放禁用单词
        String strr = ""; // 暂存单词
        String over = ""; // 结果单词(出现次数最多的单词)
        int max = 0; // 结果单词出现次数

        //字符串全小写
        paragraph = paragraph.toLowerCase();

        //最后一位空，防止判断中只有一个单词后，直接跳出
        paragraph = paragraph + " ";
        for(int i = 0; i < paragraph.length(); i++) {

            if(paragraph.charAt(i) > 122 || paragraph.charAt(i) < 97) {
                if(!strr.equals("")) {
                    // 如果该单词(字符串)在禁用集中
                    if (set.contains(strr)) {
                        strr = "";
                        continue;
                    }
                    // 如果该单词(字符串)不在禁用集中
                    if (!map.containsKey(strr)) {
                        //该单词(字符串第一次出现)
                        map.put(strr, 1);
                    } else {
                        //该单词(字符串多次出现)
                        map.put(strr,map.get(strr)+1);
                    }
                    // 如果该单词(字符串)出现次数最多
                    if(map.get(strr) > max) {
                        max = map.get(strr);
                        over = strr;
                    }
                    // 初始化
                    strr = "";
                }
            } else {
                // 字符串仍然在连续下去
                strr = strr + paragraph.charAt(i);
            }
        }
        return over;
    }
}

class Solution_819AC {
    public String mostCommonWord(String s, String[] banned) {
        // Set<String> set = new HashSet<>();
        // for (String b : banned) set.add(b);
        Set<String> set = new HashSet<>(Arrays.asList(banned));

        char[] cs = s.toCharArray();
        int n = cs.length;
        String ans = null;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ) {
            if (!Character.isLetter(cs[i]) && ++i >= 0) continue;
            int j = i;
            while (j < n && Character.isLetter(cs[j])) j++;
            String sub = s.substring(i, j).toLowerCase();
            i = j + 1;
            if (set.contains(sub)) continue;
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (ans == null || map.get(sub) > map.get(ans)) ans = sub;
        }
        return ans;
    }
}
public class NO_819 {
    public static void main(String[] args) {
        System.out.println(new Solution_819().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
}
