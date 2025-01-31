package org.example.mapping;

import java.util.ArrayList;

public class ReplikaList {

    private ArrayList<Replika> replikaList = new ArrayList<Replika>();

    public ReplikaList () {}

    public ReplikaList(ArrayList<Replika> replikaList) {
        this.replikaList = replikaList;
    }

    public ArrayList<Replika> getReplikaList() {
        return replikaList;
    }

    public void setReplikaList(ArrayList<Replika> replikaList) {
        this.replikaList = replikaList;
    }

    public void add(Replika replika) {
        replikaList.add(replika);
    }
}
