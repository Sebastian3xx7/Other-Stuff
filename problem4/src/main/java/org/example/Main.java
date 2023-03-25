package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.print("password: ");
        Scanner in=new Scanner(System.in);
        String password=in.nextLine();
        System.out.println("Number of changes: "+Solution.numberOfChanges(password));

    }
}