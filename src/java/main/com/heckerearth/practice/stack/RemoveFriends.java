package com.heckerearth.practice.stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class RemoveFriends {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tc = s.nextInt();
        Input inputs[]= new Input[tc];
        for (int i = 0; i < tc; i++) {
            int num = s.nextInt();
            int rem = s.nextInt();
            Integer[] list = new Integer[num];
            for (int j = 0; j < num; j++) {
                list[j] = s.nextInt();
            }
            inputs[i] = new Input(rem, list);
        }
        Arrays.stream(inputs).forEach(RemoveFriends::removeFriends);

    }

    public static void removeFriends(Input input){
        Stack<Integer> stack = new Stack<>();
        Integer[] list = input.list;
        int alen = list.length;
        int elen = list.length - input.del;

        for (int i = 0; i < list.length && elen<alen; i++) {
            while (!stack.isEmpty() && list[stack.peek()] < list[i]  && elen<alen){
                list[stack.peek()] = -1;
                stack.pop();
                alen --;
            }
            stack.push(i);
        }
        System.out.println(input);
    }
}

class Input{
    int del;
    Integer list[];

    public Input(int del, Integer[] list) {
        this.del = del;
        this.list = list;
    }

    @Override
    public String toString() {
        String string = "";
        for (Integer i: list
        ) {
            if(i != -1){
                string = string + i + " ";
            }
        }
        return string;
    }
}

