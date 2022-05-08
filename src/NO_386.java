import java.util.ArrayList;
import java.util.List;

/**
 * @author Lovsog
 * 2022/4/18
 * LeetCode 386.字典序排数
 **/
// 迭代
class Solution_386 {
    public List<Integer> lexicalOrder(int n) {
        // 创建一个结果集
        List<Integer> ret = new ArrayList<Integer>();
        int number = 1;
        // DFS 深度优先搜索
        for (int i = 0; i < n; i++) {
            ret.add(number);
            // 如果数据*10小于n，则*10；否则....
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return ret;
    }
}
//递归
class Solution_386_3 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) dfs(i, n);
        return ans;
    }
    void dfs(int cur, int limit) {
        if (cur > limit) return ;
        ans.add(cur);
        for (int i = 0; i <= 9; i++) dfs(cur * 10 + i, limit);
    }
}

public class NO_386 {
    public static void main(String[] args) {
        System.out.println(new Solution_386().lexicalOrder(110));
    }
}
