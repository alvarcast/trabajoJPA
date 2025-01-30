package org.example.mapping;

import java.util.ArrayList;

public class BodyList {

    private ArrayList<Body> bodyList = new ArrayList<Body>();

    public BodyList () {}

    public BodyList(ArrayList<Body> bodyList) {
        this.bodyList = bodyList;
    }

    public ArrayList<Body> getBodyList() {
        return bodyList;
    }

    public void setBodyList(ArrayList<Body> bodyList) {
        this.bodyList = bodyList;
    }

    public void add(Body body) {
        bodyList.add(body);
    }
}
