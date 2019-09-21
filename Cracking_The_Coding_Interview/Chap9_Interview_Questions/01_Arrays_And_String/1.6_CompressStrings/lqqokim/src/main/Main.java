package src.main;

import src.CompressStrings;

public class Main {

    public static void main(String[] args) {

        String test = "AAaabccccaaa";
        CompressStrings cs = new CompressStrings();

        System.out.println("결과: " + cs.compress(test));
    }
}