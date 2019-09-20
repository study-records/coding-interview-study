package main;
//import structure.Stack;
//import structure.StackArray;

import structure.Stack;
import structure.StackArray;

public class Solution {
    public static void main(String [] args){
        Stack<Integer> S = new StackArray<>(10);

        for(int i=0;i<20;i++){
            S.push(i);
        }
        for(int i=0;i<20;i++){
            System.out.println(S.peek());
            S.pop();
        }
        return;
    }
}
