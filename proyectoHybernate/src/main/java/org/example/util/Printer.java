package org.example.util;

import org.example.mapping.*;

public class Printer {

    public static void printAll(Master data) {
        System.out.println("\n\033[1;35m✨ MASTER DATA ✨\033[0m");

        printBodies(data.getBodyList(), true);
        printInf(data.getInfList(), true);
        printAssignedReplikas(data.getAssignedReplikaList(), true);
        printReplikas(data.getReplikaList(), true);

        System.out.println("\n\033[1;35m✨ END OF DATA ✨\033[0m\n");

        Scan.waitForInput();
    }

    public static void printBodies(BodyList bodyList, boolean master) {
        // Imprimir los cuerpos celestiales
        System.out.println("\n\033[1;34m🌍 Celestial Bodies:\033[0m");
        for (Body body : bodyList.getBodyList()) {
            System.out.printf("\033[1;36m- ID:\033[0m %d\n\033[1;32m  Name:\033[0m %s\n\033[1;33m  Info:\033[0m %s\n\033[1;31m  Allegiance:\033[0m %s\n\n",
                    body.getId(), body.getName(), formatText(body.getInfo()), body.getAllegiance());
        }

        if (!master) {
            Scan.waitForInput();
        }
    }

    public static void printInf(InfList infList, boolean master) {
        // Imprimir infraestructuras
        System.out.println("\n\033[1;34m🏗️ Relevant Infrastructure:\033[0m");
        for (Infrastructure inf : infList.getInfrastructureList()) {
            System.out.printf("\033[1;36m- ID:\033[0m %d\n\033[1;32m  Name:\033[0m %s\n\033[1;33m  Info:\033[0m %s\n\033[1;31m  Function:\033[0m %s\n\n",
                    inf.getId(), inf.getName(), formatText(inf.getInfo()), inf.getFunction());
        }

        if (!master) {
            Scan.waitForInput();
        }
    }

    public static void printAssignedReplikas(AssignedReplikaList assignedReplikaList, boolean master) {
        // Imprimir asignaciones de réplicas
        System.out.println("\n\033[1;34m🔗 Assigned Replikas:\033[0m");
        for (AssignedReplika assigned : assignedReplikaList.getAssignedReplikaList()) {
            System.out.printf("\033[1;36m- ID:\033[0m %d\n\033[1;32m  Infrastructure ID:\033[0m %d\n\033[1;33m  Replika ID:\033[0m %d\n\n",
                    assigned.getId(), assigned.getInf_id(), assigned.getReplika_id());
        }

        if (!master) {
            Scan.waitForInput();
        }
    }

    public static void printReplikas(ReplikaList replikaList, boolean master) {
        // Imprimir réplicas
        System.out.println("\n\033[1;34m🤖 Replikas:\033[0m");
        for (Replika replika : replikaList.getReplikaList()) {
            System.out.printf("\033[1;36m- ID:\033[0m %d\n\033[1;32m  Acronym:\033[0m %s\n\033[1;33m  Name:\033[0m %s\n\033[1;31m  Nickname:\033[0m %s\n\033[1;35m  Description:\033[0m %s\n\033[1;35m  Occupation:\033[0m %s\n\033[1;34m  Gender:\033[0m %s\n\033[1;36m  Height:\033[0m %d cm\n\n",
                    replika.getId(), replika.getAcronym(), replika.getName(), replika.getNickname(),
                    formatText(replika.getDescription()), replika.getOccupation(), replika.getGender(), replika.getHeight());
        }

        if (!master) {
            Scan.waitForInput();
        }
    }

    private static String formatText(String text) {
        return text.replaceAll("\\n", "\n  ");
    }
}
