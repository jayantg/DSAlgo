package com.heckerearth.practice.stack;

import java.util.*;

public class BalancedBrackets {
    public static Map<Character,Character> start = new HashMap<Character,Character>(){{
        put('{','}');
        put('(',')');
        put('[',']');
    }};
    public static Map<Character,Character> end = new HashMap<Character,Character>(){{
        put('}','{');
        put(')','(');
        put(']','[');
    }};
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        String[] inputs = new String[testCases];
        for (int i = 0; i < testCases; i++) {
            inputs[i] = s.next();
        }
        Arrays.stream(inputs).forEach(BalancedBrackets::balancedBrackets);
    }

    public static void balancedBrackets(String input){
        char[] chars = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        int i=0;
        for (; i < chars.length; i++) {
            char c = chars[i];
            if(start.get(c) != null){
                stack.push(c);
            }else {
                if(!stack.isEmpty() && end.get(c).equals(stack.peek())){
                    stack.pop();
                }else {
                    break;
                }
            }
        }
        if (i == chars.length && stack.isEmpty()){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
