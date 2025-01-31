package org.example.mapping;

import javax.persistence.*;

@Entity
@Table(name = "celestial_bodies")
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "body_id")
    private int id;

    @Column(name = "body_name")
    private String name;

    @Column(name = "body_info")
    private String info;

    @Column(name = "allegiance")
    private String allegiance;

    public Body() {}

    public Body(int id, String name, String info, String allegiance) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.allegiance = allegiance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAllegiance() {
        return allegiance;
    }

    public void setAllegiance(String allegiance) {
        this.allegiance = allegiance;
    }
}
