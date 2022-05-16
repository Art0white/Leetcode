package Sword_to_Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Lovsog
 * 2022/5/16
 **/


class TreeNode_32_01 {
    int val;
    TreeNode_32_01 left;
    TreeNode_32_01 right;
    TreeNode_32_01(int x) { val = x; }
}

class Solution_32_01 {
    public int[] levelOrder(TreeNode_32_01 root) {
        if(root == null) return new int[0];
        Queue<TreeNode_32_01> queue = new LinkedList<TreeNode_32_01>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode_32_01 node = queue.poll();
            ans.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}

public class NO_32_01 {
}
