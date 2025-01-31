package org.example.mapping;

import javax.persistence.*;

@Entity
@Table(name = "inf_replika")
public class AssignedReplika {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rel_id")
    private int id;

    @Column(name = "rel_inf_id")
    private int inf_id;

    @Column(name = "rel_replika_id")
    private int replika_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInf_id() {
        return inf_id;
    }

    public void setInf_id(int inf_id) {
        this.inf_id = inf_id;
    }

    public int getReplika_id() {
        return replika_id;
    }

    public void setReplika_id(int replika_id) {
        this.replika_id = replika_id;
    }
}

