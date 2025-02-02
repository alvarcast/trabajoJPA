package org.example.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Scan {

    //Metodo para pedir un int dentro de un rango
    public static int scanInt(String txt, int min, int max){
        Scanner scn = new Scanner(System.in);
        boolean out = false;
        int data = 0;

        do {
            System.out.println(txt);

            try {
                data = scn.nextInt();
                if (data < min){
                    System.err.println("The input value is less than the minimum (" + min + ")");
                } else if (data > max) {
                    System.err.println("The input value is more than the maximum (" + max + ")");
                } else {
                    out = true;
                }
            } catch (InputMismatchException ex){
                System.err.println("Invalid input, try again");
            }

            scn.nextLine();

        } while (!out);

        return data;
    }

    public static int scanInt(int min, int max){
        Scanner scn = new Scanner(System.in);
        boolean out = false;
        int data = 0;

        do {
            try {
                data = scn.nextInt();
                if (data < min){
                    System.err.println("The input value is less than the minimum (" + min + ")");
                } else if (data > max) {
                    System.err.println("The input value is more than the maximum (" + max + ")");
                } else {
                    out = true;
                }
            } catch (InputMismatchException ex){
                System.err.println("Invalid input, try again");
            }

            scn.nextLine();

        } while (!out);

        return data;
    }

    //Metodo para pedir una cadena con límite de caracteres
    public static String scanText(String txt, int limit){
        Scanner scn = new Scanner(System.in);
        String data = "";
        boolean exceed = false;

        while (data.isEmpty() || exceed){
            System.out.println(txt);
            data = scn.nextLine();

            if (data.isEmpty()){
                System.err.println("Please, input something");
            }

            exceed = data.length() > limit;

            if (exceed) {
                System.err.printf("The string is to long, the maximum allowed is %s \n", limit);
            }
        }

        return data;
    }

    public static String scanText(int limit){
        Scanner scn = new Scanner(System.in);
        String data = "";
        boolean exceed = false;

        while (data.isEmpty() || exceed){
            data = scn.nextLine();

            if (data.isEmpty()){
                System.err.println("Please, input something");
            }

            exceed = data.length() > limit;

            if (exceed) {
                System.err.printf("The string is to long, the maximum allowed is %s \n", limit);
            }
        }

        return data;
    }

    //Metodo que espera hasta que se dé cualquier valor para continuar (enter)
    public static void waitForInput() {
        Scanner scn = new Scanner(System.in);

        System.out.println("\n\033[1;37m╔════════════════════════════╗");
        System.out.println("║  \033[1;37m PRESS ENTER TO CONTINUE  \033[1;37m║");
        System.out.println("╚════════════════════════════╝\033[0m");

        String input = scn.nextLine().trim();
    }
}
