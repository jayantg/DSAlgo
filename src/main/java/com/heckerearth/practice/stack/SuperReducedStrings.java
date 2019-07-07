package com.heckerearth.practice.stack;

import java.util.Scanner;
import java.util.Stack;

public class SuperReducedStrings {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        char[] chars = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(!stack.isEmpty() && stack.peek().equals(c)){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        String output = "";
        while (!stack.isEmpty()){
            output = stack.pop() + output;
        }
        if(output.isEmpty()){
            System.out.println("Empty String");
        }else{
            System.out.println(output);
        }
    }
}
