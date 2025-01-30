package org.example.mapping;

public class Master {

    BodyList bodyList;
    InfList infList;
    ReplikaList replikaList;

    public Master(BodyList bodyList, InfList infList, ReplikaList replikaList) {
        this.bodyList = bodyList;
        this.infList = infList;
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

    public ReplikaList getReplikaList() {
        return replikaList;
    }

    public void setReplikaList(ReplikaList replikaList) {
        this.replikaList = replikaList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Master Data ===\n");

        sb.append("\n🌌 Celestial Bodies:\n");
        for (Body b : bodyList.getBodyList()) {
            sb.append(" - ").append(b).append("\n");
        }

        sb.append("\n🏗️ Infrastructure:\n");
        for (Infrastructure i : infList.getBodyList()) {
            sb.append(" - ").append(i).append("\n");
        }

        sb.append("\n🤖 Replika Units:\n");
        for (Replika r : replikaList.getBodyList()) {
            sb.append(" - ").append(r).append("\n");
        }

        return sb.toString();
    }

}
