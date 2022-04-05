/**
 * LeetCode 2.两数之和
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), tail = head;
        int sum = 0;
        while(l1 != null || l2 != null || (tail != head && sum !=0)) {
            if(l1 !=null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 !=null) {
                sum += l2.val;
                l2 = l2.next;
            }
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            sum /= 10;
        }
        return head.next;
    }
}
public class NO_2 {
    public static void main(String[] args) {

    }
}
