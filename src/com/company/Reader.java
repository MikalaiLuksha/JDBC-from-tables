package com.company;

import java.util.Scanner;

public class Reader {

    public static int readerInt(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        else return -100;
    }
    public static String readerString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}