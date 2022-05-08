package Meet;

import java.util.Stack;

/**
 * @author Lovsog
 * 2022/4/19
 **/
class Meet_1 {
    public int Huiwengzichuang(String str) {
        int max = 0,tmax = 0;
        int jilu = 0;
        int temp = 0;
        char[] newStr = str.toCharArray();

        Stack<Character> stack = new Stack<>();
        for(int j = 0; j < newStr.length; j++) {
            System.out.println(temp);
            if(stack.size() == 0) {
                stack.push(newStr[j]);
                temp = newStr[j];
            } else {
                if(newStr[j] - stack.peek() == 0) {
                    if(temp - newStr[j] == -1) {
                        stack.pop();
                        temp = stack.peek();
                        tmax++;
                    }else {
                        temp = stack.peek();
                        stack.push(newStr[j]);
                        if(tmax > max) {
                            max = tmax;
                        }
                        tmax = 0;
                    }
                } else {
                    temp = stack.peek();
                    stack.push(newStr[j]);
                    if(tmax > max) {
                        max = tmax;
                    }
                    tmax = 0;
                }
            }
        }
        System.out.println(stack);
        return max*2;
    }
}

public class NO_1 {
    public static void main(String[] args) {
        System.out.println(new Meet_1().Huiwengzichuang("aabccba"));
    }
}

