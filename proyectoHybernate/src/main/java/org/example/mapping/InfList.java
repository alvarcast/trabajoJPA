package org.example.mapping;

import java.util.ArrayList;

public class InfList {

    private ArrayList<Infrastructure> infrastructureList = new ArrayList<Infrastructure>();

    public InfList () {}

    public InfList(ArrayList<Infrastructure> infrastructureList) {
        this.infrastructureList = infrastructureList;
    }

    public ArrayList<Infrastructure> getInfrastructureList() {
        return infrastructureList;
    }

    public void setInfrastructureList(ArrayList<Infrastructure> infrastructureList) {
        this.infrastructureList = infrastructureList;
    }

    public void add(Infrastructure infrastructure) {
        infrastructureList.add(infrastructure);
    }
}
