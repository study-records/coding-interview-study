package main;

import structure.Stack;
import structure.StackArray;
import java.util.Random;
/**
 * make ascending order sort
 * you can use one more stack
*/
public class Solution {
    public static void main(String [] args){
        Stack<Integer> S = new StackArray<>(10);
        Stack<Integer> S2 = new StackArray<>(10); //정렬된 stack
        Random gen = new Random();
        for(int i=0;i<20;i++){
            int num = gen.nextInt(100);
            S.push(num);
        }
        int S2_size = 0;
        while(!S.isEmpty()){
            int temp = S.peek();S.pop();
            if(S2_size==0){
                S2.push(temp);
                S2_size++;
                continue;
            }
            for(int i=0;;i++){
                if(S2.isEmpty() || S2.peek()<temp){
                    S2.push(temp);
                    for(int j=0;j<i;j++){
                        int t = S.peek();S.pop();
                        S2.push(t);
                    }
                    break;
                }
                else{
                    int k = S2.peek();S2.pop();
                    S.push(k);
                }
            }
        }
        for(int i=0;i<20;i++){
            System.out.println(S2.peek());
            S2.pop();
        }
        return;
    }
}
