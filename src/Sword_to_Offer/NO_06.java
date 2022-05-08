package Sword_to_Offer;

/**
 * @author Lovsog
 * 2022/5/8
 **/

class ListNode_06 {
    int val;
    ListNode_06 next;
    ListNode_06(int x) {
        val = x;
    }
}

class Solution_06 {
    public int[] reversePrint(ListNode_06 head) {
        //先获取链表长度，创建对应长度数组
        ListNode_06 currNode = head;
        int len = 0;
        while(currNode != null){
            len ++;
            currNode = currNode.next;
        }
        int[] result = new int[len];

        //再次遍历链表，将值倒序填充至结果数组
        currNode = head;
        while(currNode != null){
            result[len - 1] = currNode.val;
            len --;
            currNode = currNode.next;
        }
        return result;
    }
}

public class NO_06 {
    public static void main(String[] args) {

    }
}
