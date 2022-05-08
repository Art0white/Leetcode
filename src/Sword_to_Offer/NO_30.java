package Sword_to_Offer;

/**
 * @author Lovsog
 * 2022/5/6
 **/
class MinStack_30 {
    int[] arr;
    int[] min;
    int minval;
    int num;

    /** initialize your data structure here. */
    public MinStack_30() {
        arr = new int[100005];
        min = new int[100005];
        minval = Integer.MAX_VALUE;
        min[0] = minval;
        num = 0;
    }

    public void push(int x) {
        ++num;
        arr[num] = x;
        if(x < minval) {
            minval = x;
        }
        min[num] = minval;
    }

    public void pop() {
        --num;
        minval = min[num];
    }

    public int top() {
        return arr[num];
    }

    public int min() {
        if(num == 0) {
            return -1;
        } else {
            return minval;
        }
    }
}

public class NO_30 {
    public static void main(String[] args) {
        MinStack_30 minStack = new MinStack_30();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}
