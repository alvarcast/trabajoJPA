package org.example.util;

import org.example.mapping.Master;

public class Menu {

    public static void menu(){
        int opt;

        Master data = Transactions.read();

        System.out.println("\nWelcome to a signalis DB");

        do {
            opt = Scan.scanInt("""
                Please select an option bellow:
                
                1. View entries
                2. Create entry
                3. Update entry
                4. Delete entry
                5. Find entry
                6. ???
                7. Exit
                """, 1, 7
            );

            switch (opt){
                case 1 -> Menu.viewMenu(data);
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 5 -> {}
                case 6 -> {}
                case 7 -> {}
            }
        } while (opt != 7);
    }

    public static void viewMenu(Master data) {
        int opt;

        opt = Scan.scanInt("""
                Please select an option bellow:
                
                1. View all entries
                2. View celestial bodies
                3. View relevant infrastructure
                4. View assigned Replikas
                5. View Replikas
                6. Back
                """, 1, 6
        );

        switch (opt){
            case 1 -> Printer.printAll(data);
            case 2 -> Printer.printBodies(data.getBodyList(), false);
            case 3 -> Printer.printInf(data.getInfList(), false);
            case 4 -> Printer.printAssignedReplikas(data.getAssignedReplikaList(), false);
            case 5 -> Printer.printReplikas(data.getReplikaList(), false);
        }
    }
}
