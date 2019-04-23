package com.stack.geeks.practice;

import java.util.Scanner;
import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        s.nextLine();
        for (int i = 0; i < t; i++) {
            String in = s.nextLine();
            longestValidParentheses(in);
        }
    }

    private static void longestValidParentheses(String in) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int max = 0;
        for (int i = 0; i < in.length(); i++) {
            char a = in.charAt(i);
            if(a == '('){
                s.push(i);
            }else {
                s.pop();
                if (!s.empty())
                    max = Math.max(max, i - s.peek());
                else s.push(i);
            }
        }
        System.out.println(max);
    }
}
