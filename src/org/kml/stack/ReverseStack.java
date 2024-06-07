package org.kml.stack;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);
        System.out.println(stack);
        System.out.println(reverse(stack));
    }
    static Stack<Integer> reverse(Stack<Integer> stack)
    {
        Stack<Integer> tmp = new Stack<>();
        while (!stack.isEmpty())
        {
            if (tmp.isEmpty() || stack.peek() > tmp.peek())
            {
                tmp.push(stack.pop());
            }
            else
            {
                int peekValue = tmp.pop();
                while (!tmp.isEmpty())
                {
                    stack.push(tmp.pop());
                }
            }
        }
        return tmp;
    }
}
