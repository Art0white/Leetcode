package Sword_to_Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Lovsog
 * 2022/5/16
 **/


class TreeNode_32_02 {
    int val;
    TreeNode_32_02 left;
    TreeNode_32_02 right;
    TreeNode_32_02(int x) { val = x; }
}

class Solution_32_02 {
    public List<List<Integer>> levelOrder(TreeNode_32_02 root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode_32_02> queue = new LinkedList<TreeNode_32_02>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode_32_02 node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }
}

public class NO_32_02 {
}
