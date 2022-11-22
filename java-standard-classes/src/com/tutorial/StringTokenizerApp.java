package com.tutorial;

import java.util.StringTokenizer;

public class StringTokenizerApp {

    public static void main(String[] args) {

    String mine = "Bella Rizky Kharisma";

    StringTokenizer stringToken = new StringTokenizer(mine," ");

        while(stringToken.hasMoreTokens()){
            String result = stringToken.nextToken();
            System.out.println(result);
        }
    }
}
