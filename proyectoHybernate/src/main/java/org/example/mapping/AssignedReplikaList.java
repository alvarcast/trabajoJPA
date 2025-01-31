package org.example.mapping;

import java.util.ArrayList;

public class AssignedReplikaList {

    private ArrayList<AssignedReplika> assignedReplikaList = new ArrayList<AssignedReplika>();

    public AssignedReplikaList() {}

    public AssignedReplikaList(ArrayList<AssignedReplika> assignedReplikaList) {
        this.assignedReplikaList = assignedReplikaList;
    }

    public ArrayList<AssignedReplika> getAssignedReplikaList() {
        return assignedReplikaList;
    }

    public void setAssignedReplikaList(ArrayList<AssignedReplika> assignedReplikaList) {
        this.assignedReplikaList = assignedReplikaList;
    }

    public void add(AssignedReplika assignedReplika) {
        assignedReplikaList.add(assignedReplika);
    }
}
