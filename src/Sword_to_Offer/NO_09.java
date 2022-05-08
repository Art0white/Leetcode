package Sword_to_Offer;

import java.util.Stack;

/**
 * @author Lovsog
 * 2022/5/6
 **/
class CQueue {
    int num = 0;
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public CQueue() {

    }
    public void appendTail(int value) {
        num++;
        stack1.push(value);
    }
    public int deleteHead() {
        if(num == 0) {
            return -1;
        } else {
            num--;
            if(stack2.size() == 0) {
                while (stack1.size() != 0)
                    stack2.push(stack1.pop());
                return stack2.pop();
            } else {
                return stack2.pop();
            }
        }
    }
}

public class NO_09 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.deleteHead();
        System.out.println(cQueue.num);
        cQueue.appendTail(5);
        System.out.println(cQueue.num);
        cQueue.appendTail(5);
        System.out.println(cQueue.num);
        cQueue.deleteHead();
        System.out.println(cQueue.num);
        cQueue.deleteHead();
        System.out.println(cQueue.num);
        System.out.println(cQueue.stack1.toString() + cQueue.stack2.toString());
    }
}
