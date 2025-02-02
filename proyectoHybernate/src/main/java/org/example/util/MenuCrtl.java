package org.example.util;

import org.example.mapping.*;

import java.util.ArrayList;
import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public class MenuCrtl {

    public static void createEntry(Object itemList, Master data) {
        ArrayList<?> list;
        Supplier<Object> function;
        Object object;
        int itemCount;

        System.out.print("\n\033[1;32m🔹 Number of entries to add: \033[0m");
        itemCount = Scan.scanInt(1, 10);

        switch (itemList) {
            case BodyList bodyList -> {
                function = MenuCrtl::createBody;
                list = bodyList.getBodyList();
            }
            case InfList infList -> {
                function = MenuCrtl::createInfrastructure;
                list = infList.getInfrastructureList();
            }
            case AssignedReplikaList assignedReplikaList -> {
                function = MenuCrtl::createAssignedReplika;
                list = assignedReplikaList.getAssignedReplikaList();
            }
            default -> {
                function = MenuCrtl::createReplika;
                list = ((ReplikaList) itemList).getReplikaList();
            }
        }

        ArrayList<Object> objectList = (ArrayList<Object>) list;

        for (int i = 0; i < itemCount; i++) {
            object = function.get();
            objectList.add(object);
            Transactions.create(objectList);

            switch (itemList) {
                case BodyList _ -> data.getBodyList().add((Body) object);
                case InfList _ -> data.getInfList().add((Infrastructure) object);
                case AssignedReplikaList _ -> data.getAssignedReplikaList().add((AssignedReplika) object);
                default -> data.getReplikaList().add((Replika) object);
            }
        }
    }

    private static Body createBody() {
        String name;
        String info;
        String allegiance;

        int opt;

        System.out.print("\n\033[1;32m🔹 Body name: \033[0m");
        name = Scan.scanText(18);

        System.out.print("\n\033[1;32m🔹 Body information: \033[0m");
        info = Scan.scanText(1000);

        System.out.println("\n\033[1;36mSELECT ALLEGIANCE:\033[0m");
        System.out.println("\033[1;33m1.\033[0m The Empire");
        System.out.println("\033[1;33m2.\033[0m Eusan Nation");
        System.out.println("\033[1;33m3.\033[0m Disputed");
        System.out.println("\033[1;33m4.\033[0m None");

        System.out.print("\n\033[1;32m🔹 Please enter your choice: \033[0m");
        opt = Scan.scanInt(1, 4);

        allegiance = switch (opt) {
            case 1 -> "The Empire";
            case 2 -> "Eusan Nation";
            case 3 -> "Disputed";
            default -> "None";
        };

        return new Body(name, info, allegiance);
    }

    private static Infrastructure createInfrastructure() {
        ArrayList<Body> bodyList;

        int body_id;
        String name;
        String info;
        String function;

        System.out.print("\n\033[1;32m🔹 Infrastructure name: \033[0m");
        name = Scan.scanText(100);

        System.out.print("\n\033[1;32m🔹 Infrastructure information: \033[0m");
        info = Scan.scanText(1000);

        System.out.print("\n\033[1;32m🔹 Infrastructure function/s: \033[0m");
        function = Scan.scanText(500);

        bodyList = Transactions.read().getBodyList().getBodyList();

        for (Body body : bodyList) {
            System.out.printf("\n\033[1;36m- ID:\033[0m %d\n\033[1;32m  Name:\033[0m %s\n\n",
                    body.getId(), body.getName());
        }

        System.out.print("\n\033[1;32m🔹 Please select the planet the infrastructure is in (ID): \033[0m");
        body_id = Scan.scanInt(1, bodyList.size());

        return new Infrastructure(body_id, name, info, function);
    }

    private static AssignedReplika createAssignedReplika() {
        ArrayList<Infrastructure> infList;
        ArrayList<Replika> replikaList;

        int inf_id;
        int replika_id;

        infList = Transactions.read().getInfList().getInfrastructureList();
        replikaList = Transactions.read().getReplikaList().getReplikaList();

        for (Replika replika : replikaList) {
            System.out.printf("\n\033[1;36m- ID:\033[0m %d\n\033[1;32m  Name:\033[0m %s\n\n",
                    replika.getId(), replika.getAcronym());
        }

        System.out.print("\n\033[1;32m🔹 Please select the replika (ID): \033[0m");
        replika_id = Scan.scanInt(1, replikaList.size());

        for (Infrastructure infrastructure : infList) {
            System.out.printf("\n\033[1;36m- ID:\033[0m %d\n\033[1;32m  Name:\033[0m %s\n\n",
                    infrastructure.getId(), infrastructure.getName());
        }

        System.out.print("\n\033[1;32m🔹 Please select the infrastructore to assign that replika to (ID): \033[0m");
        inf_id = Scan.scanInt(1, infList.size());

        return new AssignedReplika(inf_id, replika_id);
    }

    private static Replika createReplika() {
        String acronym;
        String name;
        String nickname;
        String description;
        String occupation;
        String gender;
        int height;

        int opt;

        System.out.print("\n\033[1;32m🔹 Replika acronym: \033[0m");
        acronym = Scan.scanText(4);

        System.out.print("\n\033[1;32m🔹 Replika name: \033[0m");
        name = Scan.scanText(100);

        System.out.print("\n\033[1;32m🔹 Replika nickname: \033[0m");
        nickname = Scan.scanText(20);

        System.out.print("\n\033[1;32m🔹 Replika description: \033[0m");
        description = Scan.scanText(1000);

        System.out.print("\n\033[1;32m🔹 Replika occupation: \033[0m");
        occupation = Scan.scanText(300);

        System.out.println("\n\033[1;36mSELECT GENDER:\033[0m");
        System.out.println("\033[1;33m1.\033[0m Female");
        System.out.println("\033[1;33m2.\033[0m Male");

        System.out.print("\n\033[1;32m🔹 Please enter your choice: \033[0m");
        opt = Scan.scanInt(1, 2);

        if (opt == 2) {
            gender = "Male";
        } else {
            gender = "Female";
        }

        System.out.print("\n\033[1;32m🔹 Replika height (cm): \033[0m");
        height = Scan.scanInt(50, 500);

        return new Replika(acronym, name, nickname, description, occupation, gender, height);
    }

    public static void update(Object itemList) {
        if (itemList instanceof BodyList bodyList) {
            updateBody(bodyList);
        } else if (itemList instanceof InfList infList) {
            updateInfrastructure(infList);
        } else if (itemList instanceof AssignedReplikaList assignedReplikaList) {
            updateAssignedReplika(assignedReplikaList);
        } else if (itemList instanceof ReplikaList replikaList) {
            updateReplika(replikaList);
        }
    }

    public static void updateBody(BodyList bodyList) {
        int opt;
        String newString;
        int body_id;

        for (Body body : bodyList.getBodyList()) {
            System.out.printf("\n\033[1;36m- ID:\033[0m %d\n\033[1;32m  Name:\033[0m %s\n\n",
                    body.getId(), body.getName());
        }

        System.out.print("\n\033[1;32m🔹 Please select the planet to update (ID): \033[0m");
        body_id = Scan.scanInt(1, bodyList.getBodyList().size());

        System.out.println("\n\033[1;36mSELECT COLUMN:\033[0m");
        System.out.println("\033[1;33m1.\033[0m Body name");
        System.out.println("\033[1;33m2.\033[0m Body information");
        System.out.println("\033[1;33m3.\033[0m Body allegiance");
        System.out.println("\033[1;33m4.\033[0m \033[1;31mBack");

        opt = Scan.scanInt(1, 4);

        switch (opt) {
            case 1 -> {
                System.out.print("\n\033[1;32m🔹 New name: \033[0m");
                newString = Scan.scanText(18);
                bodyList.getBodyList().get(body_id).setName(newString);
            }
            case 2 -> {
                System.out.print("\n\033[1;32m🔹 New information: \033[0m");
                newString = Scan.scanText(1000);
                bodyList.getBodyList().get(body_id).setInfo(newString);
            }
            case 3 -> {
                System.out.println("\n\033[1;36mSELECT ALLEGIANCE:\033[0m");
                System.out.println("\033[1;33m1.\033[0m The Empire");
                System.out.println("\033[1;33m2.\033[0m Eusan Nation");
                System.out.println("\033[1;33m3.\033[0m Disputed");
                System.out.println("\033[1;33m4.\033[0m None");

                System.out.print("\n\033[1;32m🔹 Please enter your choice: \033[0m");
                opt = Scan.scanInt(1, 4);

                newString = switch (opt) {
                    case 1 -> "The Empire";
                    case 2 -> "Eusan Nation";
                    case 3 -> "Disputed";
                    default -> "None";
                };

                bodyList.getBodyList().get(body_id).setAllegiance(newString);
            }
        }

        Transactions.update(bodyList);
    }

    public static void updateInfrastructure(InfList infList) {
        int opt;
        int newInt;
        String newString;
        int inf_id;

        for (Infrastructure infrastructure : infList.getInfrastructureList()) {
            System.out.printf("\n\033[1;36m- ID:\033[0m %d\n\033[1;32m  Name:\033[0m %s\n\n",
                    infrastructure.getId(), infrastructure.getName());
        }

        System.out.print("\n\033[1;32m🔹 Please select the infrastructure to update (ID): \033[0m");
        inf_id = Scan.scanInt(1, infList.getInfrastructureList().size());

        System.out.println("\n\033[1;36mSELECT COLUMN:\033[0m");
        System.out.println("\033[1;33m1.\033[0m Location (Body id)");
        System.out.println("\033[1;33m2.\033[0m Infrastructure name");
        System.out.println("\033[1;33m3.\033[0m Infrastructure information");
        System.out.println("\033[1;33m4.\033[0m Infrastructure function");
        System.out.println("\033[1;33m5.\033[0m \033[1;31mBack");

        opt = Scan.scanInt(1, 5);

        switch (opt) {
            case 1 -> {
                ArrayList<Body> bodyList = Transactions.read().getBodyList().getBodyList();

                for (Body body : bodyList) {
                    System.out.printf("\n\033[1;36m- ID:\033[0m %d\n\033[1;32m  Name:\033[0m %s\n\n",
                            body.getId(), body.getName());
                }

                System.out.print("\n\033[1;32m🔹 Please select the new planet the infrastructure is in (ID): \033[0m");
                newInt = Scan.scanInt(1, bodyList.size());

                infList.getInfrastructureList().get(inf_id).setBody_id(newInt);
            }
            case 2 -> {
                System.out.print("\n\033[1;32m🔹 New name: \033[0m");
                newString = Scan.scanText(100);
                infList.getInfrastructureList().get(inf_id).setName(newString);
            }
            case 3 -> {
                System.out.print("\n\033[1;32m🔹 New information: \033[0m");
                newString = Scan.scanText(1000);
                infList.getInfrastructureList().get(inf_id).setInfo(newString);
            }
            case 4 -> {
                System.out.print("\n\033[1;32m🔹 New functions: \033[0m");
                newString = Scan.scanText(500);
                infList.getInfrastructureList().get(inf_id).setFunction(newString);
            }
        }

        Transactions.update(infList);
    }

    public static void updateAssignedReplika(AssignedReplikaList assignedReplikaList) {
        int opt;
        int newInt;

        int assignedReplika_id;

        ArrayList<Infrastructure> infList;
        ArrayList<Replika> replikaList;

        infList = Transactions.read().getInfList().getInfrastructureList();
        replikaList = Transactions.read().getReplikaList().getReplikaList();

        for (AssignedReplika assigned : assignedReplikaList.getAssignedReplikaList()) {
            System.out.printf("\033[1;36m- ID:\033[0m %d\n\033[1;32m  Infrastructure ID:\033[0m %d\n\033[1;33m  Replika ID:\033[0m %d\n\n",
                    assigned.getId(), assigned.getInf_id(), assigned.getReplika_id());
        }

        System.out.print("\n\033[1;32m🔹 Please select the relation to update (ID): \033[0m");
        assignedReplika_id = Scan.scanInt(1, assignedReplikaList.getAssignedReplikaList().size());

        System.out.println("\n\033[1;36mSELECT COLUMN:\033[0m");
        System.out.println("\033[1;33m1.\033[0m Infrastructure ID");
        System.out.println("\033[1;33m2.\033[0m Replika ID");
        System.out.println("\033[1;33m3.\033[0m \033[1;31mBack");

        opt = Scan.scanInt(1, 3);

        switch (opt) {
            case 1 -> {
                for (Infrastructure infrastructure : infList) {
                    System.out.printf("\n\033[1;36m- ID:\033[0m %d\n\033[1;32m  Name:\033[0m %s\n\n",
                            infrastructure.getId(), infrastructure.getName());
                }

                System.out.print("\n\033[1;32m🔹 Please select the infrastructure to update: \033[0m");
                newInt = Scan.scanInt(1, infList.size());

                assignedReplikaList.getAssignedReplikaList().get(assignedReplika_id).setInf_id(newInt);
            }
            case 2 -> {
                for (Replika replika : replikaList) {
                    System.out.printf("\n\033[1;36m- ID:\033[0m %d\n\033[1;32m  Name:\033[0m %s\n\n",
                            replika.getId(), replika.getAcronym());
                }

                System.out.print("\n\033[1;32m🔹 Please select the replika (ID): \033[0m");
                newInt = Scan.scanInt(1, replikaList.size());

                assignedReplikaList.getAssignedReplikaList().get(assignedReplika_id).setReplika_id(newInt);
            }
        }

        Transactions.update(assignedReplikaList);
    }

    public static void updateReplika(ReplikaList replikaList) {
        int opt;
        String newString;
        int newInt;
        int replika_id;

        for (Replika replika : replikaList.getReplikaList()) {
            System.out.printf("\n\033[1;36m- ID:\033[0m %d\n\033[1;32m  Name:\033[0m %s\n\n",
                    replika.getId(), replika.getAcronym());
        }

        System.out.print("\n\033[1;32m🔹 Please select the replika unit to update (ID): \033[0m");
        replika_id = Scan.scanInt(1, replikaList.getReplikaList().size());

        System.out.println("\n\033[1;36mSELECT COLUMN:\033[0m");
        System.out.println("\033[1;33m1.\033[0m Replika acronym");
        System.out.println("\033[1;33m2.\033[0m Replika name");
        System.out.println("\033[1;33m3.\033[0m Replika nickname");
        System.out.println("\033[1;33m4.\033[0m Replika description");
        System.out.println("\033[1;33m5.\033[0m Replika occupation");
        System.out.println("\033[1;33m6.\033[0m Replika gender");
        System.out.println("\033[1;33m7.\033[0m Replika height");
        System.out.println("\033[1;33m8.\033[0m \033[1;31mBack");

        opt = Scan.scanInt(1, 8);

        switch (opt) {
            case 1 -> {
                System.out.print("\n\033[1;32m🔹 New acronym: \033[0m");
                newString = Scan.scanText(4);
                replikaList.getReplikaList().get(replika_id).setAcronym(newString);
            }
            case 2 -> {
                System.out.print("\n\033[1;32m🔹 New name: \033[0m");
                newString = Scan.scanText(100);
                replikaList.getReplikaList().get(replika_id).setName(newString);
            }
            case 3 -> {
                System.out.print("\n\033[1;32m🔹 New nickname: \033[0m");
                newString = Scan.scanText(20);
                replikaList.getReplikaList().get(replika_id).setNickname(newString);
            }
            case 4 -> {
                System.out.print("\n\033[1;32m🔹 New description: \033[0m");
                newString = Scan.scanText(1000);
                replikaList.getReplikaList().get(replika_id).setDescription(newString);
            }
            case 5 -> {
                System.out.print("\n\033[1;32m🔹 New occupation/s: \033[0m");
                newString = Scan.scanText(100);
                replikaList.getReplikaList().get(replika_id).setOccupation(newString);
            }
            case 6 -> {
                System.out.println("\n\033[1;36mSELECT NEW GENDER:\033[0m");
                System.out.println("\033[1;33m1.\033[0m Female");
                System.out.println("\033[1;33m2.\033[0m Male");

                System.out.print("\n\033[1;32m🔹 Please enter your choice: \033[0m");
                opt = Scan.scanInt(1, 2);

                if (opt == 2) {
                    newString = "Male";
                } else {
                    newString = "Female";
                }

                replikaList.getReplikaList().get(replika_id).setGender(newString);
            }
            case 7 -> {
                System.out.print("\n\033[1;32m🔹 New height: \033[0m");
                newInt = Scan.scanInt(50, 500);
                replikaList.getReplikaList().get(replika_id).setHeight(newInt);
            }
        }

        Transactions.update(replikaList);
    }

    public static void delete(Object itemList) {
        if (itemList instanceof BodyList bodyList) {
            deleteBody(bodyList);
        } else if (itemList instanceof InfList infList) {
            deleteInfrastructure(infList);
        } else if (itemList instanceof AssignedReplikaList assignedReplikaList) {
            deleteAssignedReplika(assignedReplikaList);
        } else if (itemList instanceof ReplikaList replikaList) {
            deleteReplika(replikaList);
        }

        System.out.println("\n\033[1;32mEntity/s deleted correctly\033[0m");
    }

    public static void deleteBody(BodyList bodyList) {
        InfList infList;
        int body_id;
        int opt;

        for (Body body : bodyList.getBodyList()) {
            System.out.printf("\n\033[1;36m- ID:\033[0m %d\n\033[1;32m  Name:\033[0m %s\n\n",
                    body.getId(), body.getName());
        }

        System.out.print("\n\033[1;32m🔹 Please select the planet to delete (ID): \033[0m");
        body_id = Scan.scanInt(1, bodyList.getBodyList().size());

        System.out.println("\n\033[1;36mPROCEED (THIS WILL DELETE EVERY INFRASTRUCTURE RELATED TO THET PLANET):\033[0m");
        System.out.println("\033[1;33m1.\033[0m Yes");
        System.out.println("\033[1;33m2.\033[0m No");

        System.out.print("\n\033[1;32m🔹 Please enter your choice: \033[0m");
        opt = Scan.scanInt(1, 2);

        if (opt == 1) {
            infList = Transactions.read().getInfList();

            for (Infrastructure infrastructure : infList.getInfrastructureList()) {
                if (infrastructure.getBody_id() == body_id) {
                    infList.getInfrastructureList().remove(infrastructure);
                    Transactions.delete(infrastructure);
                }
            }

            bodyList.getBodyList().remove(bodyList.getBodyList().get(body_id));
            Transactions.delete(bodyList.getBodyList().get(body_id));
        }
    }

    public static void deleteInfrastructure(InfList infList) {
        AssignedReplikaList assignedReplikaList;
        int inf_id;
        int opt;

        for (Infrastructure infrastructure : infList.getInfrastructureList()) {
            System.out.printf("\n\033[1;36m- ID:\033[0m %d\n\033[1;32m  Name:\033[0m %s\n\n",
                    infrastructure.getId(), infrastructure.getName());
        }

        System.out.print("\n\033[1;32m🔹 Please select the infrastructure to delete (ID): \033[0m");
        inf_id = Scan.scanInt(1, infList.getInfrastructureList().size());

        System.out.println("\n\033[1;36mPROCEED (THIS WILL DELETE ALL ITS RELATIONS):\033[0m");
        System.out.println("\033[1;33m1.\033[0m Yes");
        System.out.println("\033[1;33m2.\033[0m No");

        System.out.print("\n\033[1;32m🔹 Please enter your choice: \033[0m");
        opt = Scan.scanInt(1, 2);

        if (opt == 1) {
            assignedReplikaList = Transactions.read().getAssignedReplikaList();

            for (AssignedReplika assignedReplika : assignedReplikaList.getAssignedReplikaList()) {
                if (assignedReplika.getInf_id() == inf_id) {
                    assignedReplikaList.getAssignedReplikaList().remove(assignedReplika);
                    Transactions.delete(assignedReplika);
                }
            }

            infList.getInfrastructureList().remove(infList.getInfrastructureList().get(inf_id));
            Transactions.delete(infList.getInfrastructureList().get(inf_id));
        }
    }

    public static void deleteAssignedReplika(AssignedReplikaList assignedReplikaList) {
        int assignedReplika_id;
        int opt;

        for (AssignedReplika assigned : assignedReplikaList.getAssignedReplikaList()) {
            System.out.printf("\033[1;36m- ID:\033[0m %d\n\033[1;32m  Infrastructure ID:\033[0m %d\n\033[1;33m  Replika ID:\033[0m %d\n\n",
                    assigned.getId(), assigned.getInf_id(), assigned.getReplika_id());
        }

        System.out.print("\n\033[1;32m🔹 Please select the relation to delete (ID): \033[0m");
        assignedReplika_id = Scan.scanInt(1, assignedReplikaList.getAssignedReplikaList().size());

        System.out.println("\n\033[1;36mPROCEED (THIS WILL DELETE ALL ITS RELATIONS):\033[0m");
        System.out.println("\033[1;33m1.\033[0m Yes");
        System.out.println("\033[1;33m2.\033[0m No");

        System.out.print("\n\033[1;32m🔹 Please enter your choice: \033[0m");
        opt = Scan.scanInt(1, 2);

        if (opt == 1) {
            assignedReplikaList.getAssignedReplikaList().remove(assignedReplikaList.getAssignedReplikaList().get(assignedReplika_id));
            Transactions.delete(assignedReplikaList.getAssignedReplikaList().get(assignedReplika_id));
        }
    }

    public static void deleteReplika(ReplikaList replikaList) {
        AssignedReplikaList assignedReplikaList;
        int replika_id;
        int opt;

        for (Replika replika : replikaList.getReplikaList()) {
            System.out.printf("\n\033[1;36m- ID:\033[0m %d\n\033[1;32m  Name:\033[0m %s\n\n",
                    replika.getId(), replika.getAcronym());
        }

        System.out.print("\n\033[1;32m🔹 Please select the replika unit to delete (ID): \033[0m");
        replika_id = Scan.scanInt(1, replikaList.getReplikaList().size());

        System.out.println("\n\033[1;36mPROCEED:\033[0m");
        System.out.println("\033[1;33m1.\033[0m Yes");
        System.out.println("\033[1;33m2.\033[0m No");

        System.out.print("\n\033[1;32m🔹 Please enter your choice: \033[0m");
        opt = Scan.scanInt(1, 2);

        if (opt == 1) {
            assignedReplikaList = Transactions.read().getAssignedReplikaList();

            for (AssignedReplika assignedReplika : assignedReplikaList.getAssignedReplikaList()) {
                if (assignedReplika.getInf_id() == replika_id) {
                    assignedReplikaList.getAssignedReplikaList().remove(assignedReplika);
                    Transactions.delete(assignedReplika);
                }
            }

            replikaList.getReplikaList().remove(replikaList.getReplikaList().get(replika_id));
            Transactions.delete(replikaList.getReplikaList().get(replika_id));
        }
    }
}
