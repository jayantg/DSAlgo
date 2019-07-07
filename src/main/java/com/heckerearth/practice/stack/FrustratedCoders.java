package com.heckerearth.practice.stack;

import javafx.util.Pair;

import java.util.*;

/**
 * https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/sniper-shooting/
 */
public class FrustratedCoders {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(s.nextInt());
        }
        Collections.sort(list);
        Stack<Pair<Integer,Integer>> stack = new Stack<>();

        for (int i :list) {
            if(!stack.isEmpty()){
                if(stack.peek().getKey() == i && stack.size() > 1){
                    Pair<Integer,Integer> temp = stack.pop();
                    pop(stack);
                    stack.push(temp);
                }else if(stack.peek().getKey() < i){
                    pop(stack);
                }
            }
            push(stack, i);
        }

        int sum = 0;
        while (!stack.isEmpty()){
            Pair<Integer,Integer> temp = stack.pop();
            sum = sum + (temp.getKey() * temp.getValue());
        }
        System.out.println(sum);
    }

    public static void pop(Stack<Pair<Integer,Integer>> stack){
        Pair<Integer,Integer> temp = stack.pop();
        if(temp.getValue() > 1){
            stack.push(new Pair<>(temp.getKey(),temp.getValue() - 1));
        }
    }

    public static void push(Stack<Pair<Integer,Integer>> stack, int i){
        if(!stack.isEmpty() && stack.peek().getKey() == i){
            Pair<Integer,Integer> temp = stack.pop();
            stack.push(new Pair<>(temp.getKey(), temp.getValue() + 1));
        }else {
            stack.push(new Pair<>(i,1));
        }
    }
}
