package Meet;

import java.util.Arrays;

/**
 * @author Lovsog
 * 2022/5/16
 **/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution_04_06 {
    int[] arr = new int[10005];
    int num = 0;
    int over = 0;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        if(over - 1 == p.val) {
            return null;
        } else {
//            return arr[num + 1];
            return null;
        }
    }
    public void dfs (TreeNode nowNode, TreeNode p){
        if(nowNode == null) {
            return;
        }
        dfs(nowNode.left, p);
        if(nowNode.val == p.val) {
            over = num;
        }
        arr[num] = nowNode.val;
        num++;
        dfs(nowNode.right, p);
    }
}

class Solution_04_06_2 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        int target = p.val;
        TreeNode cur = root;
        TreeNode ans = null;
        while (cur != null){
            if (cur.val > target){
                ans = cur;
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }
        return ans;
    }
}

public class NO_04_06 {
    public static void main(String[] args) {

    }
}
