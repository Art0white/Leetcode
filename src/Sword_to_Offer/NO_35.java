package Sword_to_Offer;

/**
 * @author Lovsog
 * 2022/5/8
 **/
class Node_35 {
    int val;
    Node_35 next;
    Node_35 random;

    public Node_35(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution_35 {
    public Node_35 copyRandomList(Node_35 head) {
        if (head == null) {
            return null;
        }
        for (Node_35 node = head; node != null; node = node.next.next) {
            Node_35 nodeNew = new Node_35(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node_35 node = head; node != null; node = node.next.next) {
            Node_35 nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node_35 headNew = head.next;
        for (Node_35 node = head; node != null; node = node.next) {
            Node_35 nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}

public class NO_35 {
}
