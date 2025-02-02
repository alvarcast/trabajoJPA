package org.example.util;

import org.example.mapping.*;

public class Menu {

    public static void menu(){
        int opt;

        Master data = Transactions.read();

        System.out.println("\nWelcome to a signalis DB");

        do {
            System.out.println("\n\033[1;36m📜 MAIN MENU 📜\033[0m");
            System.out.println("\033[1;33m1.\033[0m View entries");
            System.out.println("\033[1;33m2.\033[0m Create entry");
            System.out.println("\033[1;33m3.\033[0m Update entry");
            System.out.println("\033[1;33m4.\033[0m Delete entry");
            System.out.println("\033[1;33m5.\033[0m Find entry");
            System.out.println("\033[1;33m6.\033[0m \033[1;31m???");
            System.out.println("\033[1;33m7.\033[0m \033[1;31mExit");

            System.out.print("\n\033[1;32m🔹 Please enter your choice: \033[0m");

            opt = Scan.scanInt(1, 7);

            switch (opt){
                case 1 -> viewMenu(data);
                case 2 -> createMenu(data);
                case 3 -> updateMenu(data);
                case 4 -> deleteMenu(data);
                case 5 -> {}
                case 6 -> {}
                case 7 -> System.out.println("\nExiting program...");
            }
        } while (opt != 7);
    }

    public static void viewMenu(Master data) {
        int opt;

        System.out.println("\n\033[1;36m\uD83D\uDD0D VIEW MENU \uD83D\uDD0D\033[0m");
        System.out.println("\033[1;33m1.\033[0m View all entries");
        System.out.println("\033[1;33m2.\033[0m View celestial bodies");
        System.out.println("\033[1;33m3.\033[0m View relevant infrastructure");
        System.out.println("\033[1;33m4.\033[0m View Replika assignation");
        System.out.println("\033[1;33m5.\033[0m View Replikas");
        System.out.println("\033[1;33m6.\033[0m \033[1;31mBack");

        System.out.print("\n\033[1;32m🔹 Please enter your choice: \033[0m");

        opt = Scan.scanInt(1, 6);

        switch (opt){
            case 1 -> Printer.printAll(data);
            case 2 -> Printer.printBodies(data.getBodyList(), false);
            case 3 -> Printer.printInf(data.getInfList(), false);
            case 4 -> Printer.printAssignedReplikas(data.getAssignedReplikaList(), false);
            case 5 -> Printer.printReplikas(data.getReplikaList(), false);
        }
    }

    public static void createMenu(Master data) {
        int opt;

        System.out.println("\n\033[1;36mSELECT TABLE:\033[0m");
        System.out.println("\033[1;33m1.\033[0m Celestial bodies");
        System.out.println("\033[1;33m2.\033[0m Relevant infrastructure");
        System.out.println("\033[1;33m3.\033[0m Replika assignation");
        System.out.println("\033[1;33m4.\033[0m Replikas");
        System.out.println("\033[1;33m5.\033[0m \033[1;31mBack");

        System.out.print("\n\033[1;32m🔹 Please enter your choice: \033[0m");

        opt = Scan.scanInt(1, 5);

        switch (opt){
            case 1 -> MenuCrtl.createEntry(new BodyList(), data);
            case 2 -> MenuCrtl.createEntry(new InfList(), data);
            case 3 -> MenuCrtl.createEntry(new AssignedReplikaList(), data);
            case 4 -> MenuCrtl.createEntry(new ReplikaList(), data);
        }
    }

    public static void updateMenu(Master data) {
        int opt;

        System.out.println("\n\033[1;36mSELECT TABLE:\033[0m");
        System.out.println("\033[1;33m1.\033[0m Celestial bodies");
        System.out.println("\033[1;33m2.\033[0m Relevant infrastructure");
        System.out.println("\033[1;33m3.\033[0m Replika assignation");
        System.out.println("\033[1;33m4.\033[0m Replikas");
        System.out.println("\033[1;33m5.\033[0m \033[1;31mBack");

        System.out.print("\n\033[1;32m🔹 Please enter your choice: \033[0m");

        opt = Scan.scanInt(1, 5);

        switch (opt){
            case 1 -> MenuCrtl.update(data.getBodyList());
            case 2 -> MenuCrtl.update(data.getInfList());
            case 3 -> MenuCrtl.update(data.getAssignedReplikaList());
            case 4 -> MenuCrtl.update(data.getReplikaList());
        }
    }

    public static void deleteMenu(Master data) {
        int opt;

        System.out.println("\n\033[1;36mSELECT TABLE:\033[0m");
        System.out.println("\033[1;33m1.\033[0m Celestial bodies");
        System.out.println("\033[1;33m2.\033[0m Relevant infrastructure");
        System.out.println("\033[1;33m3.\033[0m Replika assignation");
        System.out.println("\033[1;33m4.\033[0m Replikas");
        System.out.println("\033[1;33m5.\033[0m \033[1;31mBack");

        System.out.print("\n\033[1;32m🔹 Please enter your choice: \033[0m");

        opt = Scan.scanInt(1, 5);

        switch (opt){
            case 1 -> MenuCrtl.delete(data.getBodyList());
            case 2 -> MenuCrtl.delete(data.getInfList());
            case 3 -> MenuCrtl.delete(data.getAssignedReplikaList());
            case 4 -> MenuCrtl.delete(data.getReplikaList());
        }
    }
}
