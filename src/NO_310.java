import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Lovsog
 * 2022/4/6
 * LeetCode 310.最小高度树
 **/
class Solution310 {
    int N = 20010, M = N * 2, idx = 0;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int[] f1 = new int[N], f2 = new int[N], g = new int[N], p = new int[N];
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Arrays.fill(he, -1);
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            add(a, b); add(b, a);
        }
        dfs1(0, -1);
        dfs2(0, -1);
        List<Integer> ans = new ArrayList<>();
        int min = n;
        for (int i = 0; i < n; i++) {
            int cur = Math.max(f1[i], g[i]);
            if (cur < min) {
                min = cur;
                ans.clear();
                ans.add(i);
            } else if (cur == min) {
                ans.add(i);
            }
        }
        return ans;
    }
    int dfs1(int u, int fa) {
        for (int i = he[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == fa) continue;
            int sub = dfs1(j, u) + 1;
            if (sub > f1[u]) {
                f2[u] = f1[u];
                f1[u] = sub;
                p[u] = j;
            } else if (sub > f2[u]) {
                f2[u] = sub;
            }
        }
        return f1[u];
    }
    void dfs2(int u, int fa) {
        for (int i = he[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == fa) continue;
            if (p[u] != j) g[j] = Math.max(g[j], f1[u] + 1);
            else g[j] = Math.max(g[j], f2[u] + 1);
            g[j] = Math.max(g[j], g[u] + 1);
            dfs2(j, u);
        }
    }
}

class Solution310_text {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<Integer>();
        if (edges.length == 0) {
            list.add(0);
            return list;
        }
        if (n == 2) {
            list.add(0);
            list.add(1);
            return list;
        }
        int[][] map = new int[n][n];
        //结果
        int[] jg = new int[n];
        int num = 0;
        //成功
        int[] cg = new int[n];
        int cgnum = 0;
        //笔记
        int[] bj = new int[n];
        int bjnum = 0;
        for (int[] edge : edges) {
            map[edge[0]][edge[1]] = 1;
            map[edge[1]][edge[0]] = 1;
        }
//        for (int k = 0; k < n; k++) {
//            for (int b = 0; b < n; b++) {
//                System.out.print(map[k][b]);
//            }
//            System.out.println();
//        }

        for(int j = 0; j < n; j++) {
            IntStream stream1 = Arrays.stream(map[j]);
            if(stream1.sum() == 1) {
                bj[bjnum] = j;
                bjnum++;
            } else {
                cg[cgnum] = j;
                cgnum++;
            }
        }
        // 删除叶子
        for (int k = 0; k < bjnum; k++) {
            for (int m = 0; m < n; m++) {
                map[bj[k]][m] = 0;
                map[m][bj[k]] = 0;
            }
        }

        int sum = 0, oldsum = 0;
        for (int o = 0; o < cgnum; o++) {
            IntStream stream2 = Arrays.stream(map[cg[o]]);
            sum += stream2.sum();
            if(sum - oldsum > 1) {
                jg[num] = cg[o];
                num++;
            }
            oldsum = sum;
        }

        if(sum <= cgnum) {
            num = cgnum;
            jg = cg;
        }
//        for (int k = 0; k < n; k++) {
//            for (int b = 0; b < n; b++) {
//                System.out.print(map[k][b]);
//            }
//            System.out.println();
//        }

        for(int p = 0; p < num; p++) {
            list.add(jg[p]);
        }
        return list;
    }
}

public class NO_310 {
    public static void main(String[] args) {
//        int n = 6;
//        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        int n = 6;
        int[][] edges = {{0,1},{0,2},{0,3},{3,4},{4,5}};
        System.out.print(new Solution310().findMinHeightTrees(n, edges));
    }
}
