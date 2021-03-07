package main.util;

import java.util.Scanner;

public class InputUtil {
    public static String requireText(String title){
        Scanner sc = new Scanner(System.in);
        System.out.println(title);
        return sc.nextLine();
    }
    public static int requireNumber(String title){
        Scanner sc = new Scanner(System.in);
        System.out.println(title);
        return sc.nextInt();
    }
}
