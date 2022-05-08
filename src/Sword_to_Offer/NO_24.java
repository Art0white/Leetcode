package Sword_to_Offer;

/**
 * @author Lovsog
 * 2022/5/8
 **/

class ListNode_24 {
    int val;
    ListNode_24 next;
    ListNode_24(int x) {
        val = x;
    }
}

class Solution_24 {
    public ListNode_24 reverseList(ListNode_24 head) {
        ListNode_24 prev = null;
        ListNode_24 curr = head;
        while (curr != null) {
            ListNode_24 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

public class NO_24 {
    public static void main(String[] args) {

    }
}
