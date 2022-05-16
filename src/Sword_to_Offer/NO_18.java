package Sword_to_Offer;

/**
 * @author Lovsog
 * 2022/5/16
 **/


class ListNode_18 {
int val;
    ListNode_18 next;
    ListNode_18(int x) { val = x; }
}

class Solution_18 {
    public ListNode_18 deleteNode(ListNode_18 head, int val) {
        if(head.val == val)
            return head.next;
        ListNode_18 pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null)
            pre.next = cur.next;
        return head;
    }
}

public class NO_18 {
}
