package org.example.mapping;

public class Master {

    private BodyList bodyList;
    private InfList infList;
    private AssignedReplikaList assignedReplikaList;
    private ReplikaList replikaList;

    public Master(BodyList bodyList, InfList infList, AssignedReplikaList assignedReplikaList , ReplikaList replikaList) {
        this.bodyList = bodyList;
        this.infList = infList;
        this.assignedReplikaList = assignedReplikaList;
        this.replikaList = replikaList;
    }

    public BodyList getBodyList() {
        return bodyList;
    }

    public void setBodyList(BodyList bodyList) {
        this.bodyList = bodyList;
    }

    public InfList getInfList() {
        return infList;
    }

    public void setInfList(InfList infList) {
        this.infList = infList;
    }

    public AssignedReplikaList getAssignedReplikaList() {
        return assignedReplikaList;
    }

    public void setAssignedReplikaList(AssignedReplikaList assignedReplikaList) {
        this.assignedReplikaList = assignedReplikaList;
    }

    public ReplikaList getReplikaList() {
        return replikaList;
    }

    public void setReplikaList(ReplikaList replikaList) {
        this.replikaList = replikaList;
    }
}
