package org.example.mapping;

import javax.persistence.*;

@Entity
@Table(name = "replika_units")
public class Replika {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "replika_id")
    private int id;

    @Column(name = "acronym")
    private String acronym;

    @Column(name = "replika_name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "description")
    private String description;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "gender")
    private String gender;

    @Column(name = "height")
    private int height;

    public Replika() {}

    public Replika(int id, String acronym, String name, String nickname, String description, String occupation, String gender, int height) {
        this.id = id;
        this.acronym = acronym;
        this.name = name;
        this.nickname = nickname;
        this.description = description;
        this.occupation = occupation;
        this.gender = gender;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Replika{" +
                "id=" + id +
                ", acronym='" + acronym + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", description='" + description + '\'' +
                ", occupation='" + occupation + '\'' +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                '}';
    }
}
