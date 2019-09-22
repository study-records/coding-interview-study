package main;

import structure.BinaryTree;

import java.util.Random;

/**
 * check is you tree is Balanced
 */
public class Solution {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Random gen = new Random();
        for(int i=0;i<20;i++){
            int num = gen.nextInt(100);
            bt.add(num);
        }
        System.out.println(bt.isBalance());
        return;
    }

}