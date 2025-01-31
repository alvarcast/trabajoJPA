package org.example.mapping;

import javax.persistence.*;

@Entity
@Table(name = "relevant_infrastructure")
public class Infrastructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inf_id")
    private int id;

    @Column(name = "rel_body_id")
    private int body_id;

    @Column(name = "inf_name")
    private String name;

    @Column(name = "inf_info")
    private String info;

    @Column(name = "function")
    private String function;

    public Infrastructure() {}

    public Infrastructure(int id, int body_id, String name, String info, String function) {
        this.id = id;
        this.body_id = body_id;
        this.name = name;
        this.info = info;
        this.function = function;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBody_id() {
        return body_id;
    }

    public void setBody_id(int body_id) {
        this.body_id = body_id;
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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
